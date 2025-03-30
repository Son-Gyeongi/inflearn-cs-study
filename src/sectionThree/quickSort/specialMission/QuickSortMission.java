package sectionThree.quickSort.specialMission;

import java.util.Arrays;

public class QuickSortMission {
    public static void quickSortM(Runner[] runners, int left, int right) {
        if (left <= right) {
            int pivot = divideM(runners, left, right);

            quickSortM(runners, left, pivot - 1);
            quickSortM(runners, pivot + 1, right);
        }

        // 정렬이 다 끝난 후 - 가장 첫 번째 데이터인 '나'의 출석수를 변경
        if (right == runners.length - 1) {
            runners[0].setCount(5);
        }
    }

    public static int divideM(Runner[] runners, int left, int right) {
        int pivot = runners[left].getCount();
        int leftStartIndex = left + 1;
        int rightStartIndex = right;

        while (leftStartIndex <= rightStartIndex) {

            while (leftStartIndex <= right && pivot >= runners[leftStartIndex].getCount()) {
                leftStartIndex++;
            }

            while (rightStartIndex >= (left + 1) && pivot <= runners[rightStartIndex].getCount()) {
                rightStartIndex--;
            }

            if (leftStartIndex <= rightStartIndex) {
                swapM(runners, leftStartIndex, rightStartIndex);
            }
        }

        swapM(runners, left, rightStartIndex);
        return rightStartIndex;
    }

    public static void swapM(Runner[] runners, int index1, int index2) {
        Runner temp = runners[index1];
        runners[index1] = runners[index2];
        runners[index2] = temp;
    }

    public static void main(String[] args) {
        Runner user1 = new Runner("홍길동", 5);
        Runner user2 = new Runner("임꺽정", 4);
        Runner user3 = new Runner("이순신", 3);
        Runner user4 = new Runner("나", 1);
        Runner user5 = new Runner("짱구", 5);

        Runner[] runners = {user1, user2, user3, user4, user5};

        System.out.println("===== 정렬 전 =====");
        System.out.println(Arrays.toString(runners));

        quickSortM(runners, 0, runners.length - 1);

        System.out.println("===== 정렬 후 =====");
        System.out.println(Arrays.toString(runners));
    }
}
