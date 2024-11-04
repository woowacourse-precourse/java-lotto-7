package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.service.Validator;
import lotto.util.Parser;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.Prompt;

import java.util.List;

public class Controller {

    private static final int LOTTO_PRICE = 1000;
    private final Input input;
    private final Output output;
    private final Validator validator;
    private final LottoService lottoService;

    public Controller() {
        this.input = new Input();
        this.output = new Output();
        this.validator = new Validator();
        this.lottoService = new LottoService();
    }

    public void run() {
        Parser parser = new Parser(input, output, validator);

        int purchaseAmount = parser.getPurchaseAmount();
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;
        output.printPurchaseCount(numberOfLotto);

        List<Lotto> purchasedLotto = lottoService.generateLottos(numberOfLotto);
        output.printPurchasedLottos(purchasedLotto);

        List<Integer> winningNumbers = parser.getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Statistics statistics = calculateStatistics(purchasedLotto, winningLotto);

        printStatistics(statistics, purchaseAmount);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                output.printPrompt(Prompt.ENTER_BONUS_NUMBER);
                String bonusNumberInput = input.getInput();
                int bonusNumber = Integer.parseInt(bonusNumberInput);
                validator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (NumberFormatException e) {
                output.printErrorMessage("보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    private Statistics calculateStatistics(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        return lottoService.calculateStatistics(purchasedLotto, winningLotto);
    }

    private void printStatistics(Statistics statistics, int purchaseAmount) {
        output.printStatistics(statistics, purchaseAmount);
    }
}
