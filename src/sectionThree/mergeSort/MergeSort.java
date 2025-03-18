package sectionThree.mergeSort;

import java.util.Arrays;

/*
병합 정렬은 재귀로 정렬하는 알고리즘
 */
public class MergeSort {
    /*
    정렬할 배열 arr
    배열의 시작 인덱스를 나타내는 leftIndex
    배열의 마지막 인덱스를 나타내는 rightIndex
    => leftIndex, rightIndex 는 재귀로 호출할 때 필요한 매개변수
     */
    public static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
        /*
        leftIndex 와 rightIndex 가 같은 값일 때까지
        즉 배열의 원소가 1개일 때까지 분할하기 위해 if 문을 넣어준다.
         */
        if (leftIndex < rightIndex) { // 기저 조건
            // 배열을 분할하기 위해 중간값을 넣어준다.
            int midIndex = (leftIndex + rightIndex) / 2;

            // 배열의 왼쪽 영역을 재귀적으로 호출해 정렬해준다.
            mergeSort(arr, leftIndex, midIndex);
            // 배열의 오른쪽 영역을 재귀적으로 호출해 정렬해준다.
            mergeSort(arr, midIndex + 1, rightIndex);
            // 두 번의 재귀함수 호출했다면 arr 는 중간을 기준으로 정렬이 완료되었다.

            // 반반씩 정렬된 배열을 정렬하며 병합하는 함수를 만들어준다.
            merge(arr, leftIndex, midIndex, rightIndex);
        }
    }

    public static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {
        // 왼쪽 영역의 몇 번째까지 정렬됐는지 알려주는 leftAreaIndex 만들기
        int leftAreaIndex = leftIndex;
        // 오른쪽 영역의 몇 번째까지 정렬됐는지 알려주는 rightAreaIndex 만들기
        int rightAreaIndex = midIndex + 1;

        // 원본 배열과 길이가 똑같은 0으로 초가화된 배열 만들기
        int[] tempArr = new int[rightIndex + 1];

        // 새로 만든 배열에 어디까지 정렬이 됐는지 알려주는 변수
        int tempArrIndex = leftIndex; // 0번째 인덱스를 가리킨다.

        /*
        왼쪽 영역과 오른쪽 영역을 비교하면서 작은 수를 tempArr 에 넣어주자
        왼쪽 영역의 끝이나 오른쪽 영역의 끝으로 갈 때까지 반복
         */
        while (leftAreaIndex <= midIndex && rightAreaIndex <= rightIndex) {
            // 왼쪽 영역이 정렬되지 않았고 오른쪽 영역이 정렬되지 않는 동안에
            if (arr[leftAreaIndex] <= arr[rightAreaIndex]) {
                // 왼쪽 영역의 데이터가 오른쪽 영역의 데이터보다 작거나 같다면

                // 왼쪽 영역의 데이터를 tempArr 에 넣어주고 leftAreaIndex 를 1 늘린다.
                tempArr[tempArrIndex] = arr[leftAreaIndex++];
            } else {
                // 그렇지 않고 왼쪽 영역의 데이터가 오른쪽 영역의 데이터보다 크다면

                // 오른쪽 영역의 데이터를 tempArr 에 넣어주고 rightAreaIndex 를 1 늘린다.
                tempArr[tempArrIndex] = arr[rightAreaIndex++];
            }

            tempArrIndex++;
        }

        /*
        한쪽 영역이 전부 병합됐다면 나머지 영역은 이미 정렬이 되었기 때문에
        단순히 순서대로 tempArr 에만 넣어주면 된다.
         */
        if (leftAreaIndex > midIndex) {
            /*
            만약 오른쪽 영역이 병합이 덜 됐다면
            for 문을 돌면서 오른쪽 영역 나머지 전부를 차례대로 tempArr에 넣어준다.
             */
            for (int i = rightAreaIndex; i <= rightIndex; i++) {
                tempArr[tempArrIndex++] = arr[i];
            }
        } else {
            /*
            그렇지 않고 왼쪽 영역이 병합이 덜 됐다면
            for 문을 돌면서 왼쪽 영역 나머지 전부를 차례대로 tempArr 에 넣어준다.
             */
            for (int i = leftAreaIndex; i <= midIndex; i++) {
                tempArr[tempArrIndex++] = arr[i];
            }
        }

        // 마지막으로 tempArr 에 있는 데이터를 arr 에만 옮겨주면 된다.
        for (int i = leftIndex; i <= rightIndex; i++) {
            arr[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1, 7, 8, 6};

        System.out.println("===== 정렬 전 =====");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("===== 정렬 후 =====");
        System.out.println(Arrays.toString(arr));
    }
}
