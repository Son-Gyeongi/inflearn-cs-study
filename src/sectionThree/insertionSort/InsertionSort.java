package sectionThree.insertionSort;

import java.util.Arrays;

/*
삽입 정렬
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        /*
        i 가 1부터 시작하는 이유
        - 0번째 인덱스 즉, 첫 번째 원소는 이미 정렬되어 있다고 가정
        - i 인덱스에 해당하는 원소는 정렬되지 않은 영역의 첫 번째 데이터
         */
        for (int i = 1; i < arr.length; i++) {
            int insertingData = arr[i]; // 정렬되지 않은 영역의 첫 번째 데이터

            /*
            정렬된 영역의 맨 뒤부터 첫 번째 원소까지 역순으로 순회
            정렬될 원소의 삽입 위치를 찾는 부분
             */
            int j; // 정렬된 영역의 맨 뒤, 삽입 위치 기억해주기 위해서
            for (j = i - 1; j >= 0; j--) {
                // 정렬된 영역의 마지막 원소는 정렬되지 않은 영역의 첫 번째 원소의 한 칸 앞

                if (arr[j] > insertingData) {
                    // 현재 순회하는 인덱스의 원소가 삽입할 원소보다 크다면
                    // 오른쪽 인덱스에 덮어쓴다.
                    arr[j + 1] = arr[j];
                } else {
                    // 삽입할 원소보다 작은 원소의 자리를 찾았으니 for 문 종료
                    // 삽입할 원소보다 작은 원소의 인덱스는 j에 기록되어 있다.
                    break;
                }
            }

            // 안쪽 for 문을 마치고 나오면 삽입할 배열의 위치가 정해진다.
            arr[j + 1] = insertingData;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, 6, 2};

        System.out.println("===== 정렬 전 =====");
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("===== 정렬 후 =====");
        System.out.println(Arrays.toString(arr));
    }
}
