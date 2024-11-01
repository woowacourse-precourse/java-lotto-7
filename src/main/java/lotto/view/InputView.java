package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public Integer inputPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_MESSAGE);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);

        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }

    public int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }
}
