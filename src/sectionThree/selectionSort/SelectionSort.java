package sectionThree.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        // for 문을 만들어 줄 거다.
        // 마지막 원소는 자동으로 정렬되기 때문에 배열의 원소가 n 개라면 n-1번 반복시켜 주도록 하자.
        for (int i = 0; i < arr.length - 1; i++) { // 배열의 길이가 4면 3번 반복
            /*
            정렬되지 않은 영역의 첫 번째 원소부터 마지막 원소 중에
            최소 값을 가진 인덱스를 저장할 변수 만들기

            반복문을 한 번 진행할 때마다 최소값이 하나 정렬되기 때문에
            정렬된 영역은 반복에서 제외하기 위해 i를 값으로 주었다.
             */
            int minValueIndex = i;

            // 정렬되지 않은 영역의 첫 번째 원소부터 마지막 워소까지 순회하며
            // 가장 작은 값을 찾기 위한 for 문을 만들기
            for (int j = i + 1; j < arr.length; j++) { // 배열의 마지막 원소까지 반복
                // minValueIndex 인덱스 다음부터 검사
                /*
                정렬되지 않는 영역을 순회하다가 가장 작은 값을 발견하면
                minValueIndex 에 가장 작은 값의 위치를 저장
                 */
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j; // 현재 인덱스를 가장 작은 값의 인덱스로 저장
                }
            }

            // for 문을 거치면 minValueIndex 에는 정렬되지 않은 영역에서 가장 작은 값이 저장된다.
            // minValueIndex 값을 정렬되지 않은 영역의 첫 번쨰 원소와 교체
            int temp = arr[i];
            arr[i] = arr[minValueIndex];
            arr[minValueIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};

        System.out.println("===== 정렬 전 =====");
        System.out.println(Arrays.toString(arr));

        selectionSort(arr); // 배열 선택 정렬

        System.out.println("===== 정렬 후 =====");
        System.out.println(Arrays.toString(arr));
    }
}
