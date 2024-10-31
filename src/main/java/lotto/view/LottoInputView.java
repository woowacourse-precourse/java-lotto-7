package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputParser;

import java.util.List;

public class LottoInputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getMoneyInput() {
        Integer moneyInput;
        while (true) {
            try {
                System.out.println(INPUT_MONEY_MESSAGE);
                moneyInput = InputParser.parseMoney(Console.readLine());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return moneyInput;
    }

    public List<Integer> getNumbersInput() {
        List<Integer> numbersInput;
        while (true) {
            try {
                System.out.println(INPUT_NUMBERS_MESSAGE);
                numbersInput = InputParser.parseNumbers(Console.readLine());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numbersInput;
    }

    public Integer getBonusNumberInput() {
        Integer bonusNumberInput;
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
                bonusNumberInput = InputParser.parseBonusNumber(Console.readLine());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumberInput;
    }
}
