package lotto.handler;

import lotto.domain.LottoNumber;
import lotto.domain.lottoForm.WinningNumbers;

import static lotto.message.ErrorMessage.NON_INTEGER_LOTTO;
import static lotto.view.RequestView.getBonusInput;
import static lotto.view.RequestView.getInputNumbers;


public class NumbersInputHandler {
    public WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = getInputNumbers();
                return WinningNumbers.from(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LottoNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String input = getBonusInput();
                int number = convertToInteger(input);
                LottoNumber bonusNumber = new LottoNumber(number);
                winningNumbers.validateDuplicate(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int convertToInteger(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_LOTTO.getMessage());
        }
    }


}
