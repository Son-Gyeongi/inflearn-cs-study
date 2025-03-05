package sectionTwo.linkedList;

public class Node {
    Object data; // 해당 노드의 데이터
    Node next; // 연결된 다음 노드 참조변수

    public Node(Object data) {
        this(data, null);
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
