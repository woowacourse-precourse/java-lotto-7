package lotto.view;

import static lotto.utils.InputUtil.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputUtil;
import lotto.validator.UserBuyingValidator;

public class InputView {
    private final UserBuyingValidator userBuyingValidator = new UserBuyingValidator();

    public int inputBuyingPrice() {
        try {
            String buyingPrice = Console.readLine();
            userBuyingValidator.validateBuyingValidation(buyingPrice);
            return toIntStringNumberParser(buyingPrice);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }

    public String inputLottoNumbersView() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public String inputBonusNumberView() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
