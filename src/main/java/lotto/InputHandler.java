package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static final String CREDIT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NOT_MULTIPLE_1000 = "[ERROR] 구입 금액은 1,000의 배수여야 합니다.";
    private static final String NOT_A_NUM = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int getCredit() {
        System.out.println(CREDIT_MESSAGE);
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
        System.out.println(WINNING_NUMBER_MESSAGE);
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputNumbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
