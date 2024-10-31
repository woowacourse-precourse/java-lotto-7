package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.parser.Parser;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    private final Parser parser;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();

        this.parser = new Parser();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int getPayment() {
        int payment;
        try {
            String inputPayment = inputView.readPayment();
            payment = parser.parsePayment(inputPayment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            payment = getPayment();
        }

        return payment;
    }

    public List<Lotto> initLotto(int payment) {
        List<Lotto> lottos = lottoService.initLotto(payment);
        outputView.printLotto(lottos);

        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        try {
            String inputWinningNumbers = inputView.readWinningNumbers();
            winningNumbers = parser.parseWinningNumbers(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumbers = getWinningNumbers();
        }

        return winningNumbers;
    }

    public int getBonus() {
        int bonus;

        try {
            String inputBonus = inputView.readBonus();
            bonus = parser.parseBonus(inputBonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonus = getBonus();
        }

        return bonus;
    }

    public Map<Winning, Integer> getWinnings(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        return lottoService.getWinnings(lottos, winningNumbers, bonus);
    }

    public double getYield(Map<Winning, Integer> winnings, int payment) {
        return lottoService.getYield(payment, winnings);
    }

    public void printResult(Map<Winning, Integer> winnings, double yield) {
        outputView.printResult(winnings, yield);
    }
}
