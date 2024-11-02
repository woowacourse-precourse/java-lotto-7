package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.constant.Prize;
import lotto.model.LottoTickets;
import lotto.model.PurchasePrice;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchasePrice purchasePrice = requestPurchasePrice();
        responsePurchaseQuantity(purchasePrice);

        LottoTickets lottoTickets = generateLottoTickets(purchasePrice);
        responseLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = requestWinningNumbers();
        responseWinningResult(lottoTickets, winningNumbers, purchasePrice);
    }

    private PurchasePrice requestPurchasePrice() {
        outputView.displayPurchasePriceRequest();
        return new PurchasePrice(inputView.getInteger());
    }

    private void responsePurchaseQuantity(final PurchasePrice purchasePrice) {
        outputView.displayPurchaseQuantity(purchasePrice.calculateQuantity());
    }

    private LottoTickets generateLottoTickets(final PurchasePrice purchasePrice) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int quantity = purchasePrice.calculateQuantity();
        for (int count = 0; count < quantity; count++) {
            lottoTickets.add(Lotto.generateRandomly());
        }

        return new LottoTickets(lottoTickets);
    }

    private void responseLottoTickets(final LottoTickets lottoTickets) {
        outputView.displayLottoNumbers(lottoTickets.tickets());
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

    private void responseWinningResult(
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
