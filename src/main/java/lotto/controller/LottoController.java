package lotto.controller;

import java.util.List;
import lotto.model.domain.Player;
import lotto.model.service.LottoService;
import lotto.model.service.WinningNumbersService;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView;
    InputView inputView;
    LottoService lottoService;
    WinningNumbersService winningNumbersService;
    private Player player;
    private int purchaseAmount;
    private List<Integer> winningNumbers;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService,
                           WinningNumbersService winningNumbersService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.winningNumbersService = winningNumbersService;
    }

    public void run() {
        setupLotto();
        generateLottos();
        generateBonusNumber();
        displayResults();
    }

    private void setupLotto() {
        outputView.purchaseLottoAmountMesssage();
        purchaseAmount = getValidatedPurchaseAmount();
        player = new Player(purchaseAmount);
        lottoService.generateLottoTickets(player);
        outputView.purchaseLottoCountMessage(lottoService.calculateTicketCount(purchaseAmount));
    }

    private int getValidatedPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.getPurchaseAmount();
                Validator.validateInteger(input);
                int amount = Integer.parseInt(input);
                Validator.validateMoneyUnit(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void generateLottos() {
        outputView.printLottoNumbers(player.getLottoNumbers());
        winningNumbers = getValidatedWinningNumbers();
        player.setWinningNumbers(winningNumbersService.getWinningNumbers());
    }

    private List<Integer> getValidatedWinningNumbers() {
        outputView.enterWinningNumbers();
        while (true) {
            try {
                winningNumbersService.inputWinningNumbers();
                List<Integer> numbers = winningNumbersService.getWinningNumbers().getNumbers();
                Validator.validateNumberList(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void generateBonusNumber() {
        outputView.enterBonusNumber();
        while (true) {
            try {
                int bonusNumber = winningNumbersService.inputBonusNumber();
                Validator.validateRange(bonusNumber);
                Validator.validateDuplicateNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void displayResults() {
        outputView.WinningStatistics();
        outputView.matchWinningCount(player.calculateWinningRanks());
        outputView.promptTotalReturnRate(player.getRateOfReturn(player.getWinningMoney()));
    }
}

