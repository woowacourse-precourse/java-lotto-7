package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

import static lotto.model.LottoService.BONUS_KEY;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public void printResult(Map<Integer, Integer> result, Long rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");

        result.forEach((key, value) -> System.out.printf("%d개 일치 (%,d원) - %d개%n", key, getPrizeAmount(key), value));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);

    }

    private long getPrizeAmount(int matchCount) {
        return switch (matchCount) {
            case 3 -> 5000;
            case 4 -> 50000;
            case 5 -> 1500000;
            case BONUS_KEY -> 30000000; // 5개 + 보너스
            case 6 -> 2000000000;
            default -> 0;
        };
    }

}
