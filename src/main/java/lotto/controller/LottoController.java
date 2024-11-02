package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
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
        Map<Prize, Integer> result = calculateResult(lottoTickets, winningNumbers);

        double rateOfReturn = calculateRateOfReturn(result, purchasePrice.value());
        outputView.displayWinningResult(result, rateOfReturn);
    }

    private PurchasePrice requestPurchasePrice() {
        outputView.displayPurchasePriceRequest();
        return new PurchasePrice(inputView.getInteger());
    }

    private void responsePurchaseQuantity(PurchasePrice purchasePrice) {
        outputView.displayPurchaseQuantity(purchasePrice.calculateQuantity());
    }

    private LottoTickets generateLottoTickets(PurchasePrice purchasePrice) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int quantity = purchasePrice.calculateQuantity();
        for (int count = 0; count < quantity; count++) {
            lottoTickets.add(Lotto.generateRandomly());
        }

        return new LottoTickets(lottoTickets);
    }

    private void responseLottoTickets(LottoTickets lottoTickets) {
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

    private List<Integer> parseNumbers(String input) {
        List<String> numbers = List.of(input.split(","));
        // TODO: List<String> validate 필요함
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private Map<Prize, Integer> calculateResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        return lottoTickets.aggregateWinningResult(winningNumbers);
    }

    private double calculateRateOfReturn(Map<Prize, Integer> result, int purchasePrice) {
        int totalPrizeMoney = result.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();

        return ((double) totalPrizeMoney / purchasePrice) * 100;
    }
}
