package lotto.view;

import java.util.List;
import lotto.app.dto.LottoResultDto;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String NUMBER_PREFIX = "[";
    private static final String NUMBER_SUFFIX = "]";

    public void printLotties(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.size());
        for (Lotto lotto : lottoList) {
            String numbers = String.join(DELIMITER, lotto.get().stream().map(String::valueOf).toList());
            System.out.println(NUMBER_PREFIX + numbers + NUMBER_SUFFIX);
        }
        System.out.println();
    }

    public void printResult(List<LottoResultDto> dtos) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoResultDto dto : dtos) {
            if (dto.lottoPrize() != LottoPrize.SECOND_PRIZE) {
                System.out.printf("%d개 일치 (%,d원) - %d개%n",
                    dto.lottoPrize().getWinningCount(),
                    dto.lottoPrize().getPrize(),
                    dto.amount());
            } else {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                    dto.lottoPrize().getWinningCount(),
                    dto.lottoPrize().getPrize(),
                    dto.amount());
            }
        }
    }

    public void printInvestment(double investment) {
        System.out.printf("총 수익률은 %.1f%%입니다.", Math.round(investment * 100) / 100.0);
    }
}
