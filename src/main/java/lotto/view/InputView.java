package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputDomain;
import lotto.exception.ExceptionHandler;
import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class InputView {
    public static int getAmount() {
        while (true) {
            int amount = readAmount();
            if (amount != -1) {
                return amount;
            }
        }
    }

    private static int readAmount() {
        try {
            System.out.println("구입금액을 입력해주세요.");
            String input = Console.readLine();

            Validator.validateInput(input);

            return getLottoAmount(input);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handleIllegalArgumentException(e);
            return -1;
        }
    }

    private static int getLottoAmount(String input) {
        final int DIVIDER = 1000;
        int value = parseInt(input);

        return value / DIVIDER;
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            List<Integer> winningNumbers = readWinningNumbers();
            if (winningNumbers != null) {
                return winningNumbers;
            }
        }
    }

    private static List<Integer> readWinningNumbers() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            return InputDomain.convertWinningNumber(input);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handleIllegalArgumentException(e);
            return null;
        }
    }

    public static int getBonusNumber() {
        while (true) {
            int bonusNumber = readBonusNumber();
            if (bonusNumber != -1) {
                return bonusNumber;
            }
        }

    }

    private static int readBonusNumber() {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            return InputDomain.convertBonusNumber(input);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handleIllegalArgumentException(e);
            return -1;
        }
    }
}