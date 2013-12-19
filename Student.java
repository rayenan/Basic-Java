// Assumption:  For simplification, the programmer has assumed that all courses have the same weight
//                    (A future improvement(??)!)


public class Student {

	private String name;  //Name of the student.
	private long id; // (integer portion of) student's identification number.
	private String[][] course;  // Course code for Courses completed by student, organized by term.
	private String[][] courseLetter; //The letter grades achieved in each course.
	private double cumulativeGPA; // the student's cumulative GPA

	//Default Constructor 
	public Student() {
		this.name = "";
		this.id = 0;
		this.course = new String[1][1];
		this.courseLetter = new String [1][1];
		this.cumulativeGPA = -1; // Indicates no courses have been included in GPA calculation
	}
	
	//Constructor for a new student with no courses completed (yet) 
	public Student(String name, long id) {
		this.name = name;
		if (id > 0) this.id = id;
		else {
			System.err.println("ERROR: Incorrect ID number: default ID used for " + this.name);
			this.id = 0;
		}
		this.course = new String[1][1];
		this.courseLetter = new String [1][1];
		this.cumulativeGPA = -1; // Indicates no courses have been included in GPA calculation
	}
	
	//Constructor for a new student with completed courses 
	public Student(String newName, long id, String[][] course, String[][] courseLetter) {
		this.name = newName;
		this.id = id;
		this.course = course;
		this.courseLetter = courseLetter;
		this.cumulativeGPA = calculateGPAs();
	}

	private double calculateGPAs() {
		int counter = 0;
		double sum = 0.0;
		for (int term = 0; term < this.courseLetter.length; term++) {
			for (int index = 0; index < this.courseLetter[term].length; index++) {
				int gradePoint;
				if (this.courseLetter[term][index].equals("A+")) gradePoint= 9;
				else if (this.courseLetter[term][index].equals("A")) gradePoint = 8;
				else if (this.courseLetter[term][index].equals("A-")) gradePoint = 7;
				else if (this.courseLetter[term][index].equals("B+")) gradePoint = 6;
				else if (this.courseLetter[term][index].equals("B")) gradePoint = 5;
				else if (this.courseLetter[term][index].equals("B-")) gradePoint = 4;
				else if (this.courseLetter[term][index].equals("C+")) gradePoint = 3;
				else if (this.courseLetter[term][index].equals("C")) gradePoint = 2;
				else if (this.courseLetter[term][index].equals("D")) gradePoint = 1;
				else gradePoint = 0;
				sum += gradePoint;
				counter++;
			}
		}
		return sum/counter;
	}
	
	//Accessor for the name attribute
	public String getName() {
		return this.name;
	}
	
	//Mutator for the name attribute
	public void setName(String name) {
		this.name = name;
	}
	
	//Accessor for the id attribute
	public long getId() {
		return this.id;
	}
	
	//Mutator for the id attribute
	public void setId(long id) {
		if (id < 0)
			this.id = id;
		else System.err.println("ERROR: Incorrect ID number: attribute not updated");
	}
	
	//Accessor for the course attribute
	public String[][] getCourseReference() {  // returns a reference to the array of course names
		return this.course;
	}
	
	//Accessor for the course attribute
	public String getCourse() {  // returns a String showing all course names
		String result = "";
		for (int term = 0; term < this.course.length; term++) {
			for (int index = 0; index < this.course[term].length; index++) {
				result += course[term][index] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
	//Mutator for course attribute 
	public void setCourse(int term, int whichCourse, String courseName) {
			this.course[term][whichCourse] = courseName;
	}

	//Accessor for course letter attribute
	// returns a reference to the array of course letter grades
	public String[][] getCourseLetterReference() {
		return this.courseLetter;
	}
	
	//Accessor for course letter attribute
	// returns a String showing all course letter grades
	public String getCourseLetter() {
		String result = "";
		for (int term = 0; term < this.courseLetter.length; term++) {
			for (int index = 0; index < this.courseLetter[term].length; index++) {
				result += this.courseLetter[term][index] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
	//Mutator for course letter attribute
	//only allows changing one course grade.  Multiples, requires multiple calls
	//Expects termId in the form of <year><start month>.  For example Fall 2012 is termId=201209
	public void setCourseLetter(int term, int whichCourse, String newLetter) {
		this.courseLetter[term][whichCourse] = newLetter;
	}

	//Accessor for cumulative gpa attribute
	public double getCumulativeGPA() {
			return this.cumulativeGPA;
	}

	public String toString() {
		String result = this.name + this.id +":\n________________________\n";
		for (int term = 0; term < this.course.length; term++) {
			for (int index = 0; index < this.course[term].length; index++) {
				result += this.course[term][index] + ":" + this.courseLetter[term][index] + "\t";
			}
			result += "\n";
		}
		return result;
	}

	public boolean equals(Student other) {
		boolean samePerson = false;
		if ((this.name == other.name) && (this.id == other.id )) {
			samePerson = true;
		}
		return samePerson;
	}

	public static void main(String[] args) {
		// a place for testing methods of this class

		//test default constructor and toString:
		Student stuff = new Student();
		System.out.println(stuff.toString());

		//test  constructor and toString:
		Student lillanne = new Student("crazy", 123456);
		System.out.println(lillanne.toString());

		// Add method calls to test each method.
	}

}