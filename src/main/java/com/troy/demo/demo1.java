package com.troy.demo;

import java.util.Arrays;

/**
 * Created by zhangyongyu on 16/9/2.
 *
 * @parse com.troy.demo
 */
public class demo1 {
    public demo1() {
    }

    public static void main(String[] args) throws Exception {
        int[] array = new int[]{2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        int[] arrayb = new int[]{12, 3, -5, 7, 9};
        int[] var6 = arrayb;
        int var5 = arrayb.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            int insertNumber = var6[var4];
            Arrays.sort(array);
            printArray("数组排序", array);
            int index = Arrays.binarySearch(array, insertNumber);
            System.out.println("元素 " + insertNumber + " 所在位置（负数为不存在）：" + index);
            int newIndex = -index - 1;
            array = insertElement(array, insertNumber, newIndex);
            printArray("数组添加元素 " + insertNumber, array);
        }

    }

    private static void printArray(String message, int[] array) {
        System.out.println(message + ": [length: " + array.length + "]");

        for(int i = 0; i < array.length; ++i) {
            if(i != 0) {
                System.out.print(", ");
            }

            System.out.print(array[i]);
        }

        System.out.println();
    }

    private static int[] insertElement(int[] original, int element, int index) {
        int length = original.length;
        int[] destination = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length - index);
        return destination;
    }
}
