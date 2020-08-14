package test.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class CollectionTest {

	@Test
	void testList() {
		List<String> objList = new ArrayList<>();
		List<String> stList = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {

			objList.add("obj" + i);
		}

		stList.addAll(objList);

		// Lambda
		stList.forEach((x) -> System.out.printf("%s\t", x));
		System.out.println();

		// 迭代器
		Iterator<String> it = stList.iterator();
		while (it.hasNext()) {
			System.out.printf("%s\t", it.next());
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
