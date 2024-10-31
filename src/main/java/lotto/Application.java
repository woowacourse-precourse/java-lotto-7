package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String lottoPurchaseMoney = inputView.inputLottoPurchaseMoney();

        int lottoCount = Integer.parseInt(lottoPurchaseMoney) / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        outputView.printPurchaseCount(lottoCount);
        outputView.printPurchaseLottos(lottos);

        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = Stream.of(winningNumber.split(","))
                .map(Integer::valueOf)
                .toList();

        outputView.printEmptyLine();

        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        Map<Ranking, Integer> lottoResults = lottos.stream()
                .map(lotto -> lotto.compareWith(winningNumbers, bonusNumber))
                .map(Ranking::findByMatch)
                .flatMap(Optional::stream)
                .collect(Collectors.groupingBy(ranking -> ranking, Collectors.summingInt(r -> 1)));

        long totalPrize = lottoResults.keySet().stream()
                .mapToLong(key -> (long) key.getPrize() * lottoResults.get(key))
                .sum();
        double revenue = (double) totalPrize / Integer.parseInt(lottoPurchaseMoney) * 100;
        outputView.printLottoResults(lottoResults, revenue);
    }
}
