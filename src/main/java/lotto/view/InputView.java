package lotto.view;

import static lotto.utils.InputUtil.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.LottoNumberValidator;
import lotto.validator.UserBuyingValidator;

public class InputView {
    private final UserBuyingValidator userBuyingValidator = new UserBuyingValidator();
    private final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

    public int inputBuyingPrice() {
        try {
            String buyingPrice = Console.readLine();
            userBuyingValidator.validateBuyingValidation(buyingPrice);
            return toIntStringNumberParser(buyingPrice);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("구매 금액이 잘못 입력됐습니다.");
        }
    }

    public List<Integer> inputLottoNumbersView() {
        try {
            String lottoNumbers = Console.readLine();
            List<Integer> numbers = lottoNumberParser(lottoNumbers);
            lottoNumberValidator.validateWinningNumbers(numbers);
            return numbers;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("로또번호 입력이 잘못됐습니다.");
        }
    }

    public String inputBonusNumberView() {
        try {
            String bonusNumber = Console.readLine();
            lottoNumberValidator.validateInput(bonusNumber);
            lottoNumberValidator.validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("보너스 번호 입력이 잘못됐습니다.");
        }
    }
}
