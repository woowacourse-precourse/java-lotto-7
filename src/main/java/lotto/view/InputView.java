package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import lotto.model.InputConverter;
import lotto.validator.InputValidator;
import lotto.validator.LottoValidator;
import lotto.validator.PriceValidator;

public class InputView {

    private final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private String readLine() {
        return Console.readLine();
    }

    public int inputPrice() {
        while (true) {
            try {
                System.out.println(INPUT_PRICE_MESSAGE);
                String inputPrice = readLine();
                InputValidator.validateSingleNumberInput(inputPrice);
                int usingPrice = Integer.parseInt(inputPrice);
                PriceValidator.validatePrice(usingPrice);
                return usingPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Set<Integer> inputWinNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WIN_NUMBERS);
                String inputWinNumbers = readLine();
                InputValidator.validateWinNumbers(inputWinNumbers);
                return InputConverter.convertWinNumbers(inputWinNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(Set<Integer> winNumbers) {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER);
                String inputBonusNumber = readLine();
                InputValidator.validateSingleNumberInput(inputBonusNumber);
                int bonusNumber = InputConverter.convertBonusNumber(inputBonusNumber);
                LottoValidator.validateNotContainBonusNumber(winNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
