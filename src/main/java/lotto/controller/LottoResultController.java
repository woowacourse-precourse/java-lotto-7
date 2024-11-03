package lotto.controller;

import lotto.LottoWinningRank;
import lotto.model.Lotto;
import lotto.model.LottoResultChecker;
import lotto.model.PrizeNumbers;
import lotto.view.LottoResultView;
import lotto.view.PrizeNumbersView;

import java.lang.reflect.Type;
import java.util.*;

public class LottoResultController {
    private LottoResultChecker resultChecker;
    private PrizeNumbers prizeNumbers;
    private PrizeNumbersView prizeNumbersView = new PrizeNumbersView();
    private LottoResultView resultView = new LottoResultView();

    // 발급 로또 리스트, 당첨 번호, 보너스 번호, 구매 금액
    public LottoResultController(List<Lotto> purchaseLottoList, Integer buyPrice) {

        this.prizeNumbers = new PrizeNumbers(prizeNumbersView.getPrizeNumbers(), prizeNumbersView.getBonusNumber());

        List<Integer> prizeNumbers = this.prizeNumbers.getPrizeNumberList();
        Integer bonusNumber = this.prizeNumbers.getBonusPrizeNumber();

        this.resultChecker = new LottoResultChecker(purchaseLottoList, prizeNumbers, bonusNumber,buyPrice);
        resultView.outputLottoResult(resultChecker.getLottoResultMap());
        resultView.outputProfitMargin(resultChecker.getProfitMargin());
    }






}
