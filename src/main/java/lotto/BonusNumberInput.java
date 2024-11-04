package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BonusNumberInput {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static int requestBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseAndValidateBonusNumber(input, winningNumbers);
    }

    public static int parseAndValidateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}