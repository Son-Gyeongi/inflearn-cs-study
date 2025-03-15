package sectionThree.mission.recursion;

import java.io.File;

public class FileSearchRecursion {
    public static void traverseDirectory(String dir) {
        if (dir == null || dir.isEmpty()) return;

        File startDir = new File(dir);

        if (!startDir.exists()) {
            System.out.println(dir + " 디렉토리 또는 파일은 존재하지 않습니다.");
            return;
        }

        File[] files = startDir.listFiles();

        if (files == null) return;

        for (File file : files) {
            File filePath = new File(String.valueOf(file));

            if (filePath.isDirectory()) {
                System.out.println("디렉토리:" + filePath);
                traverseDirectory(filePath.getAbsolutePath()); // 재귀함수 호출
            } else {
                System.out.println("파일:" + filePath);
            }
        }
    }

    public static void main(String[] args) {
        traverseDirectory(".");
    }
}
