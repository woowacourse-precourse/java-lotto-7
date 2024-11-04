package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputBuyingPriceView() {
        try {
            String buyingPrice = Console.readLine();

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
