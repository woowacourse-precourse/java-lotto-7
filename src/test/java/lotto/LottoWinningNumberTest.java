package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {

    @Test
    void checkResult_6() {
        LottoWinningNumber winningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = winningNumber.checkResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoResult).isEqualTo(LottoResult.SIX_MATCH);
    }

    @Test
    void checkResult_5_with_bonus() {
        LottoWinningNumber winningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = winningNumber.checkResult(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        assertThat(lottoResult).isEqualTo(LottoResult.FIVE_MATCH_BONUS);
    }

    @Test
    void checkResult_5() {
        LottoWinningNumber winningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = winningNumber.checkResult(new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        assertThat(lottoResult).isEqualTo(LottoResult.FIVE_MATCH);
    }

    @Test
    void checkResult_4() {
        LottoWinningNumber winningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = winningNumber.checkResult(new Lotto(List.of(45, 44, 3, 4, 5, 6)));
        assertThat(lottoResult).isEqualTo(LottoResult.FOUR_MATCH);
    }

    @Test
    void checkResult_3() {
        LottoWinningNumber winningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = winningNumber.checkResult(new Lotto(List.of(10, 2, 30, 40, 5, 6)));
        assertThat(lottoResult).isEqualTo(LottoResult.THREE_MATCH);
    }

    @Test
    void checkResult_0() {
        LottoWinningNumber winningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = winningNumber.checkResult(new Lotto(List.of(11, 12, 13, 14, 15, 16)));
        assertThat(lottoResult).isEqualTo(LottoResult.NO_MATCH);
    }
}