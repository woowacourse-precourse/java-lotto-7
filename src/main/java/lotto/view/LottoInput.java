package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessages;
import lotto.exception.InvalidInputException;
import lotto.exception.LottoException;
import lotto.factory.WinningNumberPicker;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.util.RetryHandler;

public class LottoInput {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MAIN_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String NUMBER_REGEX = "^(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5}$";
    private final RetryHandler retryHandler;

    public LottoInput(int retryCount) {
        this.retryHandler = new RetryHandler(retryCount);
    }

    public Money getBuyAmount() {
        return retryHandler.execute(() -> {
            System.out.println(INPUT_AMOUNT_MESSAGE);
            try {
                return Money.of(Integer.parseInt(Console.readLine()));
            } catch (IllegalArgumentException error) {
                throw new InvalidInputException(ErrorMessages.INVALID_FORMAT);
            }
        });
    }

    public WinningNumbers getWinningNumbers() {
        return retryHandler.execute(() -> {
            String mainNumbers = getValidatedMainNumber();
            int bonusNumber = getValidatedBonusNumber();
            return WinningNumberPicker.createWinningNumbers(mainNumbers, bonusNumber);
        });
    }

    private String getValidatedMainNumber() {
        return retryHandler.execute(() -> {
            System.out.println(INPUT_MAIN_NUMBER_MESSAGE);
            String mainNumber = Console.readLine();
            if (!mainNumber.matches(NUMBER_REGEX)) {
                throw new LottoException(ErrorMessages.INVALID_FORMAT);
            }
            return mainNumber;
        });
    }

    private int getValidatedBonusNumber() {
        return retryHandler.execute(() -> {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            try {
                return Integer.parseInt(Console.readLine());
            } catch (IllegalArgumentException error) {
                throw new InvalidInputException(ErrorMessages.INVALID_FORMAT);
            }
        });
    }
}
