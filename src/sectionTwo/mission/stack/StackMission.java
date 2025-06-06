package sectionTwo.mission.stack;

import sectionTwo.linkedList.LinkedList;
import sectionTwo.linkedList.Node;

/*
미션 - 마지막 인덱스, 즉 출구쪽으로 데이터가 삽입되고 나오는 구조로 코드를 변경
스택
- First In Last Out(FILO) - 먼저 들어간 데이터가 나중에 나오는 규칙
- LinkedList(연결리스트)로 Stack 구현
 */
public class StackMission {
    // 스택이 초기화할 때 빈 리스트 생성
    LinkedList list = new LinkedList();

    /*
    스택에 필요한 연산
     */
    // 1. push - 데이터 삽입
    public void push(Object data) {
        // 연결리스트의 head 에 삽입
        this.list.insertAt(this.list.getCount(), data);
    }

    // 2. pop - 데이터 제거
    public Node pop() {
        try {
            // 연결리스트의 head 에서 꺼내기
            return this.list.deleteAt(this.list.getCount() - 1);
        } catch (Exception e) {
            // 비어있는 리스트 지울경우 예외 던지기
            return null;
        }
    }

    // 3. peek - 데이터 참조
    public Node peek() {
        return this.list.getNodeAt(this.list.getCount() - 1);
    }

    // 4. isEmpty - 비어있는지 체크
    public boolean isEmpty() {
        return this.list.getCount() == 0;
    }
}
