import java.util.Scanner;

public class CeasarCipherText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter shift value (1-25): ");
        int shift = scanner.nextInt();
        
        // Encrypt input text
        String encryptedText = encrypt(text, shift);
        System.out.println("Encrypted text: " + encryptedText);
        
        // Decrypt text back to original
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted text: " + decryptedText);
        
        scanner.close();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            // Encrypt uppercase letters
            if (Character.isUpperCase(c)) {
                c = (char) (((int) c + shift - 65) % 26 + 65);
            }
            // Encrypt lowercase letters
            else if (Character.isLowerCase(c)) {
                c = (char) (((int) c + shift - 97) % 26 + 97);
            }
            
            encryptedText.append(c);
        }
        
        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); 
    }
}
   

