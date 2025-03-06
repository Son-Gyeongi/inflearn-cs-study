package sectionTwo.queue;

public class testQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("===== enqueue() 세 번 호출 =====");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // 큐의 가장 앞부분 출력
        System.out.println(queue.front());

        System.out.println("===== dequeue() 네 번 호출 =====");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("isEmpty(): " + queue.isEmpty());
    }
}
