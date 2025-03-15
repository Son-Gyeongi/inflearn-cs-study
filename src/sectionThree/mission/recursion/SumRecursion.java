package sectionThree.mission.recursion;

public class SumRecursion {
    public static int sumOdd(int num) {
        // 기저 조건 (탈출 조건)
        if (num == 1) return 1;
        // 처음 들어온 num 이 짝수인 경우 -1로 홀수 만들어주기
        if (num%2==0) num = num - 1;
        return num + sumOdd(num - 2);
    }

    public static void main(String[] args) {
        System.out.println(sumOdd(10));
    }
}
