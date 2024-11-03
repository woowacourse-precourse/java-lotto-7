package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.WinningPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningPrizeTest {
    private WinningPrize winningPrize;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningPrize = new WinningPrize(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("6개 번호 일치하면 1등 당첨")
    void 여섯개번호_일치하면_1등_당첨() {
        //given
        Lotto userLottoTicket = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        LottoPrize prize = winningPrize.getPrize(userLottoTicket);

        //then
        assertThat(prize).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    @DisplayName("3개 번호 일치 + 보너스 번호 일치하더라도 5등으로 처리")
    void 세개번호_일치하면_5등_당첨() {
        //given
        Lotto userLottoTicket = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        //when
        LottoPrize prize = winningPrize.getPrize(userLottoTicket);

        //then
        assertThat(prize).isEqualTo(LottoPrize.FIFTH);
    }

    @Test
    @DisplayName("5개 번호 + 보너스 번호 일치하면 2등 당첨")
    void 다섯개번호_보너스번호_다_일치하면_2등_당첨() {
        //given
        Lotto userLottoTicket = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        //when
        LottoPrize prize = winningPrize.getPrize(userLottoTicket);

        //then
        assertThat(prize).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    @DisplayName("2개 번호 이하 일치하면 당첨이 안된다")
    void 두개번호_이하_일치하면_당첨이_안된다() {
        //given
        Lotto userLottoTicket = new Lotto(Arrays.asList(1, 20, 24, 30, 40, 45));

        //when
        LottoPrize prize = winningPrize.getPrize(userLottoTicket);

        //then
        assertThat(prize).isNull();
    }
}
