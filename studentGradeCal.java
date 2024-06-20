import java.util.InputMismatchException;
import java.util.Scanner;

public class studentGradeCal {
    private static final double A_Min = 90;
    private static final double B_Min = 80;
    private static final double C_Min = 70;
    private static final double D_Min = 60;

    private static final double Assignment_Weight = 0.3;
    private static final double Quiz_Weight = 0.2;
    private static final double midterm_weight = 0.2;
    private static final double final_exam_weight = 0.3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---STUDENT GRADE CALCULATOR---");
        System.out.println("Enter your assignment grade (0-100): ");
        double assignmentGrade = getValidIntInput(sc);
        System.out.println("Enter your quiz grade(0-100):");
        double quizGrade = getValidIntInput(sc);
        System.out.println("Enter your mid-term exam grade (0-100)");
        double midtermGrade = getValidIntInput(sc);
        System.out.println("Enter your final exam grade (0-100):");
        double finalexamGrade = getValidIntInput(sc);
        
        double overAllCourseGrade = calculateOverallGrade(assignmentGrade, quizGrade, midtermGrade, finalexamGrade);
        
        char letterGrade = determineLetterGrade(overAllCourseGrade);

        System.out.println("Your overall course grade is : "+ overAllCourseGrade);
        System.out.println("Your letter grade is : "+ letterGrade);
    }

    private static double getValidIntInput(Scanner sc){
        while(true){
            try{
                double grade = sc.nextDouble();
                if(grade<0||grade>100){
                    System.out.println("Invalid input. Please enter a grade between 0 and 100.");

                }else{
                    return grade;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }
    }

    private static double calculateOverallGrade(double assignmentGrade, double quizGrade, double midtermGrade, double finalexamGrade){
        return (assignmentGrade *Assignment_Weight) + (quizGrade *Quiz_Weight)+ (midtermGrade * midterm_weight) + (finalexamGrade * final_exam_weight);
    }

    private static char determineLetterGrade(double overAllCourseGrade){
        if(overAllCourseGrade>=A_Min){
            return 'A';
        }else if(overAllCourseGrade >=B_Min){
            return 'B';
        }else if(overAllCourseGrade>=C_Min){
            return 'C';
        }else if(overAllCourseGrade >=D_Min){
            return 'D';
        }else{
            return 'F';
        }
    }
}
