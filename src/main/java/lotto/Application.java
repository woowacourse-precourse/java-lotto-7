package lotto;

import static lotto.Winning.FIVE;
import static lotto.Winning.FIVE_BONUS;
import static lotto.Winning.NONE;
import static lotto.Winning.values;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal lottoPrice = new BigDecimal(Integer.parseInt(Console.readLine()));
        System.out.println();

        int lottoCount = lottoPrice.divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP)
                .intValue();
        System.out.println(lottoCount + "개를 구매했습니다.");

        Map<Lotto, Winning> lottos = new LinkedHashMap<>();
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.put(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)), NONE));

        lottos.keySet().forEach(Lotto::ascNumbers);

        lottos.keySet().forEach(System.out::println);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        List<Integer> splitWinningNumbers = Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).toList();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        lottos.keySet().forEach(lotto -> {
            lottos.put(lotto, Winning.fromCount(lotto.confirmWinning(splitWinningNumbers)));
            if (lotto.confirmBonus(bonusNumber) && lottos.get(lotto) == FIVE) {
                lottos.put(lotto, FIVE_BONUS);
            }
            lottos.get(lotto).increaseCount();
        });

        System.out.println("당첨 통계\n---");
        Arrays.stream(values())
                .filter(winning -> winning != NONE)
                .forEach(winning -> System.out.println(winning.toStringMessageAndCount()));

        AtomicReference<BigDecimal> totalWinningPrice = new AtomicReference<>(BigDecimal.ZERO);
        Arrays.stream(values())
                .filter(winning -> winning != NONE)
                .forEach(winning -> {
                    totalWinningPrice.updateAndGet(p -> p.add(winning.multiplyCount()));
                });
        BigDecimal totalWinningRate = totalWinningPrice.get()
                .divide(lottoPrice, 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP)
                .stripTrailingZeros();
        System.out.println("총 수익률은 " + totalWinningRate.toPlainString() + "%입니다.");
    }
}
