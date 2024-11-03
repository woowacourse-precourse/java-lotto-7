package lotto.view;

import java.util.List;
import lotto.app.dto.LottoResultDto;
import lotto.domain.Lotto;

public class OutputView {

    public void printLotties(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.size());
        for (Lotto lotto : lottoList) {
            String numbers = String.join(",", lotto.get().stream().map(String::valueOf).toList());
            System.out.println("[" + numbers + "]");
        }
        System.out.println();
    }

    public void printResult(List<LottoResultDto> dtos) {
        System.out.println();
        System.out.println("당첨 통계");
        for (LottoResultDto dto : dtos) {
            System.out.printf("%d개 일치 (%d원) - %d개%n",
                dto.correctNumber(),
                dto.prize(),
                dto.amount());
        }
    }

    public void printInvestment(double investment) {
        System.out.printf("총 수익률은 %.1f%%입니다%n", Math.round(investment * 100) / 100.0);
    }
}
