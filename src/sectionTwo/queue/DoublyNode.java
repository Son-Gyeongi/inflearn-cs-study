package sectionTwo.queue;

public class DoublyNode {
    Object data; // 해당 노드의 데이터
    DoublyNode next; // 연결된 다음 노드 참조변수
    DoublyNode prev; // 연결된 이전 노드 참조변수

    public DoublyNode(Object data) {
        this(data, null, null);
    }

    public DoublyNode(Object data, DoublyNode next, DoublyNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DoublyNode{" +
                "data=" + data +
//                ", next=" + next + // 무한 재귀 방지를 위해 주석 처리
//                ", prev=" + prev +
                '}';
    }
}
