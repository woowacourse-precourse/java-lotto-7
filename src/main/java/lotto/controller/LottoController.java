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

    public void run() {
        int payment = getPayment();
        List<Lotto> lottos = issueLottos(payment);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonus = getBonus();

        Map<Winning, Integer> winnings = getWinnings(lottos, winningNumbers, bonus);
        double yield = getYield(winnings, payment);

        printResult(winnings, yield);
    }

    public int getPayment() {
        while (true) {
            try {
                String inputPayment = inputView.readPayment();
                return parser.parsePayment(inputPayment);
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

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.readWinningNumbers();
                return parser.parseWinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonus() {
        while (true) {
            try {
                String inputBonus = inputView.readBonus();
                return parser.parseBonus(inputBonus);
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
