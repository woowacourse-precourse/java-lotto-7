package lotto.view;

import static lotto.utils.InputUtil.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.UserBuyingValidator;

public class InputView {
    private final UserBuyingValidator userBuyingValidator = new UserBuyingValidator();

    public int inputBuyingPrice() {
        try {
            String buyingPrice = Console.readLine();
            userBuyingValidator.validateBuyingValidation(buyingPrice);
            return toIntStringNumberParser(buyingPrice);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력은 양수만 가능합니다.");
        }
    }

    public List<Integer> inputLottoNumbersView() {
        String lottoNumbers = Console.readLine();
        return lottoNumberParser(lottoNumbers);
    }

    public String inputBonusNumberView() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
