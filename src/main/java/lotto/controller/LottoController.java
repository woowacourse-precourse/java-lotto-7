package lotto.controller;

import global.utils.Validator;
import global.view.InputView;
import global.view.OutputView;
import java.math.BigInteger;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void payingForLotto() {
        BigInteger purchaseAmount = paying();
        generateLotto(purchaseAmount);
        OutputView.printLottoNumbers(lottoService.getAll());
    }

    public void checkLottoResult() {
        Map<LottoRank, Integer> matchedResults = lottoService.getMatchedResults();
        double profitRate = lottoService.calculateProfitRate(matchedResults);
        OutputView.printFinalResult(matchedResults, profitRate);
    }

    //FIXME: BigInteger로 변환하는 것, Controller에서 처리하는 것이 맞는가?
    private BigInteger paying() {

        String input = InputView.inputPurchaseAmount();

        try {
            Validator.validatePurchaseAmount(input);
        } catch (Exception e) {
            return paying();
        }

        return new BigInteger(input);
    }

    private void generateLotto(BigInteger purchaseAmount) {
        lottoService.generateByPurchaseAmount(purchaseAmount);
    }
}