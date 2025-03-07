package sectionTwo.set;

import sectionTwo.hashtable.HashData;
import sectionTwo.hashtable.HashTable;
import sectionTwo.queue.DoublyLinkedList;
import sectionTwo.queue.DoublyNode;

/*
셋
- 데이터의 중복을 허요하지 않는 자료구조
- HashTable 로 구현
    - 해시 테이블의 value 값은 사용하지 않고 key 만 사용해서 구현
    - key 가 key 임과 동시에 데이터로 쓰인다.
 */
public class HashSet {
    // 셋에서 이용할 해시 테이블 초기화
    HashTable hashTable = new HashTable();

    /*
    셋에 필요한 연산
     */
    // 1. add - 데이터 삽입 / 매개변수로 data 가 하나 전달되는데 이 data 가 key 이자 데이터이다.
    public void add(int data) {
        // 셋의 특징인 중복 방지 - 해시 테이블에 data 에 해당하는 key 가 없다면 새로 삽입
        if (this.hashTable.get(data) == null) {
            this.hashTable.set(data, -1);
        }
    }

    // 2. isContain - 데이터 체크 / 셋에 해당 데이터가 있는지 체크하는 기능
    public boolean isContain(int data) {
        return this.hashTable.get(data) != null;
    }

    // 3. remove - 데이터 제거 / 해시 테이블에서 해당 key 를 제거한다는 의미
    public void remove(int data) {
        this.hashTable.remove(data);
    }

    // 4. clear - 셋 비우기
    public void clear() {
        // 해시 테이블을 이루고 있는 모든 배열의 리스트를 초기화하기
        for (int i = 0; i < this.hashTable.getArr().length; i++) {
            DoublyLinkedList list = (DoublyLinkedList) this.hashTable.getArr()[i];
            list.clear();
        }
    }

    // 5. isEmpty - 셋이 비었는지 체크
    public boolean isEmpty() {
        // clear() 와 비슷한 메커니즘으로 만들기

        boolean empty = true;

        for (int i = 0; i < this.hashTable.getArr().length; i++) {
            // 해당 배열의 리스트 카운트가 0보다 크면 비어있지 않다는 의미
            DoublyLinkedList list = (DoublyLinkedList) this.hashTable.getArr()[i];
            if (list.getCount() > 0) {
                empty = false;
                break; // 데이터가 하나라도 있으면 더이상 for 문을 순회할 필요가 없다.
            }
        }

        return empty;
    }

    // 6. printAll - 모든 데이터 출력
    public void printAll() {
        for (int i = 0; i < this.hashTable.getArr().length; i++) {
            // 해당 배열의 리스트를 순회하기 위해 head 참조
            DoublyLinkedList list = (DoublyLinkedList) this.hashTable.getArr()[i];
            DoublyNode currentNode = list.getHead();

            // 현재 노드를 리스트의 끝까지 이동시키면서 현재 노드의 key 를 출력
            while (currentNode != null) {
                HashData data = (HashData) currentNode.getData();
                System.out.println(data.getKey());
                currentNode = currentNode.getNext();
            }
        }
    }
}
