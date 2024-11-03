package lotto.controller;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount / 1000);
        OutputView.printLottoNumbers(getLottoNubmers(purchasedLottos));

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
    }

    private List<Lotto> purchaseLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.generateRandomLotto())
                .collect(Collectors.toList());
    }

    private List<List<Integer>> getLottoNubmers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
