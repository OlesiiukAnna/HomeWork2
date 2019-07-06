package org.anna.task_2;

import java.util.Arrays;

public class IntArrayList implements IntList {
    private int[] array = new int[10];
    private int size = 0;

    @Override
    public boolean add(int element) {

        if (size >= array.length) {
            int newSize = array.length * 3 / 2 + 1;
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        array[size] = element;
        size++;

        return true;
    }

    @Override
    public boolean add(int index, int element) {
        boolean result;

        if (index > size) {
            result = false;
            throw new IndexOutOfBoundsException();
        }
        if (size >= array.length) {
            int newSize = array.length * 3 / 2 + 1;
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        if (size - index >= 0) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        result = true;
        size++;

        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = 0;
        size = 0;
    }

    @Override
    public int get(int index) {

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        boolean result;

        if (index >= size) {
            result = false;
            throw new IndexOutOfBoundsException();
        }
        if (size - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }

        result = true;
        size--;

        return result;
    }

    @Override
    public boolean removeByValue(int value) {
        boolean result = false;

        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                remove(i);
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean set(int index, int element) {
        boolean result;

        if (index >= size) {
            result = false;
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
        result = true;

        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList subList = new IntArrayList();

        if (toIndex < fromIndex) {
            throw new IllegalArgumentException();
        }
        if (fromIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(array[i]);
        }

        return subList;
    }

    @Override
    public int[] toArray() {
        if (size == 0) {
            throw new NullPointerException();
        }

        int[] result = new int[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
