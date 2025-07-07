import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vowels = 0;
        int special = 0;
        int digits = 0;

        System.out.print("Enter sentence: ");
        String usr_input = input.nextLine();

        for (int x = 0; x < usr_input.length(); x++) {
            usr_input = usr_input.toLowerCase();
            char ch = usr_input.charAt(x);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels = vowels + 1;
            } else if (ch >= '0' && ch <='9') {
                digits = digits + 1;
            } else if (ch == ' ' || !Character.isLetter(ch)) {
                special = special + 1;
            }
        }
        usr_input = usr_input.replace("fun", "awesome");

        System.out.println("Total vowels: " + vowels);
        System.out.println("Total special and spaces: " + special);
        System.out.println("Total digits: " + digits);

        System.out.println(usr_input);
    }
}