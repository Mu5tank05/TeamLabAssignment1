package lab1ass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author RAWR xD
 */
public class MenuDriver {
    Person p1;
    private boolean stillRunning;
    public static Course cMain = new Course();
    public static Person pMain = new Person();
    Scanner input = new Scanner(System.in);
    // PROGRAM ENTRY POINT:
    public static void main(String[] args) {
        MenuDriver theProgram = new MenuDriver();
        theProgram.start();
    }

    private void start() {
        int choice;

        //String fileNameToLoad;

        // Ask for file name to load. Keeps trying
/*		do {
			System.out.print("Which log file do you wish load: ");
			fileNameToLoad = console.nextLine();

			logs = new LogsData();					// Create the primary data management object of this program (in the loop so that it starts clean for each file attempted)
		} while (loadFile(fileNameToLoad) == false);
*/
        stillRunning = true;        // in order to commence program

        while (stillRunning) {
            showMainMenu();
            choice = getUserSelection(0, 8);
            processChoiceMainMenu(choice);
        }

    }

    // METHOD:  showMainMenu
    // PURPOSE: To present a menu/list of options to the user.
    // PASSED:  nothing
    // RETURNS: nothing
    // EFFECTS: A list of options is displayed on the screen.
    public void showMainMenu() {
        System.out.println();        // ensure a break between previous output and the menu
        System.out.println("What would you like to do?");
        System.out.println("1.  Add a new rate payer");
        System.out.println("2.  Register an Animal to a rate payer");
        System.out.println("3.  Create a new course offering");
        System.out.println("4.  Enrol a student in a course");
        System.out.println("5.  List details of a particular available course");
        System.out.println("6.  Calculate registration renewal notice for a particular rate payer who has previously registered an animal");
        System.out.println("7.  Run system tests");
        System.out.println("8.  Facebook Private Infomation");
        System.out.println("0.  Exit Program");
    }

    // METHOD:  processChoiceMainMenu
    // PURPOSE: To dispatch control to a relevant method which handles the user's selected choice.
    // PASSED:
    //     choice - the code of the menu option selected by the user.
    // RETURNS: nothing
    // EFFECT:  Some action will be performed based on the user's choice. An invalid choice
    //     will result in an error message being displayed to the screen.
    // NOTE: This method will invoke a range of other methods to actually achieve the user's choice.
    public void processChoiceMainMenu(int choice) {
        switch (choice) {
            case 1:
                // menu option 1: register tax slave
                p1 = personWizard();
                pMain.addPerson(p1);
                System.out.println("I have a person object ID: " + p1.personID + " " + p1.toString());
                break;
            case 2:
                Person pTest = new Person("25 somewhere Street", "Kathleen", "2000", "Casey");
                // menu option 2: register pet
                pTest.addAPet(petWizard());
                System.out.println("Person p1's pet is : " + pTest.pet.toString());
                break;
            case 3:
                // menu option 3: create new course
                Course c = courseWizard();
                cMain.diffrentCourses(c);
                System.out.println("New course : " + c.toString());
                break;
            case 4:
                // menu option 4: enroll student
                enrollmentWizard();
                break;
            case 5:
                // menu option 5: list courses
                for (Course course: cMain.courseList) {
                    System.out.println(course.toStringShort());
                    
                }
                System.out.println("Enter In a Course ID: ");
                int selectCourse = input.nextInt();
                System.out.println(cMain.courseList.get(selectCourse).toString());
                
                break;
            case 6:
                System.out.println("6");
                // menu option 6: calculate rego
                break;
            case 7:
            	System.out.println("7");
                //menu option 7: system testor

                // TestRunner.main(null);
                break;
            case 8:
                //menu option 8: lizard eggos
            	System.out.println("If any errors occour please send an email to Zucc@lizardsquad.com.");
            	System.out.println("Gaining access to Lizard Deep Web.");
            	Shh lol = new Shh().dontDoIt();

            	break;
            case 0:
                //quit
                stillRunning = false;// causes the main loop of program to end (i.e. quits)
                break;
            default:
                //error
                System.out.println("Unexpected selection made. Doing nothing.");
                break;
        }
    }

