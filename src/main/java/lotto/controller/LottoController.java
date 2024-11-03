package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void start(){
            //구입금액
            PaymentInput paymentInput=InputView.enterPaymentInput();
            //구입한 개수만큼 로또 만들기
            List<Lotto> lottos=createLottos(paymentInput.getLottoCounts());
            //

            OutputView.printLottosInfo(lottos);
            //showLottoInfo(lottos);
            DrawNumbers drawNumbers =InputView.enterWinningNumbers();

            Map<Rank,Integer> prizeResult=getPrizeResult(lottos, drawNumbers);
            TotalGain totalGain =new TotalGain(prizeResult,paymentInput);

            OutputView.showResult(totalGain);


    }


    private List<Lotto> createLottos(int lottoCounts) {
        List<Lotto> lottos=new ArrayList<>();

        for (int lottoCount=0;lottoCount< lottoCounts;lottoCount++){
            Lotto lotto=new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }


    private Map<Rank,Integer> getPrizeResult(List<Lotto> lottos, DrawNumbers drawNumbers) {
        PrizeMachine prizeMachine=new PrizeMachine(lottos);
        Map<Rank,Integer> prizeResult=prizeMachine.getAmountOfPrize(drawNumbers);

        return prizeResult;

    }

}
