package lotto.view;

import java.util.List;
import lotto.dto.LottoResultResponseDto;
import lotto.model.Lotto;

public class OutputView {

    public void printLotties(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.size());
        for (Lotto lotto : lottoList) {
            String numbers = String.join(",", lotto.get().stream().map(String::valueOf).toList());
            System.out.println("[" + numbers + "]");
        }
    }

    public void printResult(List<LottoResultResponseDto> dtos) {
        System.out.println("당첨 통계");
        for (LottoResultResponseDto dto : dtos) {
            System.out.printf("%d개 일치 (%d원) - %d개%n",
                dto.correctNumber(),
                dto.prize(),
                dto.amount());
        }
    }
}
