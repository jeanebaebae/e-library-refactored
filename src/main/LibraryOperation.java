package main;

import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class LibraryOperation {

    private Vector<Book> books = new Vector<>();
    private Vector<Member> members = new Vector<>();
    private Vector<Transaction> transactions = new Vector<>();
    private Person currentUser;

    public Person getCurrentUser() {
        return currentUser;
    }
    
    public Vector<Transaction> getTransactions() {
        return transactions;
    }
    
    public void setCurrentUser(Person user) {
        this.currentUser = user;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Vector<Book> getBooks() {
        return books;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void borrowBook(String title) throws LibraryException {

        if (!(currentUser instanceof Member)) {
            throw new LibraryException("Hanya member yang dapat meminjam buku");
        }

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {

                if (!b.isAvailable()) {
                    throw new LibraryException("Buku sedang dipinjam");
                }

                b.borrow();
                transactions.add(new Transaction((Member) currentUser, b));
                return;
            }
        }

        throw new LibraryException("Buku tidak ditemukan");
    }

    public void returnBook(String title) throws LibraryException {
        boolean hasBorrowedBook = false;

        for (Book b : books) {
            if (!b.isAvailable()) {
                hasBorrowedBook = true;

                if (b.getTitle().equalsIgnoreCase(title)) {
                    b.returnBook();
                    return;
                }
            }
        }

        if (!hasBorrowedBook) {
            throw new LibraryException("Tidak ada buku yang harus dikembalikan");
        }

        throw new LibraryException("Buku ini tidak sedang dipinjam");
    }
    
    public void saveBooksToFile() throws LibraryException {
        try (PrintWriter pw = new PrintWriter(new FileWriter("books.txt"))) {
            for (Book b : books) {
                pw.println(
                    b.getTitle() + "," +
                    b.getAuthor() + "," +
                    b.isAvailable()
                );
            }
        } catch (IOException e) {
            throw new LibraryException("Gagal menyimpan ke file");
        }
    }


}
