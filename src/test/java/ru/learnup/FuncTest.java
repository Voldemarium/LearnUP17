package ru.learnup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class FuncTest {
	private static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of(1, 2, 3),  //a, b, expected
				Arguments.of(5, 5, 10)
		);
	}
	@Test
	@DisplayName("Тест суммы двух чисел")
	void sum() {
		Func func = new Func();
		Assertions.assertEquals(10, func.sum(1, 9));
	}
	@ParameterizedTest  (name = "Тест {index}: {0} + {1} = {2}")    //формат вывода на экран
	@MethodSource("data")  //указываем, откуда берем значения аргументов
	@DisplayName("Тест суммы двух чисел с параметрами")
	void testSumParams(int a, int b, int expected) {
		Func func = new Func();
		Assertions.assertEquals(expected, func.sum(a, b));
	}

}