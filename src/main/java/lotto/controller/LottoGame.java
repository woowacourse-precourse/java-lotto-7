package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    private List<Lotto> purchasedLottos;

    public LottoGame() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.purchasedLottos = new ArrayList<>();
    }

    public void run() {
        int money = purchaseMoney();
        generateLottos(money);
    }

    private int purchaseMoney() {
        while (true) {
            try {
                int money = inputView.readPurchaseMoney();
                lottoService.validatePurchaseMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void generateLottos(int money) {
        int count = lottoService.calculateLottoCount(money);
        outputView.printPurchaseCount(count);

        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoService.generateLotto();
            purchasedLottos.add(lotto);
            outputView.printLotto(lotto);
        }
    }
}