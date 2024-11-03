package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.service.Validator;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.Prompt;

import java.util.List;

public class Controller {

    private final int LOTTO_PRICE = 1000;
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
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        output.printPurchaseCount(numberOfLottos);

        List<Lotto> purchasedLottos = lottoService.generateLottos(numberOfLottos);
        output.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        WinningLotto winningLotto = createWinningLotto(winningNumbers, bonusNumber);
        Statistics statistics = calculateStatistics(purchasedLottos, winningLotto);

        printStatistics(statistics, purchaseAmount);
    }

    private int getPurchaseAmount() {
        int purchaseAmount;
        
        while (true) {
            try {
                output.printPrompt(Prompt.ENTER_PURCHASE_AMOUNT);
                purchaseAmount = Integer.parseInt(input.getInput());
                validator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                output.printErrorMessage("구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                output.printPrompt(Prompt.ENTER_WINNING_NUMBERS);
                String winningNumbersInput = input.getInput();
                List<Integer> winningNumbers = validator.validateAndParseWinningNumbers(winningNumbersInput);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
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

    private WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Statistics calculateStatistics(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        return lottoService.calculateStatistics(purchasedLottos, winningLotto);
    }

    private void printStatistics(Statistics statistics, int purchaseAmount) {
        output.printStatistics(statistics, purchaseAmount);
    }
}
