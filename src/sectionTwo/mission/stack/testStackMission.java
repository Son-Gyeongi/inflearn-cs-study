package sectionTwo.mission.stack;

/*
미션 - 마지막 인덱스, 즉 출구쪽으로 데이터가 삽입되고 나오는 구조로 코드를 변경
 */
public class testStackMission {
    public static void main(String[] args) {
        StackMission stack = new StackMission();

        System.out.println("===== 첫 번째 출력 =====");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());

        System.out.println("===== 두 번째 출력 =====");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek().getData());
        stack.pop();
        System.out.println(stack.peek().getData());
        System.out.println("isEmpty: " + stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println(stack.pop()); // pop() 메서드 예외처리 잘 되어있는지 확인
    }
}
