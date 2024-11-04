package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int lottoPurchasePrice = InputView.getValidPurchasePrice();
        int lottoPurchaseQuantity = calculateLottoQuantity(lottoPurchasePrice);

        printPurchaseInfo(lottoPurchaseQuantity);

        List<Lotto> lottos = createLottos(lottoPurchaseQuantity);
        printLottos(lottos);

        List<Integer> lottoWinningNumbers = InputView.getValidWinningNumbers();
        int bonusNumber = InputView.getValidBonusNumber(lottoWinningNumbers);

        WinningLotto winningLotto = new WinningLotto(lottoWinningNumbers, bonusNumber);
        LottoResult result = matchLottos(lottos, winningLotto);

        printResult(result, lottoPurchasePrice);
    }


    private static void printPurchaseInfo(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
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

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(Lotto::printNumbers);
    }

    private static LottoResult matchLottos(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        lottos.forEach(lotto -> result.addResult(winningLotto.match(lotto)));
        return result;
    }

    private static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s - %d개\n", rank.getDescription(), result.getCount(rank));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateProfitRate(purchaseAmount));
    }

    public static int calculateLottoQuantity(int purchasePrice) {
        return purchasePrice / 1000;
    }

}
