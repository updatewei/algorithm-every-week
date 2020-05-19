package com.updatewei.arrays;

/**
 * 动态数组
 * @param <E>
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int RESIZE = 2;
    private static final int TRIGGER_RESIZE = 4;

    private Object[] data;
    private int size;

    public DynamicArray(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        checkIndex(index);
        int newCapacity = RESIZE * data.length;
        if (size == data.length) {
            resize(newCapacity);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        Object ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        int newCapacity = data.length / RESIZE;
        if (size == data.length / TRIGGER_RESIZE && newCapacity != 0) {
            resize(newCapacity);
        }
        return (E) ret;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public boolean removeElement(E e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("DynamicArray: size=%d, capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        Object[] resizeData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            resizeData[i] = data[i];
        }
        data = resizeData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("require 0<= index <= size ");
        }
    }
}
