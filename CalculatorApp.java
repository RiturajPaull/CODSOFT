import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            calMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addNumber();
                    break;
                case 2:
                    subNumber();
                    break;
                case 3:
                    multiplyNumber();
                    break;
                case 4:
                    divNumber();
                    break;
                case 5:
                    System.out.println("Exit Application//");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void calMenu() {
        System.out.println("\n-----Menu for the application-----");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit the Application");
        System.out.println("Choose your preffered option");
    }

    private static void addNumber() {
        System.out.println("\nEnter the first number:- ");
        int n1 = sc.nextInt();
        System.out.println("\nEnter the Second Number :- ");
        int n2 = sc.nextInt();
        System.out.println("\nThe sum of two numbers is :- " + (n1 + n2));

    }

    private static void subNumber() {
        System.out.println("Enter the first number:- ");
        int n1 = sc.nextInt();
        System.out.println("Enter the second number :- ");
        int n2 = sc.nextInt();
        if (n2 >= n1) {
            System.out.println("The difference of two numbers is :- " + (n2 - n1));
        } else {
            System.out.println("The difference of the two numnber is :-" + (n1 - n2));
        }
    }

    private static void multiplyNumber() {
        System.out.println("Enter the first number:- ");
        int n1 = sc.nextInt();
        System.out.println("Enter the second number :- ");
        int n2 = sc.nextInt();
        System.out.println("The multiplication of the two numbers is:- " + (n1 * n2));
    }

    private static void divNumber(){
        int n1 = getValidIntInput("Enter the first number :- ");
        int n2 = getValidIntInput("Enter the second number :- ");
        if(n2==0){
            System.out.println("Error : Cannot divide by zero! ");
        }else{
            System.out.println("The quotient is: "+ (n1/n2));
        }
    }
    private static int getValidIntInput(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                return sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }
    }
}
