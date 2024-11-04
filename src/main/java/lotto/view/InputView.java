package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputBuyingPriceView() {
        String buyingPrice = Console.readLine();
        return buyingPrice;
    }

    public String inputWinningLottoNumbersView() {
        String winningLottoNumbers = Console.readLine();
        return winningLottoNumbers;
    }

    public String inputBonusNumberView() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
