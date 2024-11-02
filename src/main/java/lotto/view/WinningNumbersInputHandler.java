package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersInputHandler {

    public static List<Integer> promptGetWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = validateWinningNumbers(input);
        return winningNumbers;
    }

    public static List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers = validateWinningNumbersAreInteger(input);
        validateWinningNumbersRange(winningNumbers);
        return winningNumbers;
    }

    public static List<Integer> validateWinningNumbersAreInteger(String input) {
        List<String> inputConvertedBySplit = List.of(input.split(","));
        if (inputConvertedBySplit.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들은 정수여야 합니다.");
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String el : inputConvertedBySplit) {
            try{
                winningNumbers.add(Integer.parseInt(el));
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호들은 정수여야 합니다.");
            }
        }
        return winningNumbers;
    }

    public static void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer num : winningNumbers) {
            if (num < 1 || 45 < num) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 정수 값이어야 합니다.");
            }
        }
    }
}
