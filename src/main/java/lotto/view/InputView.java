package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputBuyingPriceView() {
        try {
            String buyingPrice = Console.readLine();
            BuyingPriceValidator validator = new BuyingPriceValidator();
            validator.validate(buyingPrice);
            return Integer.parseInt(buyingPrice);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(exception.getMessage());
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
