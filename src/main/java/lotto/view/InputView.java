package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputBuyingPriceView() {
        String buyingPrice = Console.readLine();
        return buyingPrice;
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
