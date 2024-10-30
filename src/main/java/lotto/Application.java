package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPrice = Integer.parseInt(Console.readLine());
        System.out.println();

        int lottoCount = lottoPrice / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        Map<Lotto, Winning> lottos = new LinkedHashMap<>();
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.put(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)), new Winning()));

        lottos.keySet().forEach(Lotto::ascNumbers);

        lottos.keySet().forEach(System.out::println);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        List<Integer> splitWinningNumbers = Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).toList();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        lottos.keySet().forEach(lotto -> {
            lottos.get(lotto)
                    .updateWinning(lotto.confirmWinning(splitWinningNumbers), lotto.confirmBonus(bonusNumber));
        });
    }
}
