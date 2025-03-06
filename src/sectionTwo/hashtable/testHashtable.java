package sectionTwo.hashtable;

public class testHashtable {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // 축구 선수들의 등번호와 이름 넣기
        hashTable.set(1, "이운재");
        hashTable.set(4, "최진철");
        hashTable.set(20, "홍명보");
        hashTable.set(6, "유상철");
        hashTable.set(22, "송종국");
        hashTable.set(21, "박지성");
        hashTable.set(5, "김남일");
        hashTable.set(10, "이영표");
        hashTable.set(8, "최태욱");
        hashTable.set(9, "설기현");
        hashTable.set(14, "이천수");

        // 등번호 1번 선수를 get() 함수로 접근
        System.out.println("1: " + hashTable.get(1));
        // remove() 함수로 등번호 1번 선수를 제거
        hashTable.remove(1);
        // 제거가 잘 되었는지 get() 함수로 다시 확인
        System.out.println("1: " + hashTable.get(1));
        // 1번 선수만 잘 제거되었는지 확인하기 위해서 21벊 선수를 출력
        System.out.println("21: " + hashTable.get(21));
    }
}
