package sectionTwo.queue;

import sectionTwo.linkedList.Node;

/*
이중 연결리스트
- 데이터를 담은 노드를 양방향 연결하는 구조
- 연결리스트에서 tail 추가
 */
public class DoublyLinkedList {
    DoublyNode head; // 연결리스트의 시작 노드를 가리킨다.
    DoublyNode tail; // 연결리스트의 끝 노드를 가리킨다.
    int count; // 총 저장된 노드의 수

    public int getCount() {
        return count;
    }

    public DoublyNode getHead() {
        return head;
    }

    public DoublyNode getTail() {
        return tail;
    }

    /*
            이중연결리스트에 필요한 연산
             */
    // 1. 모든 데이터 출력
    public void printAll() {
        DoublyNode currentNode = this.head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        // currentNode 가 null 이 될 때까지 계속 next 노드 참조
        while (currentNode != null) {
            stringBuilder.append(currentNode.data);
            currentNode = currentNode.next;

            if (currentNode != null) {
                // currentNode 가 마지막 데이터가 아니라면 ,(콤마) 추가
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");

        System.out.println(stringBuilder);
    }

    // 2. 모든 데이터 제거
    public void clear() {
        this.head = null; // head 가 null 을 가리키게 해서 참조하는 것을 없앤다.
        this.count = 0; // count 를 0 으로 만들어주면 리스트가 비워진다.
    }

    // 3. 인덱스(노드) 삽입
    public void insertAt(int index, Object data) {
        // index - 삽입할 위치, data - 삽입할 데이터

        // 매개변수 예외처리
        if (index > this.count || index < 0) {
            throw new IllegalArgumentException("범위를 넘어갔습니다.");
        }

        // 새로 삽입할 노드
        DoublyNode newNode = new DoublyNode(data);

        /*
        2가지 상황
        1. 리스트의 가장 앞부분에 삽입하는 경우
            - 새로 삽입하는 노드가 head 가 되어야 한다.
        2. 이전 노드를 가리키는 기능이 추가되어서 tail 에 삽입하는 경우
        3. head 와 tail 이 아닌 나머지 부분에 삽입
            - head 노드에서 next 로 목표 인덱스(노드)까지 계속 참조해서 가는 경우
         */
        if (index == 0) {
            newNode.next = this.head; // 새로 생성한 노드의 next 가 head 를 가리킨다.

            if (this.head != null) {
                // 데이터가 1개 이상일 때
                this.head.prev = newNode; // 기존 head 가 가리키던 노드의 이전 노드를 새로 삽입할 노드로 설정
            }

            this.head = newNode; // 새로 생성한 노드로 head 변경
        } else if (index == this.count) {
            newNode.next = null; // 새로운 노드의 다음 노드를 null 로 설정
            newNode.prev = this.tail; // 새로운 노드의 이전 노드를 tail 이 가리키던 노드로 설정
            this.tail.next = newNode; // tail 이 가리키던 노드의 다음 노드를 새로운 노드로 설정
            // 새로 삽입된 마지막 위치의 노드를 tail 로 만들어주기 -> 공통으로 처리하기 위해 if-else 밖에서 처리
        } else {
            DoublyNode currentNode = this.head; // 삽입하려는 노드 바로 전까지 가기 위한 변수

            // 목표 인덱스(노드) 바로 전까지 next 를 이용해 currentNode 를 이동시킨다.
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next; // 새로운 노드가 currentNode 의 next 노드를 가리킨다.
            newNode.prev = currentNode; // 새로운 노드의 이전 노드를 currentNode 로 설정
            currentNode.next = newNode; // currentNode 가 새로운 노드를 가리킨다.
            newNode.next.prev = newNode; // 새로 삽입한 노드의 다음 노드의 이전 노드를 새로 삽입한 노드로 설정
        }

        // 새로 삽입된 마지막 위치의 노드를 tail 로 만들어주기
        if (newNode.next == null) {
            // 새로 삽입한 노드의 다음 노드가 null 이라면, 즉 새로 삽입한 노드가 마지막 노드라면
            this.tail = newNode;
        }

        this.count++;
    }

    // 4. 마지막 노드 삽입 - 마지막 데이터 뒤에 삽입하는 기능
    public void insertLast(Object data) {
        insertAt(this.count, data);
    }

    // 5. 인덱스(노드) 삭제
    public DoublyNode deleteAt(int index) {
        // 매개변수 유효성 검사
        if (index >= this.count || index < 0) {
            throw new IllegalArgumentException("제거할 수 없습니다.");
        }

        DoublyNode currentNode = this.head; // 노드를 순회할 변수

        /*
        2가지 상황
        1. head 노드, 즉 첫 번째 노드를 제거하는 상황
            - head 노드를 제거하는 상황
        2. 마지막 노드 제거하는 경우
        3. head 와 tail 이 아닌 나머지 노드를 제거하는 상황
         */
        if (index == 0) {
            DoublyNode deletedNode = this.head; // 삭제된 노드를 리턴하기 위해서 삭제될 노드를 저장

            if (this.head.next == null) {
                // 데이터가 1개일 때
                this.head = null;
                this.tail = null;
            } else {
                // 데이터가 2개 이상일 때
                // head 에 있는 노드가 제거되기 때문에
                this.head = this.head.next; // head 의 다음 노드를 새로운 head 로 만들어준다.
                this.head.prev = null; // 새로운 head 가 된 이전 노드를 null 로 설정해 연결을 끊어준다.

                // 기존에 head 는 더이상 접근할 수 없기 때문에 가비지 컬렉터에 의해서 메모리에서 제거됨
            }
            this.count--;
            return deletedNode;
        } else if (index == this.count - 1) {
            DoublyNode deletedNode = this.tail; // tail 이 가리키는 노드를 삭제할 노드로 설정
            this.tail.prev.next = null; // tail 의 이전 노드의 다음 노드를 null 로 설정
            this.tail = this.tail.prev; // tail 의 이전 노드를 tail 로 설정
            this.count--;
            return deletedNode;
        } else {
            // for 문으로 제거할 노드 이전 노드까지 순회
            // 결과적으로, currentNode는 제거할 노드의 이전 노드를 가리킨다.
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            // 제거한 노드 반환하기 위해 변수에 저장
            DoublyNode deletedNode = currentNode.next;
            // 제거할 노드의 이전 노드(currentNode)가 제거할 노드의 next 노드를 가리키게 한다.
            currentNode.next = currentNode.next.next;
            // 이전 노드 설정
            currentNode.next.prev = currentNode; // 현재 노드의 다음 노드의 이전 노드를 현재 노드로 설정
            count--;

            return deletedNode;
        }
    }

    // 6. 마지막 노드 삭제
    public DoublyNode deleteLast() {
        // 노드 수 - 1 이 마지막 인덱스를 가리킨다. (인덱스는 0부터 시작하니깐)
        return deleteAt(this.count - 1);
    }

    // 7. 인덱스(노드) 읽기
    public DoublyNode getNodeAt(int index) {
        // 매개변수 유효성 검사
        if (index >= this.count || index < 0) {
            throw new IllegalArgumentException("범위를 넘어갔습니다.");
        }

        // 리스트를 순회할 변수 생성
        DoublyNode currentNode = this.head;
        // currentNode 가 해당 인덱스까지 순회
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}
