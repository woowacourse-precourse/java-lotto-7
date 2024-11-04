package lotto.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    @DisplayName("6등 | 일치하는 번호가 2개 이하인 경우")
    @ParameterizedTest
    @CsvSource(value = {"0, false", "0, true", "1, false", "1, true", "2, false", "2, true"})
    void should_ReturnLose_When_MatchCountIsLowerThan3(int matchCount, boolean hasBonus) {
        LottoResult lottoResult = LottoResult.calculate(matchCount, hasBonus);

        assertThat(lottoResult).isEqualTo(LottoResult.LOSE);
    }

    @DisplayName("5등 | 일치하는 번호가 3개인 경우")
    @ParameterizedTest
    @CsvSource(value = {"3, false", "3, true"})
    void should_ReturnFifth_When_MatchCountIs3(int matchCount, boolean hasBonus) {
        LottoResult lottoResult = LottoResult.calculate(matchCount, hasBonus);

        assertThat(lottoResult).isEqualTo(LottoResult.FIFTH);
    }

    @DisplayName("4등 | 일치하는 번호가 4개인 경우")
    @ParameterizedTest
    @CsvSource(value = {"4, false", "4, true"})
    void should_ReturnFourth_When_MatchCountIs4(int matchCount, boolean hasBonus) {
        LottoResult lottoResult = LottoResult.calculate(matchCount, hasBonus);

        assertThat(lottoResult).isEqualTo(LottoResult.FOURTH);
    }

    @DisplayName("3등 | 일치하는 번호가 5개이고 보너스 번호를 못 맞춘 경우")
    @Test
    void should_ReturnThird_When_MatchCountIs5AndHasNoBonus() {
        LottoResult lottoResult = LottoResult.calculate(5, false);

        assertThat(lottoResult).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("2등 | 일치하는 번호가 5개이고 보너스 번호를 맞춘 경우")
    @Test
    void should_ReturnSecond_When_MatchCountIs5AndHasBonus() {
        LottoResult lottoResult = LottoResult.calculate(5, true);

        assertThat(lottoResult).isEqualTo(LottoResult.SECOND);
    }

    @DisplayName("1등 | 일치하는 번호가 6개인 경우")
    @Test
    void should_ReturnFirst_When_MatchCountIs6() {
        LottoResult lottoResult = LottoResult.calculate(6, false);

        assertThat(lottoResult).isEqualTo(LottoResult.FIRST);
    }
}
