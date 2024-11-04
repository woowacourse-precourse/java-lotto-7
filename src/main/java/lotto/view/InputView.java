package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.input.BonusNumberInput;
import lotto.dto.input.LottoNumbersInput;
import lotto.dto.input.PurchaseTotalPriceInput;

public class InputView {

    public PurchaseTotalPriceInput readPurchaseTotalPrice() {
        String input = Console.readLine();
        return new PurchaseTotalPriceInput(input.trim());
    }

    public LottoNumbersInput readLottoNumbers() {
        String input = Console.readLine();
        return new LottoNumbersInput(input.trim());
    }

    public BonusNumberInput readBonusNumber() {
        String input = Console.readLine();
        return new BonusNumberInput(input.trim());
    }
}
