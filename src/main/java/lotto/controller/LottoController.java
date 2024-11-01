package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int payment = postPayment();
        List<Lotto> lottos = issueLottos(payment);

        List<Integer> winningNumbers = postWinningNumbers();
        int bonus = postBonus();

        Map<Winning, Integer> winnings = getWinnings(lottos, winningNumbers, bonus);
        double yield = getYield(winnings, payment);

        printResult(winnings, yield);
    }

    public int postPayment() {
        while (true) {
            try {
                String input = inputView.readPayment();
                return lottoService.getPayment(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> issueLottos(int payment) {
        List<Lotto> lottos = lottoService.issueLottos(payment);
        outputView.printLotto(lottos);

        return lottos;
    }

    public List<Integer> postWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return lottoService.getWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int postBonus() {
        while (true) {
            try {
                String input = inputView.readBonus();
                return lottoService.getBonus(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
