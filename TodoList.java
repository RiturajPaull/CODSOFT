import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String description;
    String dateDue;
    boolean isCompleted;

    public Task(String title, String description, String dateDue) {
        this.title = title;
        this.description = description;
        this.dateDue = dateDue;
        this.isCompleted = false;

    }

    public void markAsComplete() {
        this.isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String toString() {
        return "\nTitle : " + title + "\nDescription : " + description + "\nDue date :" + dateDue + "\nComplete :"
                + isCompleted;

    }
}

public class TodoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            Menu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addYourTask();
                    break;
                case 2:
                    viewYourTasks();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    removeYourTasks();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    private static void Menu() {
        System.out.println();
        System.out.println("\n-------Todo List Menu--------");
        System.out.println("\n1. Addition");
        System.out.println("2. View Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit Application");
        System.out.println("Choose your preffered option: ");
    }

    private static void addYourTask() {
        System.out.println("\nEnter title of your task: ");
        String title = sc.nextLine();

        System.out.println("\nEnter the description :");
        String description = sc.nextLine();

        System.out.println("\nEnter the due date of your your tasks :");
        String dateDue = sc.nextLine();

        Task newTask = new Task(title, description, dateDue);
        tasks.add(newTask);
        System.out.println("\n-------Task Added Successfully--------");
    }

    private static void viewYourTasks() {
        System.out.println("\nTasks");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Index: " + i + tasks.get(i).toString());
        }
    }

    private static void markTaskCompleted() {
        System.out.println("\nEnter the index to mark as complete : ");
        int index = sc.nextInt();

        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsComplete();
            System.out.println();
        } else {
            System.out.println("\n-------Invalid Index!!------");
        }
    }

    private static void removeYourTasks() {
        System.out.println("\nEnter the index of the task to be removed : ");
        int index = sc.nextInt();

        sc.nextLine();

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("\n Task with the index " + index + " is successfully removed from the list-------");
        } else {
            System.out.println("----Invalid Index.Please try again----");
        }
    }

}
