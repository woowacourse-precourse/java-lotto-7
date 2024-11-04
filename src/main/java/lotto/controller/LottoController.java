package lotto.controller;

import java.util.List;
import lotto.InputType;
import lotto.MatchType;
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
        displayStatistics();
    }

    public void displayPurchase(int purchase) {
        outputView.printPurchase(purchase);
    }

    public void displayStatistics() {
        statistic.checkMatch(game.getWiningLotto(), game.getBonusNumber(), game.getLottos());
        outputView.printStatisticStart();
        for (MatchType type : MatchType.values()) {
            int total = statistic.getStatistics().get(type);
            outputView.printStatisticMatchType(type, total);
        }

        double ratio = calculateRatio();
        outputView.printTotalRatio(ratio);
    }

    private double calculateRatio() {
        int totalPrize = statistic.calculateScore();
        return (double) totalPrize / (game.getPurchase() * 1000) * 100;
    }
}
