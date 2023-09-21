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

        list.print();

        System.out.println("Number one is found for the first time at position " + list.indexOf(1));
        System.out.println("Number one is found for the last time at position " + list.lastIndexOf(1));

        list.remove(1);
        list.print(2);

        System.out.println("Is the value of four present in the list: " + list.isPresent(4));
        System.out.println("Is the value of fourteen present in the list: " + list.isPresent(14));

        list.removeAll();
        list.print(3);
    }
}
