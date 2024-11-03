package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningKindTest {

    @DisplayName("matchCount와 bonus 조건에 따라 적절한 WinningKind가 반환되는지 확인")
    @ParameterizedTest
    @CsvSource({
            "3, false, MATCH_3",
            "4, false, MATCH_4",
            "5, false, MATCH_5",
            "5, true, MATCH_5_BONUS",
            "6, false, MATCH_6"
    })
    void getWinningKind_ReturnsCorrectWinningKind(int matchCount, boolean bonus, WinningKind expected) {
        assertThat(WinningKind.getWinningKind(matchCount, bonus)).isEqualTo(expected);
    }

}