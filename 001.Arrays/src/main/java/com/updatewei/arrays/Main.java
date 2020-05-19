package com.updatewei.arrays;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();

        System.out.println("--------------add--------------");
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        System.out.println("--------------remove--------------");
        arr.remove(2);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        System.out.println("--------------set--------------");
        arr.set(0, 100);
        System.out.println(arr);


        System.out.println("--------------get--------------");
        System.out.println(arr.get(1));

        System.out.println("--------------indexOf--------------");
        System.out.println(arr.indexOf(100));
        System.out.println(arr.indexOf(1000));

        System.out.println("--------------contains--------------");
        System.out.println(arr.contains(100));
        System.out.println(arr.contains(1000));


        System.out.println("--------------test resize--------------");
        int n = 10000;
        for (int i = 0; i < n; i++) {
            arr.addLast(i);
        }
        System.out.println(String.format("size=%d, capacity=%d", arr.getSize(), arr.getCapacity()));
        for (int i = 0; i < n; i++) {
            arr.removeLast();
        }
        System.out.println(String.format("size=%d, capacity=%d", arr.getSize(), arr.getCapacity()));
    }
}
