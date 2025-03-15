package sectionThree.mission;

import java.io.File;
import java.util.Stack;

public class FileSearch {
    public static void traverseDirectory(String dir) {
        File startDir = new File(dir);

        Stack<File> stack = new Stack(); // 순회해야 할 디렉토리를 저장할 스택
        File[] startFiles = startDir.listFiles(); // 인자로 주어진 경로의 디렉토리에 있는 파일 or 디렉토리들
        for (int i = 0; i < startFiles.length; i++) {
            stack.push(new File(String.valueOf(startFiles[i])));
        }

        while (!stack.isEmpty()) { // 스택이 빌 때까지 반복
            File currentDir = stack.pop();// 현재 디렉토리
            File[] files = currentDir.listFiles();// 인자로 주어진 경로의 디렉토리에 잇는 파일 or 디렉토리들

            if (files == null) continue;
            
            for (File file : files) { // 현재 디렉토리의 모든 파일 or 디렉토리 순회
                File filePath = new File(currentDir, file.getName()); // directory 와 file 을 하나의 경로로 합쳐줌 및 파일 정보 얻기
//                File fileStatus = new File(String.valueOf(filePath)); // 파일 정보 얻기, 윗 줄과 결과가 같아서 주석

                if (filePath.isDirectory()) { // 해당 파일이 디렉토리라면
                    System.out.println("디렉토리:" + filePath);
                    stack.push(filePath);
                } else { // 해당 파일이 파일이라면
                    System.out.println("파일:" + filePath);
                }
            }
        }
    }

    public static void main(String[] args) {
        traverseDirectory("."); // 현재 경로의 모든 하위 경로의 파일, 디렉토리 출력
    }
}
