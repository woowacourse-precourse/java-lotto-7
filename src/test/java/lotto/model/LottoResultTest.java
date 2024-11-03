package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import lotto.constant.LottoWinInfo;
import lotto.model.draw.Draw;
import lotto.model.draw.DrawNumbers;
import lotto.model.purchase.Lotto;
import lotto.model.result.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    Draw draw;
    Lotto FIRST_WIN_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto SECOND_WIN_LOTTO_1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    Lotto SECOND_WIN_LOTTO_2 = new Lotto(List.of(1, 2, 3, 4, 6, 7));
    Lotto THIRD_WIN_LOTTO_1 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
    Lotto THIRD_WIN_LOTTO_2 = new Lotto(List.of(1, 2, 3, 4, 6, 10));
    Lotto THIRD_WIN_LOTTO_3 = new Lotto(List.of(1, 2, 3, 5, 6, 10));
    Lotto FORTH_WIN_LOTTO_1 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
    Lotto FORTH_WIN_LOTTO_2 = new Lotto(List.of(1, 2, 3, 5, 10, 11));
    Lotto FORTH_WIN_LOTTO_3 = new Lotto(List.of(1, 2, 3, 6, 10, 11));
    Lotto FIFTH_WIN_LOTTO = new Lotto(List.of(1, 2, 3, 10, 11, 12));

    @BeforeEach
    void setUp() {
        DrawNumbers drawNumbers = new DrawNumbers("1,2,3,4,5,6");
        String bonusNumber = "7";
        draw = new Draw(drawNumbers, bonusNumber);
    }

    @Test
    void 로또당첨카운트테스트_각각한개씩() {
        // given
        List<Lotto> lottoTickets = List.of(FIRST_WIN_LOTTO, SECOND_WIN_LOTTO_1, THIRD_WIN_LOTTO_1, FORTH_WIN_LOTTO_1,
                FIFTH_WIN_LOTTO);

        // when
        LottoResult lottoResult = new LottoResult(draw, lottoTickets, 0);
        EnumMap<LottoWinInfo, Integer> lottoWinCount = lottoResult.getLottoWinCount();

        // then
        assertThat(lottoWinCount.get(LottoWinInfo.FIRST)).isEqualTo(1);
        assertThat(lottoWinCount.get(LottoWinInfo.SECOND)).isEqualTo(1);
        assertThat(lottoWinCount.get(LottoWinInfo.THIRD)).isEqualTo(1);
        assertThat(lottoWinCount.get(LottoWinInfo.FOURTH)).isEqualTo(1);
        assertThat(lottoWinCount.get(LottoWinInfo.FIFTH)).isEqualTo(1);
    }

    @Test
    void 로또당첨카운트테스트_다양한_당첨수() {
        // given
        List<Lotto> lottoTickets = List.of(SECOND_WIN_LOTTO_1, SECOND_WIN_LOTTO_2,
                THIRD_WIN_LOTTO_1, THIRD_WIN_LOTTO_2, THIRD_WIN_LOTTO_3,
                FORTH_WIN_LOTTO_1, FORTH_WIN_LOTTO_2, FORTH_WIN_LOTTO_3,
                FIFTH_WIN_LOTTO);

        // when
        LottoResult lottoResult = new LottoResult(draw, lottoTickets, 0);
        EnumMap<LottoWinInfo, Integer> lottoWinCount = lottoResult.getLottoWinCount();

        // then
        assertThat(lottoWinCount.get(LottoWinInfo.FIRST)).isEqualTo(0);
        assertThat(lottoWinCount.get(LottoWinInfo.SECOND)).isEqualTo(2);
        assertThat(lottoWinCount.get(LottoWinInfo.THIRD)).isEqualTo(3);
        assertThat(lottoWinCount.get(LottoWinInfo.FOURTH)).isEqualTo(3);
        assertThat(lottoWinCount.get(LottoWinInfo.FIFTH)).isEqualTo(1);
    }
}
