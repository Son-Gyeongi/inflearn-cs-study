package sectionThree.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        // 배열을 순회할 for 문 - 2개의 for 문을 통해서 모든 원소가 정렬된다.
        // 자리 교체는 배열의 길이보다 -1 횟수만큼 반복한다.
        for (int i = 0; i < arr.length - 1; i++) { // 배열의 길이가 4면 3번 반복
            // 첫 번째 원소부터 정렬이 된 원소의 이전 원소보다 하나 이전의 원소까지 순회
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 정렬이 완료된 개수만큼을 i로 빼줘서 범위를 줄여준다.

                // 실제로 비교하면서 위치를 바꾸기, 배열의 2개 숫자 교체
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};

        System.out.println("===== 정렬 전 =====");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr); // 배열 버블 정렬

        System.out.println("===== 정렬 후 =====");
        System.out.println(Arrays.toString(arr));
    }
}
