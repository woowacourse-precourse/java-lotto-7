package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoUtilityTest {
    private final LottoUtility utility = new LottoUtility();

    @Test
    void 입력한_당첨번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> utility.stringToWinningNumbers("이,삼,사,오,육"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨결과_출력() {
        assertThat(utility.getWinningInfoMessage(LottoWinningStandard.FIRST_PRIZE, 1))
                .isEqualTo("6개 일치 (2,000,000,000원) - 1개");
        assertThat(utility.getWinningInfoMessage(LottoWinningStandard.SECOND_PRIZE, 2))
                .isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개");
        assertThat(utility.getWinningInfoMessage(LottoWinningStandard.THIRD_PRIZE, 3))
                .isEqualTo("5개 일치 (1,500,000원) - 3개");
        assertThat(utility.getWinningInfoMessage(LottoWinningStandard.FOURTH_PRIZE, 4))
                .isEqualTo("4개 일치 (50,000원) - 4개");
        assertThat(utility.getWinningInfoMessage(LottoWinningStandard.FIFTH_PRIZE, 5))
                .isEqualTo("3개 일치 (5,000원) - 5개");
    }
}
