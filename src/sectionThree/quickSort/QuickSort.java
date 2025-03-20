package sectionThree.quickSort;

import java.util.Arrays;

public class QuickSort {
    /*
    범위를 나눈 배열을 재귀적으로 호출하기 때문에
    범위를 나타낼 left 와 right 를 추가
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 기저 조건 - left 가 right 보다 크지 않을 때
        if (left <= right) {
            // 피벗 지정해서 피벗 하나를 정렬 - 정렬된 피벗의 위치를 리턴
            // 정렬된 피벗의 인덱스를 반환
            int pivot = divide(arr, left, right);

            // pivot 의 위치에 데이터는 정렬 되었기 때문에 왼쪽 영역을 정렬시킨다.
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    /*
    실제로 피벗을 지정하고 정렬하는 함수
     */
    public static int divide(int[] arr, int left, int right) {
        // 가장 먼저 pivot 정하기
        // 간단하게 배열의 가장 왼쪽값을 피벗으로 설정
        int pivot = arr[left];
        int leftStartIndex = left + 1;
        int rightStartIndex = right;

        // leftStartIndex 와 rightStartIndex 가 서로 지나칠 때까지
        // 반복해야 하므로 while 문을 넣어준다.
        while (leftStartIndex <= rightStartIndex) {
            // leftStartIndex 를 pivot 보다 큰 값을 만날 때까지
            // 오른쪽으로 보낸다.
            while (leftStartIndex <= right && pivot >= arr[leftStartIndex]) {
                // 배열의 범위 안에서 && 피벗의 값이 arr[leftStartIndex] 보다 크거나 같다면
                // 계속 오른쪽으로 이동
                leftStartIndex++;
            }

            // leftStartIndex 가 멈췄다면
            // rightStartIndex 를 왼쪽으로 이동시켜 줘야 한다.
            // pivot 보다 작은 값을 만날 때까지 계속 반복
            while (rightStartIndex >= (left + 1) && pivot <= arr[rightStartIndex]) {
                // 피벗을 제외한 배열의 범위 안에서
                // && 피벗의 값이 rightStartIndex 보다 작거나 같으면
                // 계속 왼쪽으로 이동
                rightStartIndex--;
            }

            // rightStartIndex 가 멈췄다면
            // 이제 leftStartIndex 값과 rightStartIndex 값을 교환해줘야 한다.
            // 조건 : leftStartIndex 와 rightStartIndex 가 서로 지나치지 않은 경우
            if (leftStartIndex <= rightStartIndex) {
                // leftStartIndex 와 rightStartIndex 교환
                swap(arr, leftStartIndex, rightStartIndex);
            }
        }

        // 위 while 문이 끝나면 leftStartIndex 와 rightStartIndex 가 지나치게 된다.
        // pivot 의 위치와 rightStartIndex 를 교환해주면
        // pivot에 해당하는 숫자는 자기 자리를 찾아 정렬된다.
        swap(arr, left, rightStartIndex);
        return rightStartIndex; // 정렬된 데이터의 인덱스를 리턴하며 함수를 종료
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,7,2,6,4,9,1,8};

        System.out.println("===== 정렬 전 =====");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("===== 정렬 후 =====");
        System.out.println(Arrays.toString(arr));
    }
}
