package me.aycish.java8to11.behavior;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

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
		combineFunction();
	}

	// TODO : 왜 객체내의 status가 변경이 가능할까?
	private static void testStatusChange() {
		Consumer<String> consumer = member::setName;
		consumer.accept("TEST");
		System.out.println(member.getName());
		member.setName("JOUNHEE_RETURN");
		System.out.println(member.getName());
	}

	// combine example
	private static void combineFunction() {
		Function<Integer,Integer> f = x -> x + 1;
		Function<Integer,Integer> g = x -> x * 2;

		int result1 = f.andThen(g).apply(1);
		int result2 = f.compose(g).apply(1);

		System.out.println("ret1 = " + result1 + " " + "ret2 = " + result2);
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
