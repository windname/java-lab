package com.vg.behavioral.iterator;

import java.util.List;

public class AnimalIteratorImpl implements AminalIterator {

	public List<Animal> animalList;
	private int position;

	public AnimalIteratorImpl(List animalList) {
		this.animalList = animalList;
	}

	public Animal nextAnimal() {
		if (position < animalList.size() - 1) {
			position++;
			return animalList.get(position);
		}
		return null;
	}

	public boolean isLastAnimal() {
		if (position == animalList.size() - 1) {
			return true;
		}
		return false;
	}

	public Animal currentAnimal() {
		if (position < animalList.size()) {
			return animalList.get(position);
		}
		return null;
	}

}
