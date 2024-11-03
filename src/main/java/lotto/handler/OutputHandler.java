package lotto.handler;

import lotto.dto.Lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputHandler {

    // 로또 번호 출력
    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    // 당첨 통계 출력
    public void printStatistics(Map<String, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", statistics.get("3개 일치 (5,000원)"));
        System.out.printf("4개 일치 (50,000원) - %d개%n", statistics.get("4개 일치 (50,000원)"));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", statistics.get("5개 일치 (1,500,000원)"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", statistics.get("5개 일치, 보너스 볼 일치 (30,000,000원)"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", statistics.get("6개 일치 (2,000,000,000원)"));
    }

    // 수익률 출력
    public void printProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // 소수점 두 자리까지 포맷
        String formattedRate = decimalFormat.format(profitRate);
        System.out.printf("총 수익률은 %s%%입니다.%n", formattedRate);
    }
}
