package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int lottoPurchasePrice = InputView.getValidPurchasePrice();
        int lottoPurchaseQuantity = calculateLottoQuantity(lottoPurchasePrice);

        OutputView.printPurchaseInfo(lottoPurchaseQuantity);

        List<Lotto> lottos = createLottos(lottoPurchaseQuantity);
        OutputView.printLottos(lottos);

        List<Integer> lottoWinningNumbers = InputView.getValidWinningNumbers();
        int bonusNumber = InputView.getValidBonusNumber(lottoWinningNumbers);

        WinningLotto winningLotto = new WinningLotto(lottoWinningNumbers, bonusNumber);
        LottoResult result = matchLottos(lottos, winningLotto);

        OutputView.printResults(result, lottoPurchasePrice);
    }


    private static List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
    }


    private static LottoResult matchLottos(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        lottos.forEach(lotto -> result.addResult(winningLotto.match(lotto)));
        return result;
    }

    public static int calculateLottoQuantity(int purchasePrice) {
        return purchasePrice / 1000;
    }

}
