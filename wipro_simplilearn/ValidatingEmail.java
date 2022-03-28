package wipro_simplilearn;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class ValidatingEmail {
	public static void main(String[] args) {
		 
		 ArrayList<String> emailID = new ArrayList<String>();
		 
		 emailID.add("vamshi@gmail.com");
		 emailID.add("varshith@gmail.com");
		 emailID.add("bunty@gmail.com");
		 emailID.add("pranay@gmail.com");
		 emailID.add("vikas@gmail.com");
		 emailID.add("harsha@gmail.com");
		 emailID.add("aakash@gmail.com");
		 
		 String searchElement;
		 System.out.println("E-mail: ");
		 Scanner sc = new Scanner(System.in);
		 searchElement = sc.nextLine();
		 String regex = "^(.+)@(.+)$";
		 
		 Matcher matcher = Pattern.compile(regex).matcher(searchElement);
		 
		 if (matcher.matches() && emailID.stream().anyMatch(mail -> 
		mail.equals(searchElement))) {
		 System.out.println(searchElement + " = is present");
		 } 
		 else {
		 System.out.println("Not a valid Email-id or is not present");
		 }
		 
		 }

}
