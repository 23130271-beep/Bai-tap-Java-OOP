package model;

public class Subject {
	private String name;
	private double score;
	public Subject(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public double getScore() {
		return score;
	}
	
}
