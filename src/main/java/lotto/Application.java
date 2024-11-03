package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPurchasePrice = Integer.parseInt(validate(Console.readLine()));
        int lottoPurchaseQuantity = calculateLottoQuantity(lottoPurchasePrice);
        print(lottoPurchaseQuantity);
        List<Lotto> lottos = createLottos(lottoPurchaseQuantity);
        print(lottos);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> lottoWinningNumbers = createWinningLottoNumber(Console.readLine());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        WinningLotto winningLotto = new WinningLotto(lottoWinningNumbers, bonusNumber);
        LottoResult result = matchLottos(lottos, winningLotto);
        printResult(result, lottoPurchasePrice);

    }

    private static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            isRankNone(result, rank);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateProfitRate(purchaseAmount));
    }

    private static void isRankNone(LottoResult result, Rank rank) {
        if (rank != Rank.NONE) {
            System.out.printf("%s - %d개\n", rank.getDescription(), result.getCount(rank));
        }
    }

    private static LottoResult matchLottos(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            result.addResult(rank);
        }
        return result;
    }

    private static List<Integer> createWinningLottoNumber(String inputString) {
        return Arrays.stream(inputString.split(",")).map(Integer::parseInt).toList();
    }

    private static void print(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }

    private static List<Lotto> createLottos(int lottoPurchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseQuantity; i++) {
            List<Integer> lottoNumbers = createLottoNumbers();
            Lotto lotto = createLotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void print(int lottoPurchaseQuantity) {
        System.out.println(lottoPurchaseQuantity + "개를 구매했습니다.");
    }

    public static int calculateLottoQuantity(int lottoPurchasePrice) {
        return lottoPurchasePrice / 1000;
    }

    public static String validate(String enterPrice) {
        return enterPrice;
    }
}
