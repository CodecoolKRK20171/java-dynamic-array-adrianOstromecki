package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {
    private int[] array;
    private int size;

    public DynamicIntArray() {
        array = new int[0];
        size = 0;
    }

    public DynamicIntArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public void add(int value) {
        if (size >= array.length) {
            expandArray();
        }
        array[size++] = value;
    }

    private void expandArray() {
        int[] expandedArray = new int[size + 5];
        copyArray(expandedArray, array);
        array = expandedArray;
    }

    private void copyArray(int[] newArray, int[] oldArray) {
        int size = oldArray.length;

        for (int i=0; i<size; i++) {
            newArray[i] = oldArray[i];
        }
    }

    public void remove(int value) {
        boolean isItemFound = false;

        for (int i=0; i<size; i++){
            if (array[i] == value){
                isItemFound = true;
                delete(i);
            }
        }

        if (!isItemFound){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void delete(int index) {
        for (int i=index; i<size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void insert(int index, int value) {
        if (index >= size) {
            add(value);
            return;
        }

        if (size >= array.length) {
            expandArray();
        }

        for (int i=size - 1; i>=index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = value;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<size; i++) {
            sb.append(String.format(" %d", array[i]));
        }

        return sb.toString();
    }
}
