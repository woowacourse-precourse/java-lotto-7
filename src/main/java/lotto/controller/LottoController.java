package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.utils.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    int money;
    int lottoAmount;

    public void run() {
        OutputView outputView = new OutputView();
//    로또 구입 금액 입력
//      1)안내출력
        OutputView.promptInputPurchaseMoney();
//      2)입력
        InputView inputView = new InputView();
        money = inputView.purchaseMoney();
        OutputView.printLn();

//    로또 구매
        lottoAmount = money / 1000;
//    로또 발행
        LottoGenerator lottoGenerator = new LottoGenerator();

        outputView.printBuyLottoAmount(lottoAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(lottoGenerator.lottoNumbers()));
        }

        for (Lotto lotto : lottos) {
            outputView.printBuyLottoNumber(lotto.getNumbers());
        }

//    당첨 번호 입력
//      1) 안내 출력
        OutputView.printLn();
        OutputView.promptInputWinningNumbers();
        Lotto winningLotto = new Lotto(inputView.winningNumbers());

//    보너스 번호 입력
//      1) 안내 출력
        OutputView.printLn();
        OutputView.promptInputBonusNumber();
        int bonus = inputView.bonusNumber();

//    로또 비교하기
        for (Lotto lotto : lottos)

//    당첨통계
        OutputView.printLn();
//        1) 안내 출력
        OutputView.printResultText();
//        2) 당첨 개수 출력
//        3) 수익률 출력
    }

}
