package lotto.controller;

import global.utils.Validator;
import java.math.BigInteger;
import java.util.Map;
import lotto.constant.LottoRanking;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoService lottoService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView,
                           LottoService lottoService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoService = lottoService;
    }

    public void payingForLotto() {
        BigInteger purchaseAmount = paying();
        generateLotto(purchaseAmount);
        lottoOutputView.printLottoNumbers(lottoService.getAll());
    }

    public void checkLottoResult() {
        Map<LottoRanking, Integer> matchedResults = lottoService.getMatchedResults();
        double profitRate = lottoService.calculateProfitRate(matchedResults);
        lottoOutputView.printFinalResult(matchedResults, profitRate);
    }

    //FIXME: BigInteger로 변환하는 것, Controller에서 처리하는 것이 맞는가?
    private BigInteger paying() {

        String input = lottoInputView.inputPurchaseAmount();

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