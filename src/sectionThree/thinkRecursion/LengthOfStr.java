package sectionThree.thinkRecursion;

/*
문자열의 길이를 계산
 */
public class LengthOfStr {
    public static int strLength(String str) {
        // 기저 조건(탈출 조건) - 배열의 원소가 하나일 때는 하나의 원소가 배열의 전체 합이다.
        // 배열에 원소가 없을 때
        // if (str == null) return 0;
        // 위 코드를 사용하면 substring() 메서드에서 인덱스가 -1을 참조하려고 해서 에러가 난다.
        if (str.length() == 1) return 1;
        /*
        1. 하위 문제 생각하기
        2. 구하려는 문자열의 마지막 원소를 제외한 나머지 부분
        3. 나머지 원소는 하나이기 때문에 +1 을 해준다.
         */
        return strLength(str.substring(0, str.length() - 1)) + 1;
    }

    public static void main(String[] args) {
        String str = "abcde"; // 길이가 5인 문자열
        int len = strLength(str);
        System.out.print(len);
    }
}
