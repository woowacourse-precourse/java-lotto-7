package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.BonusNumberException;
import lotto.Exception.MoneyException;
import lotto.Exception.WinningNumberException;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.LottoRules.Winning;
import lotto.validator.BonusNumberValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final MoneyValidator moneyValidator;
    private final WinningNumberValidator winningNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;


    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoService lottoService,
            MoneyValidator moneyValidator,
            WinningNumberValidator winningNumberValidator,
            BonusNumberValidator bonusNumberValidator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.moneyValidator = moneyValidator;
        this.winningNumberValidator = winningNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public void startLottoGame() {
        try {
            int purchasePrice = readInputPurchasePrice();
            List<Lotto> myLottoTickets = lottoService.purchaseLottoTickets(purchasePrice);
            displayPurchasedLottoInfo(myLottoTickets);

            Set<Integer> winningNumbers = readInputWinningNumbers();
            int bonusNumber = readInputBonusNumber();
            lottoService.checkBonusNumberDuplication(winningNumbers, bonusNumber);

            Map<Winning, Integer> winningStatistics =
                    lottoService.calculateWinningStatistics(myLottoTickets, winningNumbers, bonusNumber);
            outputView.displayWinningStatistics(winningStatistics);

            double yieldRate = lottoService.calculateYieldRate(purchasePrice, winningStatistics);
            outputView.displayYieldRate(yieldRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int readInputPurchasePrice() throws MoneyException {
        inputView.requestPurchasePriceMessage();
        String inputPurchasePriceText = Console.readLine();
        moneyValidator.validate(inputPurchasePriceText);
        return Integer.parseInt(inputPurchasePriceText);
    }

    private Set<Integer> readInputWinningNumbers() throws WinningNumberException {
        inputView.requestWinningNumberMessage();
        String inputWinningNumberText = Console.readLine();
        winningNumberValidator.validate(inputWinningNumberText);
        return Stream.of(inputWinningNumberText.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    private Integer readInputBonusNumber() throws BonusNumberException {
        inputView.requestBonusNumberMessage();
        String inputBonusNumberText = Console.readLine();
        bonusNumberValidator.validate(inputBonusNumberText);
        return Integer.parseInt(inputBonusNumberText);
    }

    private void displayPurchasedLottoInfo(List<Lotto> myLottoTickets) {
        outputView.displayPurchasedLottoCount(myLottoTickets.size());

        List<List<Integer>> myLottoTicketsForNumbers = lottoService.convertLottoTicketsToNumbers(myLottoTickets);
        outputView.displayPurchasedLottoTickets(myLottoTicketsForNumbers);
    }
}
