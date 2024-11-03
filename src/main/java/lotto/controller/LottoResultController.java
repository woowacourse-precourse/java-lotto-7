package lotto.controller;

import lotto.model.*;
import lotto.view.LottoResultView;
import lotto.view.PrizeNumbersView;

import java.util.List;

public class LottoResultController {
    private LottoResultChecker resultChecker;
    private PrizeNumbers prizeNumbers;
    private BonusNumbers bonusNumbers;

    private final LottoResultView resultView = new LottoResultView();
    private final PrizeNumbersView prizeNumbersView = new PrizeNumbersView();
    private final List<Lotto> purchaseLottoList;
    private final Integer buyPrice;

    // 발급 로또 리스트, 당첨 번호, 보너스 번호, 구매 금액
    public LottoResultController(List<Lotto> purchaseLottoList, Integer buyPrice) {
        this.purchaseLottoList = purchaseLottoList;
        this.buyPrice = buyPrice;
    }

    public void checkForInputPrizeNumbers() {
        while (true) {
            if (getInputPrizeNumbers()) {
                break;
            }
        }
    }

    public void checkForInputBonusNumbers() {
        while (true) {
            if (getInputBonusNumbers()) {
                break;
            }
        }
    }

    public boolean getInputPrizeNumbers() {
        try {
            this.prizeNumbers = new PrizeNumbers(prizeNumbersView.getPrizeNumbers());
            return true;
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return false;
        }
    }

    public boolean getInputBonusNumbers() {
        try {
            this.bonusNumbers = new BonusNumbers(prizeNumbersView.getBonusNumber());
            hasSameNumberCheckPrizeAndBonus();

            return true;
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return false;
        }
    }

    /**
     * 당첨번호와 보너스 번호를 통합해서 같은번호가 존재하는지
     */
    private void hasSameNumberCheckPrizeAndBonus() {
        List<Integer> prizeNumberList = prizeNumbers.getPrizeNumberList();
        Integer bonusNumber = bonusNumbers.getBonusPrizeNumber();
        for (Integer integer : prizeNumberList) {
            if (integer.equals(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호 중 하나와 동일합니다.");
            }
        }
    }

    public void outputResult() {
        checkForInputPrizeNumbers();
        checkForInputBonusNumbers();

        List<Integer> prizeNumberList = this.prizeNumbers.getPrizeNumberList();
        Integer bonusNumber = this.bonusNumbers.getBonusPrizeNumber();

        this.resultChecker = new LottoResultChecker(this.purchaseLottoList, prizeNumberList, bonusNumber, this.buyPrice);

        resultView.outputLottoResult(resultChecker.getLottoResultMap());
        resultView.outputProfitMargin(resultChecker.getProfitMargin());

    }


}
