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
            }
        }

        if (!isItemFound){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insert(int index, int value) {

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
