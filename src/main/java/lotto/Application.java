package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.generator.SortedLottoNumberGenerator;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        int money = LottoInputView.getMoney();
        LottoController lottoController = new LottoController(new LottoService(new SortedLottoNumberGenerator()));
        List<Lotto> lottos = lottoController.purchase(money);

        LottoOutputView.printPurchaseLotto(lottos);

        List<Integer> winNumber = LottoInputView.getWinNumber();
        System.out.println(winNumber);

        int bonusNumber = LottoInputView.getBonusNumber(winNumber);
        System.out.println(bonusNumber);

        LottoResult match = lottoController.match(lottos, winNumber, bonusNumber);
        LottoOutputView.printResult(match, money);
    }
}
