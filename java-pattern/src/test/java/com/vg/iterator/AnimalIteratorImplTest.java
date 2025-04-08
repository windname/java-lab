package com.vg.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.vg.behavioral.iterator.Animal;
import com.vg.behavioral.iterator.AnimalIteratorImpl;
import org.junit.Test;
//import static org.junit.Assert.*;

public class AnimalIteratorImplTest {

	@Test
	public void testIterOneElement() {
		Animal lion = new Animal("Lion");
		List<Animal> list = new ArrayList<Animal>();
		list.add(lion);
		AnimalIteratorImpl iter = new AnimalIteratorImpl(list);

		assertTrue(iter.isLastAnimal());
		assertEquals(lion, iter.currentAnimal());
		assertNull(iter.nextAnimal());

	}

	@Test
	public void testIterTwoElement() {
		Animal lion = new Animal("Lion");
		Animal puma = new Animal("puma");
		List<Animal> list = new ArrayList<Animal>();
		list.add(lion);
		list.add(puma);
		AnimalIteratorImpl iter = new AnimalIteratorImpl(list);

		assertFalse(iter.isLastAnimal());
		assertEquals(lion, iter.currentAnimal());
		assertEquals(puma, iter.nextAnimal());

		assertTrue(iter.isLastAnimal());
		assertEquals(puma, iter.currentAnimal());
		assertNull(iter.nextAnimal());

	}
}
