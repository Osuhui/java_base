package test.utils;

import org.junit.jupiter.api.Test;

import java.util.*;

class CollectionTest {

	@Test
	void testList() {
		List<String> objList = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			objList.add("obj" + i);
		}

		List<String> stList = new ArrayList<>(objList);

		// Lambda
		stList.forEach((x) -> System.out.printf("%s\t", x));
		System.out.println();

		// 循环
		for (String s : stList) {
			System.out.printf("%s\t", s);
		}
		System.out.println();
	}

	@Test
	void testEnumeration() {
		Enumeration<String> em;
		Vector<String> vector = new Vector<>();

		for (int i = 1; i <= 10; i++) {
			vector.add("vec" + i);
		}

		em = vector.elements();
		while (em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
	}
}
