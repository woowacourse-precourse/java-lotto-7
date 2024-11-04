package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningTierTest {

    @Test
    void 맞춘_숫자_개수_enum_반환_2등() {
        // given
        int matchCount = 5;
        boolean isBonusNumber = true;

        // when
        LottoWinningTier lottoWinningTier = LottoWinningTier.getMatchCountTier(matchCount, isBonusNumber);

        // then
        assertThat(lottoWinningTier).isEqualTo(LottoWinningTier.MATCH_FIVE_WITH_BONUS);
    }

    @Test
    void 맞춘_숫자_개수_enum_반환_3등() {
        // given
        int matchCount =5;
        boolean isBonusNumber = false;

        // when
        LottoWinningTier lottoWinningTier = LottoWinningTier.getMatchCountTier(matchCount, isBonusNumber);

        // then
        assertThat(lottoWinningTier).isEqualTo(LottoWinningTier.MATCH_FIVE);
    }

    @Test
    void int_값과_함께_메세지_반환() {
        // given
        int count = 3;

        // when
        String result = LottoWinningTier.MATCH_FOUR.getCountMessage(count);

        // then
        assertThat(result).isEqualTo("4개 일치 (50,000원) - 3개");
    }
}
