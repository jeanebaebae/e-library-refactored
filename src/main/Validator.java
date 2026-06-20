package main;

public class Validator {

	public static void validateBook(String input) throws LibraryException {
		if(input == null || input.trim().isEmpty()) {
			throw new LibraryException("Input harus diisi");
		}
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
