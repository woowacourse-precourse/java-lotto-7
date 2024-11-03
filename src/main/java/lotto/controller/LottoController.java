package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoNumbers;
import lotto.model.Lotto;
import lotto.constant.Prize;
import lotto.model.LottoTickets;
import lotto.model.PurchasePrice;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(final LottoService lottoService, final InputView inputView, final OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchasePrice purchasePrice = requestPurchasePrice();
        respondPurchaseQuantity(purchasePrice);

        LottoTickets lottoTickets = lottoService.generateLottoTickets(purchasePrice);
        respondLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = requestWinningNumbers();
        respondWinningResult(lottoTickets, winningNumbers, purchasePrice);
    }

    private PurchasePrice requestPurchasePrice() {
        outputView.displayPurchasePriceRequest();
        return new PurchasePrice(inputView.getInteger());
    }

    private void respondPurchaseQuantity(final PurchasePrice purchasePrice) {
        outputView.displayPurchaseQuantity(purchasePrice.calculateQuantity());
    }

    private void respondLottoTickets(final LottoTickets lottoTickets) {
        List<LottoNumbers> lottoNumbers = lottoTickets.tickets().stream()
                .map(LottoNumbers::of)
                .toList();
        outputView.displayLottoNumbers(lottoNumbers);
    }

    private WinningNumbers requestWinningNumbers() {
        outputView.displayWinningNumbersRequest();
        List<Integer> winningNumbers = parseNumbers(inputView.getString());
        Lotto numbers = new Lotto(winningNumbers);

        outputView.displayBonusNumberRequest();
        int bonusNumber = inputView.getInteger();

        return new WinningNumbers(numbers, bonusNumber);
    }

    private List<Integer> parseNumbers(final String input) {
        List<String> numbers = List.of(input.split(","));
        // TODO: List<String> validate 필요함
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void respondWinningResult(
            final LottoTickets lottoTickets,
            final WinningNumbers winningNumbers,
            final PurchasePrice purchasePrice
    ) {
        Map<Prize, Integer> result = lottoTickets.aggregateWinningResult(winningNumbers);
        double rateOfReturn = calculateRateOfReturn(result, purchasePrice);
        outputView.displayWinningResult(result, rateOfReturn);
    }

    private double calculateRateOfReturn(final Map<Prize, Integer> result, final PurchasePrice purchasePrice) {
        int totalPrizeMoney = calculateTotalPrizeMoney(result);
        return ((double) totalPrizeMoney / purchasePrice.value()) * 100;
    }

    private int calculateTotalPrizeMoney(final Map<Prize, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
    }
}
