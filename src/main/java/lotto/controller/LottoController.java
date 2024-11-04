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
        List<Lotto> lottos = createLottos(paymentInput.getLottoCounts());

        OutputView.printLottosInfo(lottos);

        DrawNumbers drawNumbers = InputView.enterWinningNumbers();
        Map<Rank, Integer> prizeResult = getPrizeResult(lottos, drawNumbers);
        TotalGain totalGain = new TotalGain(prizeResult, paymentInput);

        OutputView.showResult(totalGain);
    }


    private List<Lotto> createLottos(long lottoCounts) {
        List<Lotto> lottos = new ArrayList<>();

        for (int lottoCount = 0; lottoCount < lottoCounts; lottoCount++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private Map<Rank, Integer> getPrizeResult(List<Lotto> lottos, DrawNumbers drawNumbers) {
        PrizeMachine prizeMachine = new PrizeMachine(lottos);
        Map<Rank, Integer> prizeResult = prizeMachine.getAmountOfPrize(drawNumbers);

        return prizeResult;
    }
}
