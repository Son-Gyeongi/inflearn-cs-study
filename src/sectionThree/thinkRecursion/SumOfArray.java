package sectionThree.thinkRecursion;

import java.util.Arrays;

/*
배열의 모든 원소의 합을 구하기
- 하위 문제의 결과를 기반으로 현재 문제를 계산하면
    하향식 계산방식으로 재귀함수를 작성한 것이다.
 */
public class SumOfArray {
    // 하향식으로 재귀함수 구현
    public static int sumArray(int[] arr) {
        // 기저 조건(탈출 조건) - 배열의 원소가 하나일 때는 하나의 원소가 배열의 전체 합이다.
        if (arr.length == 1) return arr[0];
        // 하위 문제의 결과에 마지막 원소만 더해주면 된다.
        // 배열을 0번 인덱스부터 마지막 인덱스 한 칸 전까지 자른 배열의 합
        return sumArray(Arrays.copyOfRange(arr, 0, arr.length - 1)) + arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = sumArray(arr);
        System.out.print(sum);
    }
}
