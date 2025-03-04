package sectionTwo.linkedList;

public class Test {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // 노드간 연결
        node1.next = node2;
        node2.next = node3;

        System.out.println(node1.data);
        System.out.println(node1.next.data);
        System.out.println(node1.next.next.data);

        // LinkedList 인스턴스 생성
        LinkedList list = new LinkedList();

        System.out.println("===== insertAt() 다섯 번 호출 =====");
        list.insertAt(0, 0);
        list.insertAt(1, 1);
        list.insertAt(2, 2);
        list.insertAt(3, 3);
        list.insertAt(4, 4);
        list.printAll();

        System.out.println("===== clear() 호출 =====");
        list.clear();
        list.printAll();

        System.out.println("===== insertLast() 세 번 호출 =====");
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);
        list.printAll();

        System.out.println("===== deleteAt() 호출 =====");
        list.deleteAt(0);
        list.printAll();
        list.deleteAt(1);
        list.printAll();

        System.out.println("===== deleteLast() 호출 =====");
        list.insertLast(5);
        list.deleteLast();
        list.deleteLast();
        // list.deleteLast(); list 에 데이터가 없는데 삭제하려고 해서 에러가 난다.
        list.printAll();

        System.out.println("===== getNodeAt() 호출 =====");
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        Node secondNode = list.getNodeAt(2); // 2번째 인덱스 가져온다.
        System.out.println(secondNode);
    }
}
