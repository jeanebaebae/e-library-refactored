package main;

public class Transaction {
    private Member member;
    private Book book;

    public Transaction(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Member telah meminjam buku " + book.getTitle();
    }
}
