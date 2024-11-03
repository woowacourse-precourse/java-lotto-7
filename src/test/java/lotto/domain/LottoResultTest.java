package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("여러 등수의 당첨을 동시에 계산한다")
    void calculateMultipleWinners() {
        // given
        LottoResult lottoResult = new LottoResult();

        // when
        lottoResult.updateResult(WinningInfo.FIRST_WINNER);
        lottoResult.updateResult(WinningInfo.SECOND_WINNER);
        lottoResult.updateResult(WinningInfo.THIRD_WINNER);
        lottoResult.updateResult(WinningInfo.FOURTH_WINNER);
        lottoResult.updateResult(WinningInfo.FIFTH_WINNER);

        // then
        assertThat(lottoResult.toString())
                .contains("6개 일치 (2,000,000,000원) - 1개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개")
                .contains("5개 일치 (1,500,000원) - 1개")
                .contains("4개 일치 (50,000원) - 1개")
                .contains("3개 일치 (5,000원) - 1개");
    }
}