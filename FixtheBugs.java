package wipro_simplilearn;
import java.util.*;

public class FixtheBugs {
private static List<Integer> expenses = new ArrayList<>();
private static final String ERROR_MESSAGE = "ERROR:Please enter a valid integer!";
private final static StringBuilder arr = new
StringBuilder()
.append("1. Review my expenses\n")
.append("2. Add an expense\n")
.append("3. Delete an expense\n")
.append("4. Sort the expenses\n")
.append("5. Search for a particular expense\n")
.append("6. Close the application\n");
public static void main(String[] args) {
System.out.println("\tWelcome to My Application \n");
System.out.println("**************************************")
;
System.out.println("\nEnter your choice:\t");
addInitialExpenses();
System.out.println("Current expenses: " + expenses);
optionsSelection();
}
private static void addInitialExpenses() {
expenses.add(1500);
expenses.add(2500);
expenses.add(47000);
expenses.add(30000);
expenses.add(11000);
}
private static void optionsSelection() {
int optionSelected = 1;
do {
System.out.print(arr);
Scanner sc = new Scanner(System.in);
try {
optionSelected = sc.nextInt();
} catch (InputMismatchException e) {
System.out.println("\n" + ERROR_MESSAGE + "\n");
continue;
}
switch (optionSelected) {
case 1:
System.out.println("Your saved expenses are listed below: \n");
System.out.println(expenses + "\n");
break;
case 2:
addExpenditure(sc);
break;
case 3:
deleteExpenses(optionSelected, sc);
break;
case 4:
sortExpenses(expenses);
break;
case 5:
searchExpenses(expenses, sc);
break;
case 6:
closeApp();
break;
default:
System.out.println("\nInvalid choice!\nChoose '6' if you wish to exit.\n");
break;
}
} while (true);
}
private static void closeApp() {
System.out.println("Closing the application...\nThank you!");
System.exit(0);
}
private static void searchExpenses(List<Integer>
arrayList, Scanner sc) {
System.out.println("Enter the expense you need to search:\t");
int key = -1;
try {
key = sc.nextInt();
} catch (InputMismatchException e) {
System.out.println("\n" + ERROR_MESSAGE);
return;
}
System.out.println(arrayList);
int index = arrayList.indexOf(key);
if (index < 0)
System.out.println(key + " is not present in the list!");
else
System.out.println("Value " + "[ " + key + " ]"
+ " has been found at index: " + index);
}
private static void sortExpenses(List<Integer> arrayList) {
Collections.sort(arrayList);
System.out.println("\n" + arrayList);
}
private static void deleteExpenses(int optionSelected, Scanner sc) {
System.out.println("You are about the delete all your expenses! " + "\nConfirm again by selecting the same option...\n");
int con_choice = -1;
try {
con_choice = sc.nextInt();
} catch (InputMismatchException e) {
System.out.println(ERROR_MESSAGE);
return;
}
if (con_choice == optionSelected) {
expenses.clear();
System.out.println(expenses + "\n");
System.out.println("All your expenses are erased!\n");
} else {
System.out.println("Oops !! Try again!");
}
}
private static void addExpenditure(Scanner sc) {
System.out.println("Enter the value to add your Expense: \n");
int value;
try {
value = sc.nextInt();
} catch (InputMismatchException e) {
System.out.println(ERROR_MESSAGE);
return;
}
System.out.println("Your value is updated\n");
expenses.add(value);
System.out.println(expenses + "\n");
}
}