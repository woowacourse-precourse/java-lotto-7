package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
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
}
