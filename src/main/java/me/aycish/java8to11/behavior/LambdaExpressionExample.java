package me.aycish.java8to11.behavior;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LambdaExpressionExample {

	static Member member = new Member(1L, "JOUNHEE");
	public static void main(String[] args) {
		int testNumber = 10;

		IntConsumer intConsumer = (i) -> {
			System.out.println(i);
		};

		intConsumer.accept(10);
		intConsumer.accept(11);
		intConsumer.accept(12);

		run();

		testStatusChange();
	}

	private static void testStatusChange() {
		Consumer<String> consumer = member::setName;
		consumer.accept("TEST");
		System.out.println(member.getName());
		member.setName("JOUNHEE_RETURN");
		System.out.println(member.getName());
	}
	// effective final example
	private static void run() {
		int baseNumber = 10;

		class LocalClass {
			void printBaseNumber() {
				int baseNumber = 11;
				System.out.println(baseNumber); // 11 출력
			}
		}

		Consumer<Integer> integerConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer baseNUmber) {
				System.out.println(baseNumber);
			} // 10 출력
		};

		/* effective final 변수 참조 가능 */
		IntConsumer printInt = (i) -> {
			System.out.println(i + baseNumber);
		};

		printInt.accept(10); // 20 출력

	}
}
