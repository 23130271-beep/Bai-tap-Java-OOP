package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Student;

public class StudentService {
	private List<Student> students = new ArrayList<>();

    // 1. Thêm học sinh
    public void addStudent(Student student) {
        students.add(student);
    }

    // 2. Lấy tất cả học sinh
    public List<Student> getAllStudents() {
    	return students;
    }

    // 3. Tìm theo ID (O(1))
    public Student findById(int id) {
       for (Student s : students) {
    	   if (s.getId() == id) {
    		   return s;
    	   }
       }
       return null;
    }

    // 4. Xóa học sinh
    public void removeStudent(int id) {
        this.students.removeIf(s -> s.getId() == id);
    }

    // 5. Tính điểm trung bình
    public double calculateAverageScore(int id) {
    	Student s = findById(id);
    	double a = s.calculateScore();
    	return a;
    }

    // 6. Hiển thị danh sách (business-level, không print trực tiếp)
    public void displayStudents() {
    	students.stream().map(Student :: toString);
    }

    // 7. Sắp xếp theo điểm giảm dần (bonus)
    public List<Student> sortByScoreDesc() {
    	students.sort(Comparator.comparing(Student::calculateScore).reversed());
    	return students;
    }

    // 8. Lọc theo loại student (polymorphism + instanceof) advance
    public List<Student> filterByType(Class<?> type) {
    	return students.stream().filter(type :: isInstance).toList();
    }
}

