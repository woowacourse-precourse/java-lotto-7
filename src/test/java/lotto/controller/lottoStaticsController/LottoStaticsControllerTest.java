package lotto.controller.lottoStaticsController;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.io.OutputHandler;
import lotto.io.OutputParser;
import lotto.testUtil.testDouble.WriterFake;
import org.junit.jupiter.api.Test;

class LottoStaticsControllerTest {

    @Test
    void 로또결과를_처리한다() {
        //given
        WriterFake writerFake = new WriterFake();
        OutputHandler outputHandler = new OutputHandler(writerFake, new OutputParser());
        LottoStaticsController sut = new LottoStaticsController(outputHandler);
        List<Lotto> purchasedLottos = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(3, 4, 5, 6, 7, 8)));
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(2, 3, 4, 5, 6, 7)), 1);
        Money money = Money.from(2000);

        //when
        sut.printLottoStatics(purchasedLottos, winningLotto, money);

        //then
        assertThat(writerFake.getOutputs().get(0)).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
        assertThat(writerFake.getOutputs().get(1)).contains(
                "총 수익률은 1,575,000.0%입니다."
        );
    }
}
