package lotto.controller;

import lotto.model.LottoGameInfo;
import lotto.service.LottoGenerator;
import lotto.ui.InputView;

import java.util.List;

import static lotto.ui.InputView.getPurchaseAmount;

public class LottoController {

    public void startGame() {
        // 구매금액
        int purchaseAmount = getPurchaseAmount();
        LottoGameInfo gameInfo = new LottoGameInfo();
        gameInfo.setPurchaseAmount(purchaseAmount);

        //당첨 번호
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        gameInfo.setWinningNumber(winningNumbers);

        //보너스번호
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        gameInfo.setBonusNumber(bonusNumber);






    }
}
