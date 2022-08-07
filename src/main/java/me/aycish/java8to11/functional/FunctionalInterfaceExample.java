package me.aycish.java8to11.functional;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		int baseNumber = 10;
		RunSomething runSomething = (number -> number + baseNumber);

		System.out.println("-----------------------------------------");
		System.out.println(runSomething.doIt(1));
		System.out.println("-----------------------------------------");
	}
}
