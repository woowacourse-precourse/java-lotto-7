package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;
import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;
import lotto.util.LottoValueUtil;

import java.util.Set;

public class InputView {

    public int readLottoAmount() {
        try {
            String input = readLine();
            return LottoValueUtil.toLottoAmount(input);
        } catch (IllegalArgumentException e) {
            return readLottoAmount();
        }
    }

    public Set<Integer> readWinningNumbers() {
        try {
            String input = readLine();
            return LottoValueUtil.toWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            return readWinningNumbers();
        }
    }

    public void readBonusNumber(WinningNumbers winningNumbers) {
        try {
            String input = readLine();
            int bonusNumber = LottoValueUtil.toBonusNumber(input);
            winningNumbers.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            readBonusNumber(winningNumbers);
        }
    }

    private String readLine() {
        while (true) {
            try {
                String input = Console.readLine().trim();
                validInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                ExceptionHandler.inputException(ErrorMessage.INVALID_INPUT);
            }
        }
    }

    private void validInput(String input) throws IllegalArgumentException {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

}
