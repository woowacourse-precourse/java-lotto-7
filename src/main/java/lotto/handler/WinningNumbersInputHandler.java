package lotto.handler;

import lotto.domain.lottoForm.WinningNumbers;

import static lotto.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.message.ErrorMessage.LOTTO_SCOPE_ERROR;
import static lotto.message.ErrorMessage.NON_INTEGER_PURCHASE_AMOUNT;
import static lotto.view.RequestView.getBonusInput;
import static lotto.view.RequestView.getInputNumbers;


public class WinningNumbersInputHandler {
    public WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String input = getInputNumbers();
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(WinningNumbers winningNumbers){
        while (true){
            try{
                String input = getBonusInput();
                int number = convertToInteger(input);
                validateScope(number);
                winningNumbers.validateDuplicate(number);
                return number;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateScope(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX){
            throw new IllegalArgumentException(LOTTO_SCOPE_ERROR.getMessage());
        }
    }

    public int convertToInteger(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_PURCHASE_AMOUNT.getMessage());
        }
    }


}
