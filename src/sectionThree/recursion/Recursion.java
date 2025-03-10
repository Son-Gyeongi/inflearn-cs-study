package sectionThree.recursion;

/*
재귀(recursion)
 */
public class Recursion {
    public static void main(String[] args) {
        myFunction(1);
    }

    /*
    java.lang.StackOverflowError 에러 발생
    - 나의 경우 19862 까지 계산이 나온다. (메모리의 크기에 따라 다르게 출력됨)
    - 자동으로 종료되었다. (콜스택이라는 메모리 공간이 가득 차서 자동으로 종료됨)
    - 재귀함수는 탈출 조건, 즉 기저 조건이 반드시 있어야 한다.
     */
//    public static int myFunction(int number) {
//        System.out.println(number);
//        return myFunction(number + 1);
//    }

    /*
    // 1부터 10까지 출력
    기저 조건(탈출 조건) 추가
    - return 이 필요없다.
     */
    public static void myFunction(int number) {
        if (number > 10) return;
        System.out.println(number);
        myFunction(number + 1);
    }
}
