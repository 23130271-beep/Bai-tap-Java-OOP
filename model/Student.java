package model;

import java.util.List;

public abstract class Student {
	private int id;
	private String name;
	private int age;
	private String className;
	protected List<Subject> subjects;
	
	public Student(int id, String name, int age, String className, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.className = className;
		this.subjects = subjects;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getAge() {
		return age;
	}

	public String getClassName() {
		return className;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
	
	
	public abstract double calculateScore();
	public void printScore() {
		for (Subject s : subjects) {
			System.out.println("Ten mon hoc : " + s.getName() + s.getScore());
		}
	}
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
	public void removeSubject(String subject) {
		this.subjects.removeIf(s -> s.getName().contains(subject));
	}	
}
