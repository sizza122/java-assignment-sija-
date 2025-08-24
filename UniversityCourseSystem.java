
class InvalidCourseDataException extends Exception {
    public InvalidCourseDataException(String message) {
        super(message);
    }
}

abstract class Course {
    private String courseCode;
    private int credits;

    public Course(String courseCode, int credits) throws InvalidCourseDataException {
        if (credits <= 0) {
            throw new InvalidCourseDataException("Credits must be positive");
        }
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseCode() { return courseCode; }
    public int getCredits() { return credits; }

    public abstract int calculateWorkload();
}

class TheoryCourse extends Course {
    public TheoryCourse(String courseCode, int credits) throws InvalidCourseDataException {
        super(courseCode, credits);
    }

    @Override
    public int calculateWorkload() {
        return getCredits() * 12;
    }
}

class LabCourse extends Course {
    public LabCourse(String courseCode, int credits) throws InvalidCourseDataException {
        super(courseCode, credits);
    }

    @Override
    public int calculateWorkload() {
        return getCredits() * 15;
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        try {
            Course theory = new TheoryCourse("CS209", 3);
            Course lab = new LabCourse("CS201", 2);

            System.out.println(theory.getCourseCode() + " Workload: " + theory.calculateWorkload());
            System.out.println(lab.getCourseCode() + " Workload: " + lab.calculateWorkload());
        } catch (InvalidCourseDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
