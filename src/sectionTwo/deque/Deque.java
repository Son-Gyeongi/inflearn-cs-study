package sectionTwo.deque;

import sectionTwo.queue.DoublyLinkedList;
import sectionTwo.queue.DoublyNode;

/*
덱
- 스택, 큐를 전부 구현할 수 있다.
- DoublyLinkedList(연결리스트)로 구현

- 스택으로 활용
    - addFirst(), removeFirst()
    - addLast(), removeLast()
- 큐로 활용
    - addFirst(), removeLast()
    - addLast(), removeFirst()
 */
public class Deque {
    // 빈 이중연결리스트로 초기화
    DoublyLinkedList list = new DoublyLinkedList();

    /*
    덱에 필요한 연산
     */
    // 1. printAll - 모든 데이터 출력
    public void printAll() {
        this.list.printAll();
    }

    // 2. addFirst - head 에 데이터 삽입
    public void addFirst(Object data) {
        this.list.insertAt(0, data);
    }

    // 3. removeFirst - head 에서 데이터 제거
    public DoublyNode removeFirst() {
        return this.list.deleteAt(0);
    }

    // 4. addLast - tail 에 데이터 삽입
    public void addLast(Object data) {
        this.list.insertAt(this.list.getCount(), data);
    }

    // 5. removeLast - tail 에서 데이터 제거
    public DoublyNode removeLast() {
        return this.list.deleteLast();
    }

    // 6. isEmpty - 리스트 비었는지 체크
    public boolean isEmpty() {
        return this.list.getCount() == 0;
    }
}
