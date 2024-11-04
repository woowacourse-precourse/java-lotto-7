package lotto.controller;

import static lotto.utils.ErrorMessage.INVALID_LOTTO;
import static lotto.utils.ErrorMessage.BONUS_NUMBER_DUPLICATION;
import static lotto.utils.ErrorMessage.INVALID_RANGE;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.WinnerLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoMachine lottoMachine = inputPrice();
        outputView.lottoTIckets(lottoMachine);

        WinnerLotto winnerLotto = inputWinner();

        long prize = lottoService.calculatePrize(lottoMachine.getLottoTickets(), winnerLotto);
        double totalReturn = lottoService.totalReturn(lottoMachine, prize);
        outputView.winningStatistics(totalReturn);

    }

    private LottoMachine inputPrice() {
        while (true) {
            try {
                int amount = inputView.inputPrice();
                return lottoService.createLottoMachine(amount);
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private WinnerLotto inputWinner() {
        Lotto winnerNumbers = inputWinnerNumbers();
        int bonus = inputBonus(winnerNumbers);
        return lottoService.createWinnerLotto(winnerNumbers, bonus);
    }

    private Lotto inputWinnerNumbers() {
        while (true) {
            try {
                return new Lotto(parseNumbers());
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private List<Integer> parseNumbers() {
        List<Integer> winnerNumbers = new ArrayList<>();

        while (true) {
            try {
                List<String> inputNumbers = inputView.inputNumbers();
                for (String number : inputNumbers) {
                    winnerNumbers.add(Integer.parseInt(number));
                }
                return winnerNumbers;
            } catch (NumberFormatException e) {
                InputView.errorPrint(INVALID_LOTTO);
            }
        }
    }

    private int inputBonus(Lotto winnerLotto) {
        while (true) {
            try {
                int bonus = inputView.inputBonus();
                return validateBonus(winnerLotto, bonus);
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private int validateBonus(Lotto winnerLotto, int bonus) {
        checkContains(winnerLotto, bonus);
        checkSame(bonus);
        return bonus;
    }

    private static void checkContains(Lotto winnerLotto, int bonus) {
        if (winnerLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION);
        }
    }

    private static void checkSame(int bonus) {
        if (!(1 <= bonus && bonus <= 45)) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }
}
