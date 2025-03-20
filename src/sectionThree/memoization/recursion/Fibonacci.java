package sectionThree.memoization.recursion;

import java.util.Calendar;
import java.util.HashMap;

public class Fibonacci {
    // 재귀
    // 성능은 O(2의 n제곱)
    public static int fibonacci1(int n) {
        // 기저 조건
        if (n == 0||n==1) return n;
        // 현재 구하려는 값의 두 번째 전 값과 첫 번째 값을 구해서 더해주기만 하면 된다.
        return fibonacci1(n - 2) + fibonacci1(n - 1);
    }

    // 동적 프로그래밍 - 메모이제이션
    // 계산 결과를 기억하기 위한 매개변수 memo 추가
    // 성능은 O(n)
    public static int fibonacci2(int n, HashMap<Integer, Integer> memo) {
        if (n == 0||n==1) return n;

        // 해시 테이블에 해당 값의 계산 결과가 있는지 검색
        if (memo.get(n) == null) {
            memo.put(n, fibonacci2(n - 2, memo) + fibonacci2(n - 1, memo));
        }

        // memo 에 n 의 계산 결과가 들어있다면
        // memo 에서 n 을 검색해서 리턴해 준다.
        return memo.get(n);
    }

    public static void main(String[] args) {
        // 5번째 값 출력
        // 재귀
        Calendar start = Calendar.getInstance(); // 성능을 시간으로 측정하기 위해
        System.out.println(fibonacci1(40));
        Calendar end = Calendar.getInstance();
        System.out.println("fibonacci1 함수 실행시간: "
                + (end.getTimeInMillis() - start.getTimeInMillis()) + "ms");

        // 동적 프로그래밍 - 메모이제이션
        HashMap<Integer, Integer> memo = new HashMap<>();
        start = Calendar.getInstance();
        System.out.println(fibonacci2(40, memo));
        end = Calendar.getInstance();
        System.out.println("fibonacci2 함수 실행시간: "
                + (end.getTimeInMillis() - start.getTimeInMillis()) + "ms");
    }
}
