package lotto;

import static lotto.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankRuleTest {

    @DisplayName("RankRule은_일치_번호의_개수에_맞는_Rank를_반환할_수_있다")
    @CsvSource(value = {"0:NONE", "1:NONE", "2:NONE", "3:FIFTH", "4:FOURTH", "5:THIRD", "6:FIRST"}, delimiter = ':')
    @ParameterizedTest
    public void checkRank(int input, Rank expected) {
        //given
        int winningNumberMatchCount = input;
        boolean isBonusNumberMatched = false;

        //when
        Rank result = RankRule.checkRank(winningNumberMatchCount, isBonusNumberMatched);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("RankRule은_일치_번호의_개수와_보너스_번호의_일치_여부에_따라_2등을_반환할_수_있다")
    @Test
    public void should_ReturnSecond_WhenBonusNumberMatched() {
        //given
        int winningNumberMatchCount = 5;
        boolean isBonusNumberMatched = true;

        //when
        Rank result = RankRule.checkRank(winningNumberMatchCount, isBonusNumberMatched);

        //then
        assertThat(result).isEqualTo(SECOND);
    }
}