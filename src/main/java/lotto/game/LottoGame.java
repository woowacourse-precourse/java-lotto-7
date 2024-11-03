package lotto.game;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoGame {

    private final LottoController lottoController;
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoGame(LottoController lottoController, LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoController = lottoController;
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
    }

    public void play() {
        int money = getMoney();
        List<Lotto> lottos = purchase(money);
        printLotto(lottos);

        List<Integer> winNumber = getWinNumber();
        printWinNumber(winNumber);

        int bonusNumber = getBonusNumber(winNumber);
        printBonusNumber(bonusNumber);

        LottoResult result = getResult(lottos, winNumber, bonusNumber);
        printResult(result, money);
    }

    private int getMoney() {
        return lottoInputView.getMoney();
    }

    private List<Lotto> purchase(int money) {
        return lottoController.purchase(money);
    }

    private void printLotto(List<Lotto> lottos) {
        lottoOutputView.printPurchaseLotto(lottos);
    }

    private List<Integer> getWinNumber() {
        return lottoInputView.getWinNumber();
    }

    private static void printWinNumber(List<Integer> winNumber) {
        System.out.println(winNumber);
    }

    private int getBonusNumber(List<Integer> winNumber) {
        return lottoInputView.getBonusNumber(winNumber);
    }

    private static void printBonusNumber(int bonusNumber) {
        System.out.println(bonusNumber);
    }

    private LottoResult getResult(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber) {
        return lottoController.match(lottos, winNumber, bonusNumber);
    }

    private void printResult(LottoResult match, int money) {
        lottoOutputView.printResult(match, money);
    }
}
