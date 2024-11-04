package lotto.controller;

import lotto.util.LottoMachine;
import lotto.util.Rank;
import lotto.util.ResultCalculator;
import lotto.view.UserInput;
import lotto.model.Lotto;
import lotto.view.UserView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private UserView userView;
    private UserInput userInput;
    private LottoMachine lottoMachine;
    private ResultCalculator resultCalculator;

    public LottoController(UserView userView, UserInput userInput, LottoMachine lottoMachine, ResultCalculator resultCalculator) {
        this.userView = userView;
        this.userInput = userInput;
        this.lottoMachine = lottoMachine;
        this.resultCalculator = resultCalculator;
    }

    public void run() {
        int amount = getAmount();
        List<Lotto> lottos = getLottos(amount);
        Lotto winningLotto = getWinningLotto();
        int bonus = getBonus();
        userInput.compareWinningNumbersWithBonus(bonus, winningLotto.getNumbers());
        Map<Rank, Integer> results = getResults(lottos, winningLotto, bonus);
        getStatistics(results, amount);
    }

    private int getAmount() {
        userView.displayInputMessageOfLottoAmount();

        return userInput.inputAmount();
    }

    private List<Lotto> getLottos(int amount) {
        List<Lotto> lottos = lottoMachine.creatLotto(amount);

        userView.displayCountOfLottos(lottos.size());
        userView.displayLottos(lottos);

        return lottos;
    }

    private Lotto getWinningLotto() {
        userView.displayInputMessageOfWinningNumbers();

        List<Integer> winningNumbers = userInput.inputWinningNumbers();

        Lotto winningLotto = lottoMachine.createWinningLotto(winningNumbers);

        return winningLotto;
    }

    private int getBonus() {
        userView.displayInputMessageOfBonusNumber();
        return userInput.inputBonusNumber();
    }

    private Map<Rank, Integer> getResults(List<Lotto> lottos, Lotto winningLotto, int bonus) {

        return resultCalculator.calculateResult(lottos, winningLotto, bonus);
    }

    private void getStatistics(Map<Rank, Integer> results, int amount) {
        userView.displayStatisticsMessage();
        userView.displayStatistics(results);
        int totalPrize = resultCalculator.getTotalPrize(results);
        double profit = resultCalculator.calculateProfit(totalPrize, amount);
        userView.displayProfit(profit);
    }

}
