package sectionTwo.mission.hashtable;

import sectionTwo.hashtable.HashData;
import sectionTwo.queue.DoublyLinkedList;
import sectionTwo.queue.DoublyNode;

/*
미션 - 해시 함수에 이름을 이용해 데이터를 골고루 분산시키는 코드로 수정
해시 테이블
- 해시함수로 키를, 값은 이중연결리스트로 저장
- DoublyLinkedList(이중연결리스트)로 구현
 */
public class HashTableMission {
    Object[] arr = new Object[10];

    /*
    선수들의 등 번호를 0부터 9로 줄여서 저장하기 위해
    반복문으로 0부터 9까지 돌아가며 각 배열의 원소를 연결리스트로 초기화 해준다.
     */
    public HashTableMission() {
        for (int i = 0; i < 10; i++) {
            // 인덱스마다 빈 연결리스트 생성 -> 원소마다 빈 이중연결리스트가 만들어진다.
            this.arr[i] = new DoublyLinkedList();
        }
    }

    public Object[] getArr() {
        return arr;
    }

    // 해시 테이블에서 가장 중요한 게 해시함수
    // 이름을 이용해 데이터를 골고루 분산시키기
    public int hashFunction(Object name) {
        // name1 = "이운재"; / 이운재의 0번 인덱스 ‘이’의 유니코드(51060) 출력
        String name1 = (String) name;
        return name1.charAt(0) % 10;
    }

    /*
    해시 테이블에 필요한 연산
     */
    // 1. set - 해시 테이블에 데이터 삽입
    public void set(int key, Object value) {
        DoublyLinkedList list = (DoublyLinkedList) this.arr[this.hashFunction(value)];
        // 첫 번째 원소에 해시 데이터를 생성해서 삽입
        list.insertAt(0, new HashData(key, value));
    }

    // 2. get - 데이터 읽기 / 해당 key 의 value 를 읽는 기능
    public Object get(Object key) {
        // 해시 함수로 배열의 인덱스 찾기
        DoublyLinkedList list = (DoublyLinkedList) this.arr[this.hashFunction(key)];
        // 해당 인덱스에 있는 리스트의 head 를 현재 노드로 가리킨다.
        DoublyNode currentNode = list.getHead();

        /*
        리스트가 비어있지 않은 경우
        - 리스트를 차례대로 순회하면서 해당 데이터의 key 가 get() 함수의 인자로 받은 key 와 같은지 비교
        - 같으면 리턴
         */
        // 현재 노드가 null 일 때까지 반복, 즉 리스트의 끝일 때까지 반복
        while (currentNode != null) {
            HashData data = (HashData) currentNode.getData();

            if (data.getValue().equals(key)) {
                return data.getValue();
            }

            // 같은 키를 못 찾은 경우 다음 노드 가리킨다.
            currentNode = currentNode.getNext();
        }

        // 리스트가 비어있거나 리스트의 끝까지 갔는데 찾는 값이 없다면
        return null;
    }

    // 3. remove - 데이터 제거 / 해당 key 의 value 를 제거하는 기능
    public DoublyNode remove(Object key) {
        // 해시함수로 해당 배열의 리스트를 가져온다.
        DoublyLinkedList list = (DoublyLinkedList) this.arr[this.hashFunction(key)];
        // 반복문에서 사용하기 위해 리스트의 헤드를 가져온다.
        DoublyNode currentNode = list.getHead();
        // 삭제할 데이터의 인덱스를 저장할 변수를 선언
        int deletedIndex = 0;

        // 현재 노드가 null 일 때까지 반복, 즉 리스트의 끝일 때까지 반복
        while (currentNode != null) {
            HashData data = (HashData) currentNode.getData();
            if (data.getValue().equals(key)) {
                // 현재 노드의 데이터의 키가 찾는 키라면
                return list.deleteAt(deletedIndex);
            }

            // 키가 같지 않다면 다음 노드를 가리킨다.
            currentNode = currentNode.getNext();
            deletedIndex++; // 삭제할 인덱스(노드) +1
        }

        // 삭제하려는 값이 없을 경우 null 리턴
        return null;
    }
}
