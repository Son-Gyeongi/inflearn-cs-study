package sectionThree.quickSort.specialMission;

public class Runner {
    private String name;
    private int count;

    private static final int MIN_CHECK = 0; // 최소 참여수
    private static final int MAX_CHECK = 5; // 최대 참여수

    public Runner(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (!(MIN_CHECK <= count && count <= MAX_CHECK)) return;
        this.count = count;
    }

    @Override
    public String toString() {
        return "{name: '" + name + "', count: " + count + '}';
    }
}
