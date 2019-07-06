package org.anna.task_2;

import java.util.Arrays;

public class IntArrayList implements IntList {
    private int[] array = new int[10];
    private int numberOfElements = 0;

    @Override
    public boolean add(int element) {

        if (numberOfElements >= array.length) {
            int newSize = array.length * 3 / 2 + 1;
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, numberOfElements);
            array = newArray;
        }

        array[numberOfElements] = element;
        numberOfElements++;

        return true;
    }

    @Override
    public boolean add(int index, int element) {

        if (index > numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        if (numberOfElements >= array.length) {
            int newSize = array.length * 3 / 2 + 1;
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, numberOfElements);
            array = newArray;
        }
        if (numberOfElements - index >= 0) {
            System.arraycopy(array, index, array, index + 1, numberOfElements - index);
        }

        array[index] = element;
        numberOfElements++;

        return true;
    }

    @Override
    public void clear() {
        array = new int[10];

        numberOfElements = 0;
    }

    @Override
    public int get(int index) {

        if (index >= numberOfElements) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean remove(int index) {

        if (index >= numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        if (numberOfElements - index >= 0) {
            System.arraycopy(array, index + 1, array, index, numberOfElements - index);
        }

        numberOfElements--;

        return true;
    }

    @Override
    public boolean removeByValue(int value) {

        for (int i = 0; i < numberOfElements; i++) {
            if (array[i] == value) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean set(int index, int element) {

        if (index >= numberOfElements) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;

        return true;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList subList = new IntArrayList();

        if (toIndex < fromIndex) {
            throw new IllegalArgumentException();
        }
        if (fromIndex < 0 || toIndex > numberOfElements) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(array[i]);
        }

        return subList;
    }

    @Override
    public int[] toArray() {
        if (numberOfElements == 0) {
            throw new NullPointerException();
        }

        int[] result = new int[numberOfElements];
        System.arraycopy(array, 0, result, 0, numberOfElements);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
