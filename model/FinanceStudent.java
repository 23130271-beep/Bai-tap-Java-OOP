package model;

import java.util.List;

public class FinanceStudent extends Student {

	public FinanceStudent(int id, String name, int age, String className, List<Subject> subjects) {
		super(id, name, age, className, subjects);
	}

	@Override
	public double calculateScore() {
		int tong = 0;
		for (Subject s : subjects) {
			if (s.getName().contains("FINANCE")) {
				tong = (int) (tong + s.getScore() * 0.4);
			} else if (s.getName().contains("ACCOUNTING")) {
				tong = (int) (tong + s.getScore() * 0.3);
			} else if (s.getName().contains("MATH")) {
				tong = (int) (tong + s.getScore() * 0.15);
			} else if (s.getName().contains("STATISTICS")) {
				tong = (int) (tong + s.getScore() * 0.15);
			}	
		}
		return tong;
	}	
	
}
