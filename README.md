# e-library
Tentang App:
e-Library adalah aplikasi yang memungkinkan pengguna untuk dapat melakukan pesanan meminjam buku secara online.
Dalam aplikasi ini, pengguna harus daftar terlebih dahulu sebagai Member untuk bisa meminjam dan mengembalikan buku (dalam kode
ini, kita juga bisa berperan menjadi Admin untuk bisa menambah list buku). Fitur-fitur aplikasi ini dibagi menjadi dua, yaitu
fitur untuk Admin dan Member. 

Fitur untuk Admin antara lain: Menambah buku, melihat riwayat member, dan menyimpan file buku.
Fitur untuk Member antara lain: Meminjam buku, mengembalikan buku, melihat riwayat member, dan menyimpan file buku.
(Note: dalam video simulasi, fungsi simpan data ke file berupa .txt tidak sempat ditampilkan)

Terdapat 10 class dalam kode ini:
1. Main.java
Berguna untuk memanggil class AppUI untuk nantinya dijalankan.

2. AppUI.java
Mengatur tampilan aplikasi (GUI) dan interaksi pengguna dengan sistem.

3. Person.java
Class induk untuk Admin dan Member.

4. Admin.java
Merepresentasikan Admin pada sistem ini dan memiliki hak khusus untuk menambah buku.

5. Member.java
Merepresentasikan Member pada sistem dan punya hak khusus untuk meminjam dan mengembalikan buku.

6. Book.java
Merepresentasikan buku beserta dengan atributnya seperti judul, penulis, dan juga status (available/borrowed).

7. Transaction.java
Mencatat aktivitas peminjaman buku oleh Member (Tidak mencatat pengembalian buku).

8. Validator.java
Melakukan validasi untuk input seperti input tidak boleh kosong.

9. LibraryException.java
Menangani error logika dari sistem seperti buku tidak tersedia atau Member belum terdaftar.

10. LibraryOperation.java
Inti dari sistem aplikasi ini. Class ini mengelola buku, member, peminjaman buku, pengembalian, dan penyimpanan data.

Konsep-konsep OOP yang dipakai meliputi:
- Encapsulation:
Untuk mengubah status buku (available/borrowed), harus melalui method dan akses lewat getter dan setter.

- Inheritence:
Class Admin dan Member mewarisi atribut dari class Person.

- Polymorphism:
Method yang sama yaitu getRole dapat menghasilkan return berupa Member atau Admin, tergantung object apa yang menggunakan nya.

- Abstraction:
Pada saat meminjam buku menggunakan method borrowBook, class UI tidak akan tahu bagaimana prosesnya bisa terjadi karena semuanya tersembunyi di
class Library Operation.
"# e-library-refactored" 
