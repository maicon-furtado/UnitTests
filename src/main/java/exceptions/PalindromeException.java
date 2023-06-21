package exceptions;

public class PalindromeException extends Exception {
    public PalindromeException() {
        super("Palindrome should have three elements at least!");
    }
}
