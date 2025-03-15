package sectionThree.hanoiRecursion;

/*
하노이탑(재귀) - 하향식 방식으로 코드 작성
 */
public class Hanoi {
    // 매개변수 4개
    public static void hanoi(int count, String from, String to, String temp) {
        /*
        1. 기저 조건은 나중에 생각, 먼저 하향식 계산 방식으로 원반 옮기기
        2. 기저 조건 생각 - 함수 가장 위에 넣어주자
         */
        // 기저 조건 - 원반이 없을 때, 옮길 원반이 없다면 함수 종료
        if (count == 0) return;
        // 원반1,2가 기둥 B에 위치해야 원반3이 기둥 C로 이동 가능
        hanoi(count - 1, from, temp, to);
        // 기둥 A에는 원반3이 남아있고 원반3을 기둥 C로 이동시킨다. 실제로 원반을 움직인다.
        System.out.printf("원반 %d을/를 %s에서 %s로 이동%n", count, from, to);
        // 원반3이 기둥 C로 이동했다면 기둥 B에 있는 원반1,2도 기둥 C로 이동시킨다.
        hanoi(count - 1, temp, to, from);
    }

    public static void main(String[] args) {
        /*
        테스트 함수 작성
        첫 번째 인자 - 원반의 개수
        두 번째 인자 - 시작(from) / 원반들이 처음 꽂혀있는 기둥
        세 번째 인자 - 목표(to) / 원반들이 최종적으로 꽂힐 기둥
        네 번째 인자 - 임시(temp) / 원반들이 이동을 위해 일시적으로 사용되는 기둥
        // 세 개의 원반을 A 기둥에서 시작해서 C 기둥으로 옮기는데 B 기둥도 사용된다는 말
         */
        hanoi(3, "A", "C", "B");
    }
}
