package lotto.controller;

import java.util.List;
import lotto.InputType;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoStatistic;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGame game;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStatistic statistic;

    public LottoController(LottoGame game) {
        this.game = game;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.statistic = new LottoStatistic();
        game.registController(this);
        purchase();
    }

    public void purchase() {
        String input = inputView.getInput(InputType.PURCHASE);
        try {
            game.validatePurchaseInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchase();
        }
        game.purchaseLottos(Integer.parseInt(input) / 1000);
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            outputView.printLottoNumbers(lotto.displayNumbers());
        }
        getWiningLottos();
    }

    public void getWiningLottos() {
        String input = inputView.getInput(InputType.WIN_LOTTO);
        try {
            game.createWiningLotto(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getWiningLottos();
        }
        getBonusNumber();
    }

    public void getBonusNumber() {
        String input = inputView.getInput(InputType.BONUS);
        try {
            game.creatBonusNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBonusNumber();
        }
    }

    public void displayPurchase(int purchase) {
        outputView.printPurchase(purchase);
    }
}
