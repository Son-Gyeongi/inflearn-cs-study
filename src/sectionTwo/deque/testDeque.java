package sectionTwo.deque;

public class testDeque {
    public static void main(String[] args) {
        Deque deque = new Deque();

        System.out.println("===== addFirst =====");
        System.out.println("isEmpty: " + deque.isEmpty()); // 덱이 비어있는지 확인
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());
        System.out.println();

        System.out.println("===== removeFirst =====");
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());
        System.out.println();

        System.out.println("===== addLast =====");
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());
        System.out.println();

        System.out.println("===== removeLast =====");
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());
    }
}
