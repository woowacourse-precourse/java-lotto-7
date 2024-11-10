package lotto;

import lotto.service.LottoMatch;
import lotto.service.Lottos;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        inputView.buyMoney();

        Lottos lottos = new Lottos(inputView.money, inputView.count);
        lottos.lottoDraw();

        OutputView outputView = new OutputView(lottos.count, lottos.lotto);

        outputView.buyCountPrint();
        outputView.lottosPrint();

        List<Integer> winLotto = inputView.winNumber();
        int bonusNumber = inputView.bonus();

        LottoMatch lottoMatch = new LottoMatch(inputView.count, lottos.lotto, winLotto, bonusNumber);
        lottoMatch.match();

        double profitRate = (double) lottoMatch.getTotalPrize() / (inputView.count * 1000) * 100;
        outputView.matchPrint(lottoMatch.getWinCounts(), profitRate);
    }
}
