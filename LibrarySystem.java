
abstract class LibraryMember {
    private String name;
    private int borrowedBooks;

    public LibraryMember(String name) {
        this.name = name;
        this.borrowedBooks = 0;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    protected void addBook() {
        borrowedBooks++;
    }

    public abstract void borrowBook() throws Exception;
}

class Student extends LibraryMember {
    private static final int LIMIT = 3;

    public Student(String name) {
        super(name);
    }

    @Override
    public void borrowBook() throws Exception {
        if (getBorrowedBooks() >= LIMIT) {
            throw new Exception("Student borrowing limit reached!");
        }
        addBook();
        System.out.println("Student " + getName() + " borrowed a book. Total: " + getBorrowedBooks());
    }
}

class Teacher extends LibraryMember {
    private static final int LIMIT = 5;

    public Teacher(String name) {
        super(name);
    }

    @Override
    public void borrowBook() throws Exception {
        if (getBorrowedBooks() >= LIMIT) {
            throw new Exception("Teacher borrowing limit reached!");
        }
        addBook();
        System.out.println("Teacher " + getName() + " borrowed a book. Total: " + getBorrowedBooks());
    }
}

class Guest extends LibraryMember {
    private static final int LIMIT = 1;

    public Guest(String name) {
        super(name);
    }

    @Override
    public void borrowBook() throws Exception {
        if (getBorrowedBooks() >= LIMIT) {
            throw new Exception("Guest borrowing limit reached!");
        }
        addBook();
        System.out.println("Guest " + getName() + " borrowed a book. Total: " + getBorrowedBooks());
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        try {
            LibraryMember s = new Student("sija");
            LibraryMember t = new Teacher("Karan");
            LibraryMember g = new Guest("Binaya");

            s.borrowBook();
            s.borrowBook();
            s.borrowBook();
            s.borrowBook(); // Exception

            t.borrowBook();
            g.borrowBook();
            g.borrowBook(); // Exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

