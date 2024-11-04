package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoRank.*;
import static lotto.fixture.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    void 로또_당첨_등수_반환() {
        assertThat(matchNumbers(new Lotto(zeroMatchNumbers), getWinLotto())).isEqualTo(FAIL);
        assertThat(matchNumbers(new Lotto(oneMatchNumbers), getWinLotto())).isEqualTo(FAIL);
        assertThat(matchNumbers(new Lotto(twoMatchNumbers), getWinLotto())).isEqualTo(FAIL);
        assertThat(matchNumbers(new Lotto(threeMatchNumbers), getWinLotto())).isEqualTo(THREE);
        assertThat(matchNumbers(new Lotto(fourMatchNumbers), getWinLotto())).isEqualTo(FOUR);
        assertThat(matchNumbers(new Lotto(fiveMatchNumbers), getWinLotto())).isEqualTo(FIVE);
        assertThat(matchNumbers(new Lotto(fiveBonusMatchNumbers), getWinLotto())).isEqualTo(FIVE_BONUS);
        assertThat(matchNumbers(new Lotto(sixMatchNumbers), getWinLotto())).isEqualTo(SIX);
    }
}
