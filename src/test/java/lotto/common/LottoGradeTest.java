package lotto.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGradeTest {
    @Test
    @DisplayName("2등 제대로 생성되는지 확인")
    void secondGradeTest() {
        // given
        int count = 5;
        boolean bonus = true;

        // when
        LottoGrade grade = LottoGrade.getGrade(count, bonus);

        // then
        assertThat(grade).isEqualTo(LottoGrade.SECOND);
    }

    @Test
    @DisplayName("3등 제대로 생성되는지 확인")
    void thirdGradeTest() {
        // given
        int count = 5;
        boolean bonus = false;

        // when
        LottoGrade grade = LottoGrade.getGrade(count, bonus);

        // then
        assertThat(grade).isEqualTo(LottoGrade.THIRD);
    }
}
