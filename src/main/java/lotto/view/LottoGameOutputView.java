package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTickets;

public class LottoGameOutputView {

    private LottoGameOutputView() {
    }

    public static void printTicketCount(LottoTickets lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.getTicketCount() + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }
}