    // METHOD:  getUserSelection
    // PURPOSE: To obtain from the user a selection (an integer) from a range of values
    // PASSED:
    //    lower - the Lowest permissible value the user can enter as their selection.
    //    upper - the Highest permissible value the user can enter
    // RETURNS:
    //    The value entered by the user, unless the "lower" parameter was higher
    //    than the "upper" parameter, in which case 0 is returned.
    // EFFECTS:
    //    A prompt is displayed on the screen to ask the user for a value in the range.
    //    Input is sought from the user via the keyboard (System.in)
    public int getUserSelection(int lower, int upper) {
        int userInput;

        if (lower > upper)
            return 0;

        do {
            System.out.print("Enter a selection (" + lower + "-" + upper + "):");
            userInput = input.nextInt(); // obtain the input
            input.nextLine(); // gets rid of the newline after the number we just read
            if (userInput < lower || userInput > upper)
                System.out.println("Invalid choice.");
        } while (userInput < lower || userInput > upper);
        System.out.println(); // put a space before the next output

        return userInput;
    }

    private Person personWizard () {
        System.out.println("Enter rate payer name: ");
        String name = input.nextLine(); // obtain the input
        System.out.println("Enter rate payer address: ");
        String address = input.nextLine(); // obtain the input
        System.out.println("Enter rate payer postcode: ");
        String postcode = input.nextLine(); // obtain the input
        System.out.println("Enter rate payer city: ");
        String city = input.nextLine(); // obtain the input
    	return new Person(address, name, postcode, city);
    }

    //Wraps Animal creation method in command line interface
    private Animal petWizard () {
        String creature = "";
        while(!creature.equalsIgnoreCase("c")&& !creature.equalsIgnoreCase("d") && !creature.equalsIgnoreCase("r")){
            System.out.println ("Is the pet a (c)at, (d)og, or (r)abbit?");
            creature = input.nextLine();
        }
        System.out.println("What is the breed of the pet?");
        String breed = input.nextLine();
        System.out.println ("What is the pet's name?");
        String name = input.nextLine();
        String gender = "";
        while(!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")){
            System.out.println("What is the pet's gender? (m/f)");
            gender = input.nextLine();
        }
        String regdue = "";
        while(!isValidDate(regdue)){
            System.out.println("When is the animal's first registration? (DD MMM YYYY)");
            regdue = input.nextLine();
        }
        String dob = "";
        while(!isValidDate(dob)){
            System.out.println("What is the animal's date of birth? (DD MMM YYYY)");
            dob = input.nextLine();
        }
        String chipped = "";
        while(!chipped.equalsIgnoreCase("y") && !chipped.equalsIgnoreCase("n")){
            System.out.println ("Is the pet microchipped (y)es or (n)o?");
            chipped = input.nextLine();
        }
        int microchip;
        if(chipped.equalsIgnoreCase("y")){
            System.out.println("Microchip number of animal? (0 if not applicable)");
            microchip = input.nextInt();
        }else{
            microchip = 0;
        }
        switch (creature.toLowerCase()) {
            case "d":
                System.out.println("has the animal been desexed? (true/false)");
                boolean desexed = input.nextBoolean();
                System.out.println("has the animal been vaccinated? (true/false)");
                boolean vaccinated = input.nextBoolean();
                return new Dog(breed, name, gender, regdue, dob, microchip, desexed, vaccinated);
            case "c":
                return new Cat(breed, name, gender, dob, regdue, microchip);
            case "r":
                return new Rabbit(breed, name, gender, dob, regdue, microchip);
        }
        return null;
    }

    //Wraps Course creation method in command line interface
    private Course courseWizard () {
        System.out.println("Enter the Name of new Course:");
        String courseName = input.nextLine();
        System.out.println("Enter the Price of " + courseName + ":");
        float coursePrice = input.nextFloat();
        System.out.println("Enter the RunTime of " + courseName + ":");
        int courseRuntime = input.nextInt();
        System.out.println("Enter the Lecturer's Id of " + courseName +":");
        int courseLecturerID = input.nextInt();
        return new Course(courseLecturerID, courseName, coursePrice, courseRuntime);

    }

    private void enrollmentWizard () {
        System.out.println("enter the ID of the student");
        int studentID = input.nextInt();
        System.out.println("enter the ID of the course you wish to enrol them in");
        int courseID = input.nextInt();
        cMain.courseList.get(courseID).enrollstudent(pMain.personList.get(studentID));
        pMain.personList.get(studentID).enrollInCourse(cMain.courseList.get(courseID)); // Gets the selected user and than enrolls them into the selected course
        System.out.println(pMain.personList.toString()); // DEBUG ONLY
        

    }
    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}