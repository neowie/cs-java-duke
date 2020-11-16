/**
 * 
 */
package textgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> midList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Character> list2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

		list2 = new MyLinkedList<>();
		list2.add('A');
		list2.add('B');
		list2.add('C');
		list2.add('D');

		midList = new MyLinkedList<>();
		for (int i = 0; i < 5; i++) {
			midList.add(i);
		}
	}

	/**
	 * Test if the get method is working correctly.
	 */
	/*
	 * You should not need to add much to this method. We provide it as an
	 * example of a thorough test.
	 */
	@Test
	public void testGet() {
		// test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			assertEquals("Check " + i + " element", (Integer) i,
					longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	/**
	 * Test removing an element from the list. We've included the example from
	 * the concept challenge. You will want to add more tests.
	 */
	@Test
	public void testRemove() {
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer) 21,
				list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		// TODO: Add more tests here
		try {
			list2.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			list2.remove(list2.size());
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
	}
	/**
	 * Test adding an element into the end of the list, specifically public
	 * boolean add(E element)
	 */
	@Test
	public void testAddEnd() {
		// TODO: implement this test
		emptyList.add(0);
		assertEquals(0, (int) emptyList.get(0));
		longerList.add(10);
		assertEquals(10, (int) longerList.get(longerList.size() - 1));

		try {
			list2.add(-1, 'C');
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			list2.add(15, 'E');
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

	}

	/** Test the size of the list */
	@Test
	public void testSize() {
		// TODO: implement this test
		assertEquals(0, emptyList.size());
		assertEquals(10, longerList.size());
	}

	/**
	 * Test adding an element into the list at a specified index, specifically:
	 * public void add(int index, E element)
	 */
	@Test
	public void testAddAtIndex() {
		// TODO: implement this test
		shortList.add(1, "C");
		assertEquals("C", (String) shortList.get(1));

		try {
			shortList.add(1, null);
			fail("Check null pointer");
		} catch (NullPointerException e) {

		}

	}

	/** Test setting an element in the list */
	@Test
	public void testSet() {
		// TODO: implement this test
		// lower bound check
		try {
			shortList.set(-1, "E");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		// upper bound check
		try {
			longerList.set(LONG_LIST_LENGTH, 11);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		// null element
		try {
			list2.set(1, null);
			fail("Check null pointer");
		} catch (NullPointerException e) {
		}

		shortList.set(1, "D");
		assertEquals("D", (String) shortList.get(1));

	}

	// TODO: Optionally add more test methods.
	@Test
	public void testAdd() {
		try {
			list2.add(null);
			fail("Check null pointer");
		} catch (NullPointerException e) {
		}
	}
}
