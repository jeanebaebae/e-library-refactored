package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AppUI extends JFrame {

    private LibraryOperation service = new LibraryOperation();

    public AppUI() {
        setTitle("e-Library");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        chooseRole();
        
        JButton btnAddMember = new JButton("Daftar Member");
        JButton btnAddBook = new JButton("Tambah Buku");
        JButton btnViewBooks = new JButton("Lihat Buku");
        JButton btnBorrow = new JButton("Pinjam Buku");
        JButton btnReturn = new JButton("Kembalikan Buku");
        JButton btnHistory = new JButton("Riwayat Member");
        JButton btnSave = new JButton("Simpan ke File");

        JPanel panel = new JPanel();
        panel.add(btnAddMember);
        panel.add(btnAddBook);
        panel.add(btnViewBooks);
        panel.add(btnBorrow);
        panel.add(btnReturn);
        panel.add(btnHistory);
        panel.add(btnSave);

        add(panel);
        
        btnAddMember.addActionListener(e -> addMember());
        btnAddBook.addActionListener(e -> addBook());
        btnViewBooks.addActionListener(e -> viewBooks());
        btnBorrow.addActionListener(e -> borrowBook());
        btnReturn.addActionListener(e -> returnBook());
        btnHistory.addActionListener(e -> viewHistory());
        btnSave.addActionListener(e -> saveToFile());

        setVisible(true);
    }
    
    private void chooseRole() {
        String[] options = {"Admin", "Member"};
        
        int choice = JOptionPane.showOptionDialog(
            this,
            "Masuk sebagai:",
            "Login",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == 0) {
            service.setCurrentUser(new Admin("admin", "Administrator"));
            JOptionPane.showMessageDialog(this, "Login sebagai Admin");
        } else if (choice == 1) {
            JOptionPane.showMessageDialog(this, "Silakan daftar sebagai Member");
        } else {
            System.exit(0); 
        }
    }

    

    private void addBook() {
        try {
            if (service.getCurrentUser() == null ||
                    !service.getCurrentUser().getRole().equals("Admin")) {

                    JOptionPane.showMessageDialog(this, 
                        "Fitur ini hanya bisa diakses Admin");
                    return;
                }
            
            String title = JOptionPane.showInputDialog("Judul Buku:");
            String author = JOptionPane.showInputDialog("Penulis Buku:");
            Validator.validateBook(title);
            Validator.validateBook(author);
            service.addBook(new Book(title, author));
        } catch (LibraryException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void addMember() {
        try {
            if (service.getCurrentUser() != null &&
                service.getCurrentUser().getRole().equals("Member")) {

                JOptionPane.showMessageDialog(this, "Anda sudah login sebagai Member");
                return;
            }

            String id = JOptionPane.showInputDialog("Email:");
            String name = JOptionPane.showInputDialog("Nama:");

            Validator.validateBook(id);
            Validator.validateBook(name);

            Member member = new Member(id, name);
            service.addMember(member);
            service.setCurrentUser(member);

            JOptionPane.showMessageDialog(this,
                    "Member berhasil didaftarkan & login");

        } catch (LibraryException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void viewBooks() {
        StringBuilder sb = new StringBuilder();
        
        if (service.getBooks().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada buku yang ditambahkan Admin");
            return;
        }
        
        for (Book b : service.getBooks()) {
            sb.append(b.getTitle())
              .append(" - ")
              .append(b.getAuthor())
              .append(" (")
              .append(b.isAvailable() ? "Available" : "Borrowed")
              .append(")\n");
        }
 
        JOptionPane.showMessageDialog(this, sb.toString());
    }
    
    
    private void borrowBook() {
        try {
            if (service.getCurrentUser() == null ||
                    !service.getCurrentUser().getRole().equals("Member")) {

                    JOptionPane.showMessageDialog(this,
                        "Hanya member yang dapat meminjam buku");
                    return;
                }
        	
            String title = JOptionPane.showInputDialog("Masukkan judul buku:");
            service.borrowBook(title);
            JOptionPane.showMessageDialog(this, "Buku berhasil dipinjam");
        } catch (LibraryException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void returnBook() {
        try {
            if (service.getCurrentUser() == null ||
                !service.getCurrentUser().getRole().equals("Member")) {

                JOptionPane.showMessageDialog(this,
                        "Hanya member yang dapat mengembalikan buku");
                return;
            }

            String title = JOptionPane.showInputDialog("Judul buku:");
            service.returnBook(title);
            
            JOptionPane.showMessageDialog(this,
                    "Buku berhasil dikembalikan");

        } catch (LibraryException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void viewHistory() {
        if (service.getTransactions().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada riwayat");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Transaction t : service.getTransactions()) {
            sb.append(t.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }
    
    private void saveToFile() {
        try {
            service.saveBooksToFile();
            JOptionPane.showMessageDialog(this, "Data buku berhasil disimpan");
        } catch (LibraryException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }


    
}
