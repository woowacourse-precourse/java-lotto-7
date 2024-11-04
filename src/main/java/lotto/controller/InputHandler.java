package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class InputHandler {

    public int readPurchaseAmount() {
        final int amount = parseToInteger(readLine());
        validatePositive(amount);
        return amount;
    }

    public Lotto readWinningNumber() {
        final String regex = ",";
        final String input = readLine();
        final List<Integer> number = Arrays.stream(input.split(regex))
                .map(Integer::parseInt)
                .toList();
        return new Lotto(number);
    }

    public int readBonusNumber() {
        final int bonusNumber = parseToInteger(readLine());
        validatePositive(bonusNumber);
        return bonusNumber;
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validatePositive(int input) {
        final int zero = 0;
        if (input < zero) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
    }
}
