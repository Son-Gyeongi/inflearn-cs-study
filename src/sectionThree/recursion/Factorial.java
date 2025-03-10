package sectionThree.recursion;

/*
팩토리얼을 재귀함수로 구현해보자
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }

    /*
    기저 조건(탈출 조건) 만들기
        - 1이 되면 팩토리얼은 종료된다.
        - 0! 은 1이기 때문에 같이 기저 조건에 넣겠다.
     */
    public static int factorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
