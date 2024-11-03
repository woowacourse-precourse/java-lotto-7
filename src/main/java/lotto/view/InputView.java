package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoNumbersInput;
import lotto.dto.PurchaseTotalPriceInput;

public class InputView {

    public PurchaseTotalPriceInput readPurchaseTotalPrice() {
        String input = Console.readLine();
        return new PurchaseTotalPriceInput(input.trim());
    }

    public LottoNumbersInput readLottoNumbers() {
        String input = Console.readLine();
        return new LottoNumbersInput(input.trim());
    }
}
