package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void purchaseLottoAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.%n", amount);
    }

    public void purchaseLottoNumbers(Lottos lottos) {
        List<Lotto> purchaseLottos = lottos.getLottos();
        purchaseLottos.forEach(l -> System.out.println(l.toString()));
    }

    public void winningDetails(Map<Prize, Integer> matchResult) {
        matchResult.entrySet().stream()
                .filter(entry -> entry.getKey() != Prize.NOTHING)
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    Prize prize = entry.getKey();
                    int count = entry.getValue();

                    String matchDescription = prize.getMatchCount() + "개 일치";

                    if (prize == Prize.SECOND) {
                        matchDescription = "5개 일치, 보너스 볼 일치";
                    }

                    System.out.printf("%s (%,d원) - %d개%n",
                            matchDescription,
                            entry.getKey().getPrizeMoney(),
                            count);
                });
    }

    public void earnRate(double earnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earnRate);
    }
}
