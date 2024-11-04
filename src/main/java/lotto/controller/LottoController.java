package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void start() {
        PaymentInput paymentInput = InputView.enterPayment();
        LottoGroup lottos = new LottoGroup(createLottos(paymentInput.getLottoCounts()));

        lottos.printEachInfo();

        DrawNumbers drawNumbers = InputView.enterWinningNumbers();
        LottoResult lottoResult= getPrizeResult(lottos, drawNumbers);
        //TotalGain totalGain = new TotalGain(lottoResult, paymentInput);

        OutputView.showResult(lottoResult,paymentInput);
    }


    private List<Lotto> createLottos(long lottoCounts) {
        List<Lotto> lottos = new ArrayList<>();

        for (int lottoCount = 0; lottoCount < lottoCounts; lottoCount++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private LottoResult getPrizeResult(LottoGroup lottos, DrawNumbers drawNumbers) {
        Map<Rank, Integer> prizeResult = lottos.getEachLottoPrize(drawNumbers.getWinningNumbers(),drawNumbers.getBonusNumber());

        LottoResult lottoResult=new LottoResult(prizeResult);
        return lottoResult;
    }
}
