package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {

    private static final String PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    @Override
    public Integer inputPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_MESSAGE);

        try {
            String input = Console.readLine();

            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);

        try {
            String input = Console.readLine();

            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }

    @Override
    public int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);

        try {
            String input = Console.readLine();

            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }
}
