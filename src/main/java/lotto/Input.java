package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String stringInput() {
        return Console.readLine().trim();
    }

    public static int intInput() {
        String sentence = stringInput();
        int result = 0;
        try {
            result = parseInput(sentence);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다시 입력해주세요.");
            return intInput();
        }
        if (result != Integer.MIN_VALUE) {
            return result;
        }
        System.out.println("[ERROR] 숫자와 구분자만 입력 가능합니다.");
        return intInput(); // 재귀 호출로 다시 입력 받기
    }

    private static int parseInput(String sentence) {
        try {
            return Integer.parseInt(sentence);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자와 구분자만 입력 가능합니다."); // 예외 발생
        }
    }

    public static String[] splitInput() {
        String[] split;
        try {
            split = Input.stringInput().split(",");
            isSix(split);
            return split;
        } catch (IllegalArgumentException e) {
            System.out.println("다시 값을 입력해주세요.");
            return splitInput();
        }
    }

    private static void isSix(String[] target) {
        if (target.length!=6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 값으로 이루어져야 합니다.");
        }
    }
}
