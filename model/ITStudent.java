package model;

import java.util.List;

public class ITStudent extends Student{

	public ITStudent(int id, String name, int age, String className, List<Subject> subjects) {
		super(id, name, age, className, subjects);
	}

	@Override
	public double calculateScore() {
		int tong = 0;
		for (Subject s : subjects) {
			if (s.getName().equalsIgnoreCase("MATH")) {
				tong = (int) (tong + s.getScore() * 0.3);
			} else if (s.getName().equalsIgnoreCase("STATISTICS")) {
				tong = (int) (tong + s.getScore() * 0.3);
			} else if (s.getName().equalsIgnoreCase("PROGRAMMING")) {
				tong = (int) (tong + s.getScore() * 0.4);
			}
		}
		return tong;
	}

}
