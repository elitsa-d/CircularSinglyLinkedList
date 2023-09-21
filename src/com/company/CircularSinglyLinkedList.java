package com.company;

public class CircularSinglyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private Node getNode(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode;
    }

    public void print(int times) {
        Node currentNode = this.head;
        int n = size * times;
        int current = 1;

        while (current <= n) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNext();
            current++;
        }

        System.out.println();
    }

    public int getSize() {
        return this.size;
    }

    public int getFirst() {
        return this.head.getValue();
    }

    public int getLast() {
        return this.tail.getValue();
    }

    public int get(int index) {
        Node node = this.getNode(index);
        return node.getValue();
    }

    public int set(int index, int value) {
        Node node = this.getNode(index);
        node.setValue(value);
        return node.getValue();
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(newNode);
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.tail.setNext(this.head);
        }

        this.size++;
    }

    public void add(int index, int value) {
        Node newNode = new Node(value);

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setNext(newNode);
        } else {
            if (index == 0) {
                newNode.setNext(this.head);
                this.head = newNode;
                this.tail.setNext(newNode);
            } else if (index == this.size) {
                this.tail.setNext(newNode);
                this.tail = newNode;
                this.tail.setNext(this.head);
            } else {
                Node currentNode = this.getNode(index - 1);
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
        }

        this.size++;
    }

    public boolean isPresent(int value) {
        Node currentNode = this.head;

        do {
            if (currentNode.getValue() == value) {
                return true;
            }

            currentNode = currentNode.getNext();
        } while (currentNode != null);

        return false;
    }

    public int indexOf(int value) {
        if (isPresent(value)) {
            int currentIndex = 0;
            Node currentNode = this.head;

            while (currentIndex < this.size) {
                if (currentNode.getValue() == value) {
                    return currentIndex;
                }

                currentNode = currentNode.getNext();
                currentIndex++;
            }
        }

        throw new IllegalArgumentException("The specified value is not present in the list.");
    }

    public int lastIndexOf(int value) {
        if (isPresent(value)) {
            int currentIndex = 0;
            Node currentNode = this.head;
            int lastIndex = 0;

            while (currentIndex < this.size) {
                if (currentNode.getValue() == value) {
                    lastIndex = currentIndex;
                }

                currentNode = currentNode.getNext();
                currentIndex++;
            }

            return lastIndex;
        }

        throw new IllegalArgumentException("The specified value is not present in the list.");
    }

    public int remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int value = this.get(index);

        if (this.size == 1) {
            this.head.setNext(null);
            this.head = null;
            this.tail = null;
        } else {
            if (index == 0) {
                this.head = this.head.getNext();
                this.tail.setNext(this.head);
            } else if (index == this.size - 1) {
                this.tail = this.getNode(this.size - 2);
                this.tail.setNext(this.head);
            } else {
                Node nodeToRemove = this.getNode(index);
                Node currentNode = this.getNode(index - 1);
                currentNode.setNext(nodeToRemove.getNext());
            }
        }

        this.size--;
        return value;
    }

    public void removeAll() {
        this.head = null;
        this.tail.setNext(null);
        this.tail = null;
        this.size = 0;
    }
}
