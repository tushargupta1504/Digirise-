
import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}

class Student extends User {
    public Student(String username, String password) {
        super(username, password);
    }
    
   
}

class Instructor extends User {
    public Instructor(String username, String password) {
        super(username, password);
    }
    
   
}

class Course {
    private String courseCode;
    private String courseName;
    private Instructor instructor;
    private List<Student> students;
    
    public Course(String courseCode, String courseName, Instructor instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = new ArrayList<>();
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public Instructor getInstructor() {
        return instructor;
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    
}

class CourseManagementSystem {
    private List<Student> students;
    private List<Instructor> instructors;
    private List<Course> courses;
    
    public CourseManagementSystem() {
        students = new ArrayList<>();
        instructors = new ArrayList<>();
        courses = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }
    
    public void createCourse(String courseCode, String courseName, Instructor instructor) {
        Course course = new Course(courseCode, courseName, instructor);
        courses.add(course);
    }
    
    public Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
    
    
}

public class Main {
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();
        
        Student student1 = new Student("tushar123", "password");
        Instructor instructor1 = new Instructor("instructor1", "password");
        
        cms.addStudent(student1);
        cms.addInstructor(instructor1);
        
        cms.createCourse("CSE101", "Introduction to Computer Science", instructor1);
        
        Course cse101 = cms.findCourse("CSE101");
        if (cse101 != null) {
            cse101.addStudent(student1);
        }
        
       
    }
}
