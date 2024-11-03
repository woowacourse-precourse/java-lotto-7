package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTicketTest {
    private DrawingLottoTicket winningLottoTicket;

    @BeforeEach
    void 테스트를_위한_객체_초기화() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    DrawingLotto winningLotto1 = new DrawingLotto();
                    DrawingLotto winningLotto2 = new DrawingLotto();
                    DrawingLotto winningLotto3 = new DrawingLotto();
                    this.winningLottoTicket = new DrawingLottoTicket(
                            List.of(winningLotto1, winningLotto2, winningLotto3));
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44));
    }

    @Test
    void 주어진_당첨_번호를_이용하여_당첨_번호와_일치하는_로또_번호의_수를_알_수_있다() {
        // given
        List<Integer> lottoNumbers = new ArrayList<>(List.of(3, 5, 11, 16, 41, 42));
        int bonusNumber = 43;

        // when
        List<Double> result = winningLottoTicket.determineWin(lottoNumbers, bonusNumber);

        // then
        assertThat(result).isEqualTo(List.of(2.0, 4.0, 2.0));
    }
}
