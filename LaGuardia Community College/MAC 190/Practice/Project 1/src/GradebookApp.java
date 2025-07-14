import java.util.Scanner;

public class GradebookApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student student1 = new Student();

        System.out.print("Enter student name: ");
        student1.setName(input.nextLine());
        System.out.print("Enter student id: ");
        student1.setId(input.nextInt());
        System.out.print("Enter quiz grade: ");
        student1.setQuiz_score(input.nextDouble());
        System.out.print("Enter mid grade: ");
        student1.setMid_score(input.nextDouble());
        System.out.print("Enter final grade: ");
        student1.setFinal_score(input.nextDouble());


        char grade = student1.getFinalLetterGrade();

        System.out.println("name = " + student1.getName());
        System.out.println("id = " + student1.getId());
        System.out.println("grade = " + grade);

    }
}
