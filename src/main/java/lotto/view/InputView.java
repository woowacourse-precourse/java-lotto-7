package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoAmountValidator;

public class InputView {
    private final LottoAmountValidator lottoAmountValidator;

    public InputView() {
        this.lottoAmountValidator = new LottoAmountValidator();
    }

    public int setLottoPrice() {
        String price = Console.readLine();
        return lottoAmountValidator.validate(price);
    }
}