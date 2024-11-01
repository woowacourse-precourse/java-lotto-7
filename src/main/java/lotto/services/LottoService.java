package lotto.services;

import lotto.views.*;
import lotto.models.LottoModel;

import java.util.ArrayList;

public class LottoService {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoModel lottoModel;

    public LottoService(InputView inputView) {
        this.inputView = inputView;
    }


    public void processPurchase() {
        String purchaseAmount = inputView.requestUserInput(InputView.promptForInput.Purchase);
        int amount = 0;
        try {
            amount = lottoModel.calculateAmount(purchaseAmount);
            outputView.displayPurchaseAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수여야 합니다.");
        } catch (IllegalArgumentException e) {
            processPurchase();
        }
    }





    
}
