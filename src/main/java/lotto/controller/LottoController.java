package lotto.controller;

import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        int amount = handlePurchaseAmount();
        List<LottoTicketsDto> tickets = handleLottoTickets(amount);
        WinningNumbers winningNumbersInput = handleWinningNumbers();
        BonusNumber bonusNumberInput = handleBonusNumber(winningNumbersInput);
        handleLottoResults(tickets, winningNumbersInput, bonusNumberInput);
    }

    private void handleLottoResults(List<LottoTicketsDto> tickets, WinningNumbers winningNumbersInput, BonusNumber bonusNumberInput) {
        List<Lotto> lottos = lottos(tickets);
        LottoTickets genericTickets = LottoTickets.from(lottos);
        LottoResultDto result = lottoService.calculateResult(genericTickets, winningNumbersInput, bonusNumberInput);
        OutputView.printLottoResults(result);
    }

    private List<Lotto> lottos(List<LottoTicketsDto> tickets) {
        return tickets.stream()
                .map(dto -> new Lotto(dto.getNumbers()))
                .collect(Collectors.toList());
    }

    private BonusNumber handleBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = InputView.promptPurchaseBonusNumber();
                return BonusNumber.from(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers handleWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = InputView.promptPurchaseWinningNumber();
                return WinningNumbers.from(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

    }

    private List<LottoTicketsDto> handleLottoTickets(int amount) {
        List<LottoTicketsDto> tickets = lottoService.purchaseLottoTickets(amount);
        OutputView.printLottoTickets(tickets);
        return tickets;
    }

    private int handlePurchaseAmount() {
        while (true) {
            try {
                String input = InputView.promptPurchaseAmount();
                LottoPurchase purchase = LottoPurchase.of(Converter.stringToInt(input));
                return purchase.getAmount();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}