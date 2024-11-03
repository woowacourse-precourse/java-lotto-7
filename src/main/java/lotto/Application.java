package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoPrizes;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoBudgetInput = Console.readLine();
        int lottoBudget = Integer.parseInt(lottoBudgetInput);

        int lottoCount = lottoBudget / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = Stream.generate(() ->
                        {
                            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                            randomNumbers.sort(Comparator.naturalOrder());
                            return new Lotto(randomNumbers);
                        }
                )
                .limit(lottoCount)
                .toList();

        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);

        System.out.println("당첨 번호를 입력해 주세요.");
        String WinningNumbersInput = Console.readLine();
        String[] WinningNumberStrings = WinningNumbersInput.split(",");
        List<Integer> winningNumbers = Arrays.stream(WinningNumberStrings)
                .map(Integer::parseInt)
                .toList();

        System.out.println("보너스 번호를 입력해 주세요.");
        String BonusNumberInput = Console.readLine();
        int bonusNumber = Integer.parseInt(BonusNumberInput);

        LottoPrizes lottoPrizes = new LottoPrizes(lottos.stream().map(lotto -> {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean containsBonusNumber = lotto.containsNumber(bonusNumber);
            return LottoPrize.getLottoPrize(matchCount, containsBonusNumber);
        }).toList());

        String yield = lottoPrizes.calculateYield(lottoBudget);
        System.out.println("당첨 통계" + System.lineSeparator() + "---");

        List<String> matchStatistics = lottoPrizes.calculateMatchStatistics();
        matchStatistics.forEach(System.out::println);

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
