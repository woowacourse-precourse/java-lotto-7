package lotto.handler;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoTicket;
import lotto.domain.DrawingLotto;
import lotto.domain.DrawingLottoTicket;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottohandlerTest {
    private DrawingLottoTicket winningLottoTicket;
    private LottoTicket lottoTicket;

    private LottoHandler lottoHandler = new LottoHandler();

    @BeforeEach
    void 테스트를_위한_객체_초기화() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    DrawingLotto winningLotto1 = new DrawingLotto();
                    DrawingLotto winningLotto2 = new DrawingLotto();
                    DrawingLotto winningLotto3 = new DrawingLotto();
                    this.winningLottoTicket = new DrawingLottoTicket(
                            List.of(winningLotto1, winningLotto2, winningLotto3));
                    this.lottoTicket = new LottoTicket(List.of(3, 5, 7, 8, 11, 16), 32);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44));
    }

    @Test
    void 입력된_당첨_번호와_로또_번호를_대조하여_일치하는_번호의_갯수를_알_수_있다() {
        // when
        List<Double> compareResult = lottoHandler.compareNumbers(winningLottoTicket, lottoTicket);

        // then
        assertThat(compareResult).isEqualTo(List.of(1.0, 4.0, 3.0));
    }

    @Test
    void 총_당첨_금액을_계산하여_수익률을_계산할_수_있다() {
        // given
        int purchaseMoney = 3000;
        double expectedRateOfReturn = 1833.3;

        // when
        List<Double> matchCount = lottoHandler.compareNumbers(winningLottoTicket, lottoTicket);

        // then
        assertThat(lottoHandler.calculateRateOfReturn(matchCount, purchaseMoney)).isEqualTo(expectedRateOfReturn);
    }
}
