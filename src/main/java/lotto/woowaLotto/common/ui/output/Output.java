package lotto.woowaLotto.common.ui.output;

import java.util.Map;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.LottoResult;

public class Output {

    public void printResult(LottoResult result) {

        Map<Integer,Integer> rank = result.getRank();
        float roi = result.getRoi();

        System.out.println("당첨 통계\n---");
        System.out.printf("%d개 일치 (5,000원) - %d개%n", 3,rank.get(5));
        System.out.printf("%d개 일치 (50,000원) - %d개%n", 4,rank.get(4));
        System.out.printf("%d개 일치 (1,500,000원) - %d개%n", 5,rank.get(3));
        System.out.printf("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", 5,rank.get(2));
        System.out.printf("%d개 일치 (2,000,000,000원) - %d개%n", 6,rank.get(1));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }

}
