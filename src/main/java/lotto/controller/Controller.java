package lotto.controller;

import lotto.model.*;
import lotto.view.NumberInputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final LottoService lottoService = new LottoService();

    public void run() {
        Money money = lottoService.getMoney();

        Lottos lottos = purchaseLottos(money);
        OutputView.printLottoNumbers(lottos);

        System.out.println(getWinningNumbers());
    }

    private Lottos purchaseLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money.getLottoTicket(); i++) {
            Lotto lotto = LottoGenerator.createLotto();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private String getWinningNumbers() {
        return NumberInputView.getWinningNumbers();
    }
}
