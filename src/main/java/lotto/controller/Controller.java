package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }


    public void run() {
        //로또 구입 금액을 입력
        int purchaseAmount = inputView.inputPurchaseAmount();
        int purchaseCount  = service.count(purchaseAmount);

        List<Lotto> lottos = service.createLotto(purchaseCount);
        outputView.printLotto(purchaseCount, lottos);

        //당첨 번호 입력
        String lottoNum = inputView.inputLottoNum();
        Lotto lotto = service.createWinningNumber(lottoNum);

        //보너스 번호 입력
        int bonusNum = service.bonusNum(inputView.inputBonusNum(), lotto);

        //당청 내역 출력
        Map<Prize, Integer> prizeIntegerMap = service.calculateWinningDetail(lottos, lotto, bonusNum);
        outputView.printWinningDetail(prizeIntegerMap);

        //수익률 출력
        double rate = service.calculateRate(prizeIntegerMap, purchaseAmount);
        outputView.printRate(rate);
    }
}
