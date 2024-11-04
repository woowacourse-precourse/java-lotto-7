package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


class OutputViewTest {

    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @Test
    void 로또티켓_출력_정상작동() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38))
        );
        outputView.printLottoTickets(lottos);
    }

    @Test
    void 통계_출력_정상작동() {
        String statistics = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개";
        outputView.printStatistics(statistics);
    }

    @Test
    void 수익률_출력_정상작동() {
        outputView.printYield(62.5);
    }
}
