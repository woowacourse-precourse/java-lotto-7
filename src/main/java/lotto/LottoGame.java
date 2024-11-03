package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
    private final LottoStore lottoStore;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.lottoStore = new LottoStore();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<Lotto> purchasedLottos = purchaseLottos();
        WinningLotto winningLotto = createWinningLotto();
        Map<LottoRank, Integer> results = calculateResults(purchasedLottos, winningLotto);
        printResults(results, calculateProfitRate(results, purchasedLottos.size()));
    }

    private List<Lotto> purchaseLottos() {
        int amount = readPurchaseAmount();
        List<Lotto> lottos = lottoStore.buyLottos(amount);
        outputView.printPurchasedLottos(lottos);
        outputView.printLottos(lottos);
        return lottos;
    }

    private int readPurchaseAmount() {
        try {
            return inputView.inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            List<Integer> numbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();
            return new WinningLotto(new Lotto(numbers), bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLotto();
        }
    }

    private Map<LottoRank, Integer> calculateResults(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }

    private double calculateProfitRate(Map<LottoRank, Integer> results, int totalCount) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (totalPrize * 100.0) / (totalCount * 1000);
    }

    private void printResults(Map<LottoRank, Integer> results, double profitRate) {
        outputView.printResult(results, profitRate);

    }
}
