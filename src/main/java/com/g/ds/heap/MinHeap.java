package com.g.ds.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
Implementing Min Heap In Java
Heaps
A heap is a tree-based data structure in which all the nodes of the tree are in a specific order.
For example, if X is the parent node of Y, then the value of X follows a specific order with respect to the value of Y and the same order will be followed across the tree.
A binary heap is a complete binary tree that satisfies the heap ordering property. The ordering can be one of two types:
the min-heap property: the value of each node is greater than or equal to the value of its parent, with the minimum-value element at the root.
the max-heap property: the value of each node is less than or equal to the value of its parent, with the maximum-value element at the root.
A heap is not a sorted structure and can be regarded as partially ordered. As you see from the picture, there is no particular relationship among nodes on any given level, even among the siblings.
A heap is useful data structure when you need to remove the object with the highest (or lowest) priority.
A common use of a heap is to implement a priority queue.
A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.
The root element will be at Arr[0].
Below shows indexes of other nodes for the ith node, i.e., Arr[i]
• Arr[(i-1)/2] : Returns the parent node
• Arr[(2*i)+1] : Returns the left child node
• Arr[(2*i)+2] : Returns the right child node
The traversal method use to achieve Array representation is Level Order
Operations on Min Heap:
1) peek(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
2) poll(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.
3) add(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
Below is the simple Java implementation of a Min Heap :
 */
public class MinHeap {

    private int capacity;
    private int size = 0;
    private int[] heap;

    private MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }


    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        int element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    // Time Complexity : O(1)
    private int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    // Time Complexity : O( Log n)
    private int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int element = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return element;
    }

    // Time Complexity : O( Log n)
    public void add(int item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallestChildIndex = getRightChildIndex(index);
            }

            if (heap[index] < heap[smallestChildIndex]) {
                break;
            } else {
                swap(index, smallestChildIndex);
            }
            index = smallestChildIndex;
        }
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String args[]){
        MinHeap minHeap = new  MinHeap(10);
        minHeap.add(10);
        minHeap.add(2);
        minHeap.add(20);
        minHeap.add(12);
        minHeap.add(22);
        minHeap.poll();
        minHeap.poll();
       // minHeap.poll();
        minHeap.printHeap();
    }
}