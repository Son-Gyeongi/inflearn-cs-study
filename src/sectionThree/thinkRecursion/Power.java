package sectionThree.thinkRecursion;

/*
지수함수를 재귀함수를 이용해 하향식으로 구현
밑을 x로, 지수를 n으로 정의
 */
public class Power {
    public static int power(int x, int n) {
        // 기저 조건(탈출 조건) - 배열의 원소가 하나일 때는 하나의 원소가 배열의 전체 합이다.
        // 수학에서 지수가 0이면 1이다.
        if (n == 0) return 1;
        /*
        1. 하위문제 생각하기
        2. 만약 2의 5제곱이면 하위 문제는 2의 4제곱이다.
            여기서 2의 4제곱 * 2 를 하면 문제가 해결된다.
         */
        return power(x, n - 1) * x;
    }

    public static void main(String[] args) {
        System.out.print(power(2, 5));
    }
}
