package lotto;

import lotto.controller.*;
import lotto.dto.BonusNumberRequestDto;
import lotto.dto.PurchaseAmountRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.model.Lottos;

public class Application {
    public static void main(String[] args) {
        PurchaseAmountRequestDto purchaseAmountRequestDto = PurchaseAmountController.run();
        Lottos lottos = LottoController.run(purchaseAmountRequestDto);
        WinningNumbersRequestDto winningNumbersRequestDto = WinningNumbersController.run();
        BonusNumberRequestDto bonusNumberRequestDto = BonusNumberController.run();
        ProfitController.run(lottos, winningNumbersRequestDto, bonusNumberRequestDto);
    }
}
