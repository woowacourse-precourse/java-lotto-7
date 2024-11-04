package lotto.view;

import lotto.domain.Lotto;
import java.util.List;

public class OutputView implements Output {

    @Override
    public void printLottoTickets(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(formatLottoNumbers(lotto)));
    }

    @Override
    public void printStatistics(String statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(statistics);
    }

    // 로또 번호 형식 지정 메서드
    private String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().toString();
    }
}
