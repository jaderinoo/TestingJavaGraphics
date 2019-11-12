import java.util.Scanner;

public class Main {
	//Initial Commit
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		Frame frame = new Frame();
	    frame.init();
	    
	    
	    System.out.println("Type 1");
	    frame.getFrame();
	    int number = scanner.nextInt();
	    if(number == 1) {
		    printTest();
	    }

	    
	}
	
	public static void printTest() {
		System.out.println("printTest");
	}

}
