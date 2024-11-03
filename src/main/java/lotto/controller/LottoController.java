package lotto.controller;

import lotto.Lotto;
import lotto.LottoFactory;
import lotto.Price;
import lotto.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private final LottoFactory lottoFactory;
    private final InputView inputView;
    private final OutputView outputView;
    private static WinningResult winningResult;
    public LottoController(LottoFactory lottoFactory, InputView inputView, OutputView outputView){
        this.lottoFactory = lottoFactory;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLotto(){
        int lottoPrice = inputView.purchaseLotto();
        int numberOfLotto = lottoFactory.numberOfLotto(lottoPrice);
        List<Lotto> lottos = lottoFactory.createRandomLottos(numberOfLotto);
        outputView.printLottoNumber(numberOfLotto);
        outputView.printLottos(lottos);
        String[] lottoInput = inputView.lottoInput();
        List<Integer> lottoNumber = inputView.lottoNumber(lottoInput);
        int bonusNumber = inputView.lottoBonus();
        winningResult = new WinningResult(new Lotto(lottoNumber), bonusNumber);
        Map<Price, Integer> result = setResult();
        Price rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottos.size(); i++) {
            rank = winningResult.match(lottos.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, numberOfLotto);
    }

    private void printResult(Map<Price, Integer> result) {
        for (int i = Price.values().length - 1; i >= 0; i--) {
            Price.values()[i].printMessage(result.get(Price.values()[i]));
        }
    }

    private void printEarningRate(Map<Price, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Price rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        OutputView.printRevenueRate(EarningRate);
    }

    private Map<Price, Integer> setResult() {
        Map<Price, Integer> result = new LinkedHashMap<>();

        for (Price rank : Price.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
