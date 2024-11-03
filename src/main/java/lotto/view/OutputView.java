package lotto.view;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    public static void printLottosResult(Map<String, Integer> lottoResult) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get("5등") + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get("4등") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get("3등") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get("2등") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get("1등") + "개");
    }

    public static void printLottosReturns(double returnsByLottos) {
        System.out.printf("총 수익률은 %.1f%%입니다.", returnsByLottos);
    }
    public static void printBoughtInfo(Lottos lottos) {
        System.out.println(lottos.getLotto().size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLotto())
            System.out.println("["+lotto.getNumbers().stream()
                    .sorted(Comparator.naturalOrder())
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "))+"]");
    }
}
