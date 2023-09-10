package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(3, 7);

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        int indexOfOne = list.indexOf(1);
        System.out.println("Number one is found for the first time at position " + indexOfOne);

        int lastIndexOfOne = list.lastIndexOf(1);
        System.out.println("Number one is found for the last time at position " + lastIndexOfOne);

        list.remove(1);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Is the value of four present in the list: " + list.isPresent(4));
        System.out.println("Is the value of fourteen present in the list: " + list.isPresent(14));

        list.removeAll();
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        LinkedList<Integer> num = new LinkedList<>();
        num.add(1);
        num.add(2);

        for (int i = 0; i < num.size(); i++) {
            num.set(i, 0);
        }

        for (int i = 0; i < num.size(); i++) {
            System.out.println(num.get(i));
        }
    }
}
