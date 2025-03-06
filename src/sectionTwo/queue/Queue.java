package sectionTwo.queue;

/*
큐
- First In First Out(FIFO) - 먼저 들어간 데이터가 먼저 나오는 규칙
- DoublyLinkedList(이중 연결리스트)로 Queue 구현
 */
public class Queue {
    // 빈 이중 연결리스트 만들어 초기화
    DoublyLinkedList list = new DoublyLinkedList();

    /*
    큐에 필요한 연산
     */
    // 1. enqueue - 데이터 삽입
    public void enqueue(Object data) {
        // 리스트의 앞부분에 데이터를 넣기만 하면 된다.
        this.list.insertAt(0, data);
    }

    // 2. dequeue - 데이터 제거
    public DoublyNode dequeue() {
        try {
            // 리스트의 가장 뒷부분에서 데이터를 제거
            return this.list.deleteLast();
        } catch (Exception e) {
            // 삭제할 수 없는 경우 예외
            return null;
        }
    }

    /*
    3. front - 데이터 참조
        - 가장 먼저 들어간 데이터, 즉 tail 이 가리키고 있는 데이터를 제거하지는 않고 참조만 하는 기능
     */
    public DoublyNode front() {
        return this.list.tail;
    }

    // 4. isEmpty - 비어있는지 확인
    public boolean isEmpty() {
        return this.list.count == 0;
    }
}
