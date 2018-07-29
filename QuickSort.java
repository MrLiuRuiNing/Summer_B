package com.google.xzy.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static int[] quickSort(int[] target, int low, int high) {
        //递归终止条件
        if (high > low) {
            //拿到划分数组后基准元素的下标
            int base_index = partition(target, low, high);
            //对左边的子数组快速排序，不包含基准元素
            quickSort(target, low, base_index - 1);
            //对右边的子数组快速排序，不包含基准元素
            quickSort(target, base_index + 1, high);
            return target;
        }
        return target;
    }

    /**
     * 划分数组，以一个元素为基准，先将其放到它在排序后应该在的位置
     * @param target 数组
     * @param low  左边界
     * @param high  右边界
     * @return  返回基准元素的下标
     */
    public static int partition(int[] target, int low, int high) {
        //初始化基准元素为左起第一个元素
        int base = target[low];
        //基准元素最终应该在的位置
        int base_index = low;
        //从第二个元素开始，到右边界结束
        for (int i = low + 1; i <= high; i++) {
            //如果该元素小于基准值
            if (target[i] < base) {
                //基准值最终位置标志后移，否则不用后移
                base_index++;
                //标志位后移后如果和i相等就不用交换了，省去多余的交换
                if (base_index != i) {
                    int temp = target[base_index];
                    target[base_index] = target[i];
                    target[i] = temp;
                }
            }
        }
        //最后将基准值归位
        target[low] = target[base_index];
        target[base_index] = base;

        System.out.println(Arrays.toString(target));
        //返回划分后基准元素的位置
        return base_index;
    }
}

class testQuickSort {
    public static void main(String[] arg) {
        int[] array = new int[]{3, 2, 5, 8, 4, 7, 6, 9, 1, 10};
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------");
        array = QuickSort.quickSort(array, 0, 9);
        System.out.println("---------------------------------");
        System.out.println(Arrays.toString(array));
    }
}
