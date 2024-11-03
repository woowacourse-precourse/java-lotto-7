package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRound;
import lotto.model.Order;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    static final int LOTTO_ROUND = 1;

    public static void run() {

        LottoRound lottoRound = new LottoRound(LOTTO_ROUND);

        int order = InputView.parseOrder(InputView.inputOrderPrice());
        OutputView.printOrderNumber(order);

        Order userOrder = new Order(lottoRound, order);
        System.out.println(userOrder.toString());


        // 당첨 번호 로또, 보너스번호 생성
        Lotto winningLotto = new Lotto(InputView.parseWinningNumber(InputView.inputWinningNumber()));
        lottoRound.setWinningLotto(winningLotto);
        int bonusNumber = InputView.parseBonusNumber(InputView.inputBounsNumber());
        lottoRound.setBonusNumber(bonusNumber);

        // 일치 개수 계산
        userOrder.countmatch();
        
        // 출력
        OutputView.printWinningAmount(userOrder.getMatchCount());
        OutputView.printTotalProfit(userOrder.getMatchCount(),order*1000);
        
    }


}
