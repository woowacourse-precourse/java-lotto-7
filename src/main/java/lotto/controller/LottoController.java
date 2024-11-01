package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.Prize;
import lotto.model.Purchase;
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
        Purchase purchase = requestPurchase();
        List<Lotto> lottoTickets = generateLottoTickets(purchase.getQuantity());
        WinningNumbers winningNumbers = requestWinningNumbers();
        Map<Prize, Integer> result = calculateResult(lottoTickets, winningNumbers);
        double rateOfReturn = calculateRateOfReturn(result, purchase.getPrice());
        outputView.printWinningResult(result, rateOfReturn);
    }

    private Purchase requestPurchase() {
        outputView.printPurchasePriceRequest();
        int purchasePrice = inputView.getInteger();
        Purchase purchase = new Purchase(purchasePrice);

        int purchaseQuantity = purchase.getQuantity();
        outputView.printPurchaseQuantity(purchaseQuantity);

        return purchase;
    }

    private List<Lotto> generateLottoTickets(int quantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int count = 0; count < quantity; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(numbers));
        }
        outputView.printLottoNumbers(lottoTickets);

        return lottoTickets;
    }

    private WinningNumbers requestWinningNumbers() {
        outputView.printWinningNumbersRequest();
        List<Integer> winningNumbers = parseNumbers(inputView.getString());
        Lotto numbers = new Lotto(winningNumbers);

        outputView.printBonusNumberRequest();
        int bonusNumber = inputView.getInteger();

        return new WinningNumbers(numbers, bonusNumber);
    }

    private List<Integer> parseNumbers(String input) {
        List<String> numbers = List.of(input.split(","));
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private Map<Prize, Integer> calculateResult(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
        Map<Prize, Integer> result = new HashMap<>(Map.of(
                Prize.FIRST, 0,
                Prize.SECOND, 0,
                Prize.THIRD, 0,
                Prize.FOURTH, 0,
                Prize.FIFTH, 0
        ));
        for (Lotto lotto : lottoTickets) {
            Prize prize = winningNumbers.checkPrize(lotto);
            if (prize != Prize.NON) {
                result.replace(prize, result.get(prize) + 1);
            }
        }

        return result;
    }

    private double calculateRateOfReturn(Map<Prize, Integer> result, int purchasePrice) {
        int totalPrizeMoney = result.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();

        return ((double) totalPrizeMoney / purchasePrice) * 100;
    }
}
