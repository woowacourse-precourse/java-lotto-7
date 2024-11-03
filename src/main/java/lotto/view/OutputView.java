package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    // TODO: 출력 메시지 정리 & 에러 메시지 정리
    public void printLottoDetails(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.represent());
        }
    }

    public void printWinningResults() {
        System.out.println("3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - 0개\n"
            + "5개 일치 (1,500,000원) - 0개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
            + "6개 일치 (2,000,000,000원) - 0개");
    }
}
