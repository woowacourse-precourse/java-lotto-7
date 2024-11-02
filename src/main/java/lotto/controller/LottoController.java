package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

        LinkedHashMap<Prize, Integer> result = calculateResult(lottoTickets.getTickets(), winningNumbers);
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
            lottoTickets.add(generateLotto());
        }

        return new LottoTickets(lottoTickets);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto((numbers));
    }

    private void responseLottoTickets(LottoTickets lottoTickets) {
        outputView.displayLottoNumbers(lottoTickets.getTickets());
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

    private LinkedHashMap<Prize, Integer> calculateResult(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
        LinkedHashMap<Prize, Integer> result = new LinkedHashMap<>() {{
            put(Prize.FIFTH, 0);
            put(Prize.FOURTH, 0);
            put(Prize.THIRD, 0);
            put(Prize.SECOND, 0);
            put(Prize.FIRST, 0);
        }};
        for (Lotto lotto : lottoTickets) {
            Prize prize = winningNumbers.checkPrize(lotto);
            if (prize != Prize.NON) {
                result.replace(prize, result.get(prize) + 1);
            }
        }

        return result;
    }

    private double calculateRateOfReturn(LinkedHashMap<Prize, Integer> result, int purchasePrice) {
        int totalPrizeMoney = result.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();

        return ((double) totalPrizeMoney / purchasePrice) * 100;
    }
}
