package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {
    Validator validator = new Validator();

    public int getPaymentInput() {
        String userPaymentInput = Console.readLine();
        return validator.validateAndGetUserPriceInput(userPaymentInput);
    }

    public List<Integer> getLottoNumberInput() {
        String lottoNumberInput = Console.readLine();
        return validator.validateAndGetLottoNumber(lottoNumberInput);
    }

    public int getBonusNumberInput(List<Integer> numbers) {
        String userBonusNumberInput = Console.readLine();
        int bonusNumber = validator.validateAndGetBonusNumber(userBonusNumberInput);

        validator.checkLottoNumbersContainsBonusNumber(numbers, bonusNumber);
        return bonusNumber;
    }
}
