package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputHandler {
    public static final String CREDIT = "구입금액을 입력해 주세요.";
    private static final String NOT_MULTIPLE_1000 = "[ERROR] 구입 금액은 1,000의 배수여야 합니다.";
    private static final String NOT_A_NUM = "[ERROR] 숫자를 입력하세요.";
    private static final String SAME_NUMBER = "[ERROR] 당첨 번호에 중복된 숫자가 존재합니다.";
    private static final String SAME_BONUS_NUMBER = "[ERROR] 당첨번호에 보너스 번호와 중복된 숫자가 존재합니다.";
    public static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int getCredit() {
        System.out.println(CREDIT);
        try {
            return parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCredit();
        }
    }

    public static int getPieces(int credit) {
        try {
            return checkCredit(credit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCredit();
        }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUM);
        }
    }

    public static int checkCredit(int credit) {
        if (credit % 1000 != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_1000);
        }
        return credit / 1000;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBER);
        List<Integer> winningNumbers = readAndParseNumbers();
        try {
            checkSameNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
        return winningNumbers;
    }

    private static List<Integer> readAndParseNumbers() {
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : inputNumbers) {
            try {
                winningNumbers.add(parseInt(number.trim()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return getWinningNumbers();
            }
        }
        return winningNumbers;
    }

    public static void checkSameNumber(List<Integer> winningNumbers) {
        if(new HashSet<>(winningNumbers).size() != winningNumbers.size()) {
            throw new IllegalArgumentException(SAME_NUMBER);
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER);
        int bonusNumber;
        try {
            bonusNumber = parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
        try {
            checkBonusNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }

    public static void checkBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(SAME_BONUS_NUMBER);
        }
    }
}
