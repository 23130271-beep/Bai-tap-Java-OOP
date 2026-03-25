package model;

import java.util.List;

public class MarketingStudent extends Student{
	

	public MarketingStudent(int id, String name, int age, String className, List<Subject> subjects) {
		super(id, name, age, className, subjects);
	}

	@Override
	public double calculateScore() {
		int tong = 0;
		for (Subject s : subjects) {
			if (s.getName().contains("MARKETING")) {
				tong = (int) (tong + s.getScore() * 0.4);
			} else if (s.getName().contains("MATH")) {
				tong = (int) (tong + s.getScore() * 0.2);
			} else if (s.getName().contains("STATISTICS")) {
				tong = (int) (tong + s.getScore() * 0.2);
			} else if (s.getName().contains("PROGRAMMING")) {
				tong = (int) (tong + s.getScore() * 0.2);
			}	
		}
		return tong;
	}	
}
