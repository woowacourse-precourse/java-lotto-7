package lotto.domain;

import lotto.model.PrizeGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.model.PrizeGrade.THREE_MATCH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrizeGradeTest {
    // FIVE_AND_BONUS_MATCH

    @ParameterizedTest
    @CsvSource({"3, THREE_MATCH", "4, FOUR_MATCH", "5, FIVE_MATCH", "6, SIX_MATCH"})
    @DisplayName("보너스 번호 일치하지 않는 경우")
    void getGradeTestNotBonusMatch(int matchCount, String gradeName) {
        PrizeGrade grade = PrizeGrade.get(matchCount, false);
        assertEquals(grade.name(), gradeName);
    }

    @ParameterizedTest
    @CsvSource({"3, THREE_MATCH", "4, FOUR_MATCH", "5, FIVE_AND_BONUS_MATCH", "6, SIX_MATCH"})
    @DisplayName("보너스 번호 일치하는 경우")
    void getGradeTestBonusMatch(int matchCount, String gradeName) {
        PrizeGrade grade = PrizeGrade.get(matchCount, true);
        assertEquals(grade.name(), gradeName);
    }

    @Test
    @DisplayName("5개 일치, 보너스 불일치")
    void getGradeTestFiveMatchNoBonusMatch() {
        PrizeGrade grade = PrizeGrade.get(5, false);
        assertNotEquals(grade.name(), "FIVE_AND_BONUS_MATCH");
        assertEquals(grade.name(), "FIVE_MATCH");
    }

    @Test
    @DisplayName("5개 일치, 보너스 일치")
    void getGradeTestFiveMatchBonusMatch() {
        PrizeGrade grade = PrizeGrade.get(5, true);
        assertEquals(grade.name(), "FIVE_AND_BONUS_MATCH");
        assertNotEquals(grade.name(), "FIVE_MATCH");
    }


}
