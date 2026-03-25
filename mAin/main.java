package mAin;

import model.*;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {

        while (true) {
            showMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        handleAddStudent();
                        break;
                    case 2:
                        handleDisplayStudents();
                        break;
                    case 3:
                        handleFindStudentbyID();
                        break;
                    case 4:
                    	Removestudent();
                    	break;
                    case 5:
                    	Calculateaveragescore();
                    	break;
                    case 6:
                    	sortByScoreDesc();
                    	break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


	// ================= MENU =================
	private static void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT =====");
        System.out.println("1. Add student");
        System.out.println("2. Display students");
        System.out.println("3. Find student by ID");
        System.out.println("4. Remove student");
        System.out.println("5. Calculate average score");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    // ================= HANDLERS =================
    // Cho phep nhap student tu ban phim thay vi hard code 2 sinh vien
    // Sau khi nhap mot sinh vien hoi xem co muon nhap tiep khong, neu khong thi quay tro lai menu (dung while va if)
    private static void handleAddStudent() {
    	//List<Subject> subjects = new ArrayList<Subject>();
    	/*Subject subjecta = new Subject("MATH", 7.5);
    	Subject subjectb = new Subject("PROGRAMMING", 6.8);
    	Subject subjectc = new Subject("STATISTICS", 9);
    	subjects.add(subjecta);
    	subjects.add(subjectb);
    	subjects.add(subjectc);
    	Student studenta = new ITStudent(123, "Nam", 19, "Math",subjects);
    	Student studentb = new ITStudent(135, "My", 19, "Book",subjects);
    	studentService.addStudent(studenta);
    	studentService.addStudent(studentb);*/
    	while (true) {
    		List<Subject> subjects = new ArrayList<Subject>();
    		System.out.println("Nhap thong tin sinh vien bao gom id, ten, tuoi, nganh, mon: ");
    		int id = scanner.nextInt();
    		scanner.nextLine();
    		String name = scanner.nextLine();
    		int age = scanner.nextInt();
    		scanner.nextLine();
    		String nghanh = scanner.nextLine();
    		while (true) {
    			String mon = scanner.nextLine();
    			double diem = scanner.nextDouble();
    			scanner.nextLine();
    			Subject subjecta = new Subject(mon, diem);
    			subjects.add(subjecta);
    			System.out.println("Co muon nhap them diem hay khong.");
    			String tieptuc1 = scanner.nextLine();
    			if (tieptuc1.equalsIgnoreCase("khong")) {
    				System.out.println("Nhap diem xong.");
    				break;
    			}
    		}
    		if (nghanh.equalsIgnoreCase("IT")) {
    			Student student = new ITStudent(id, name, age, nghanh, subjects);
    			studentService.addStudent(student);
    		} else if (nghanh.equalsIgnoreCase("MARKETING")) {
    			Student student = new MarketingStudent(id, name, age, nghanh, subjects);
    			studentService.addStudent(student);
    		} else if (nghanh.equalsIgnoreCase("FINANCE")) {
    			Student student = new FinanceStudent(id, name, age, nghanh, subjects);
    			studentService.addStudent(student);
    		}
    		System.out.println("Co muon nhap tiep hay khong ? (nhap khong de dung) :");
    		String tieptuc = scanner.nextLine();
    		if (tieptuc.equalsIgnoreCase("khong")) {
    			System.out.println("Nhap hoc sinh xong");
    			break;
    		}
    	}
    }
    private static void handleDisplayStudents() {
    	List<Student> students = studentService.getAllStudents();
    	for (Student s : students) {
    		System.out.println("ID :" + s.getId());
    		System.out.println("Ten :" + s.getName());
    		System.out.println("Tuoi :" + s.getAge());
    		System.out.println("Nghanh :" + s.getClassName());
    		s.printScore();
    	}
    }
    private static void handleFindStudentbyID() {
    	System.out.println("Nhap id.");
    	int id = Integer.parseInt(scanner.nextLine());
    	Student student = studentService.findById(id);
    	System.out.println(student.getName());
    }
    private static void Removestudent() {
    	System.out.println("Nhap id");
    	int id = Integer.parseInt(scanner.nextLine());
		studentService.removeStudent(id);
	}
    private static void Calculateaveragescore() {
    	System.out.println("Nhap id.");
    	int id = Integer.parseInt(scanner.nextLine());
    	Student student = studentService.findById(id);
    	double score = studentService.calculateAverageScore(id);
    	System.out.println(student.getName());
    	System.out.println(score);
    }
    private static void sortByScoreDesc() {
    	List<Student> students = studentService.getAllStudents();
    	studentService.sortByScoreDesc();
    	for (Student s : students) {
    		System.out.println("Danh sách học sinh theo điểm giảm dần : " + s.getName() + " " + s.calculateScore());
    	}
	}
    
}