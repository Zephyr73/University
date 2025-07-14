import java.util.Scanner;

public class Caesar {
    public static String Encrypt(String text, int shift) {
        String encoded = "";
        for(int x = 0; x < text.length(); x++) {
            char ch = text.charAt(x);
            if (Character.isUpperCase(ch)) {
                encoded = encoded + (char)(((ch - 'A' + shift) % 26) + 'A');
//                 (ch - 'A' + shift) gives me the index of character after shift starting from 'A'
//                 %26 handles the text wrapping when the character goes beyond 'Z' and then we add it back to 'A'
            } else if (Character.isLowerCase(ch)) {
                encoded = encoded + (char)(((ch - 'a' + shift) % 26) + 'a');
//                 Same logic as previous one, just instead of 'A' I used 'a'
            } else {
                encoded = encoded + ch;
            }
        }
        return encoded;
    }

    public static String Decrypt(String text, int shift) {
        return Encrypt(text, 26 - (shift % 26));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = input.nextLine();
        System.out.print("Enter shift: ");
        int shift = input.nextInt();
        input.nextLine();

        System.out.print("Do you want to encrypt or decrypt?: ");
        String choice = input.nextLine();
//      I gave user the option to choose whether they want to encrypt or decrypt
//      Hence the output may not look the same as the Example
        if (choice.equalsIgnoreCase("encrypt")) {
            String output = Encrypt(text, shift);
            System.out.println("Encrypted: " + output);
        } else if (choice.equalsIgnoreCase("decrypt")) {
            String output = Decrypt(text, shift);
            System.out.println("Decrypted: " + output);
        } else {
            System.out.println("Enter a valid option");
        }
    }
}