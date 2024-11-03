package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.error.CustomException;
import lotto.error.ExceptionMessage;
import lotto.model.LottoGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGradeTest {
    @DisplayName("6개의 번호가 맞으면 1등을 반환한다.")
    @Test
    void 번호가_6개_맞으면_1등을_반환한다() {
        LottoGrade grade = LottoGrade.getGrade(6, false);
        assertThat(grade).isEqualTo(LottoGrade.FIRST_GRADE);
    }

    @DisplayName("5개의 번호와 보너스 번호가 맞으면 2등을 반환한다.")
    @Test
    void 번호가_5개의_번호와_보너스_번호가_맞으면_2등을_반환한다() {
        LottoGrade grade = LottoGrade.getGrade(5, true);
        assertThat(grade).isEqualTo(LottoGrade.SECOND_GRADE);
    }

    @DisplayName("5개의 번호는 맞지만 보너스 번호가 안맞으면 3등을 반환한다.")
    @Test
    void 번호가_5개의_번호는_맞지만_보너스_번호가_안맞으면_3등을_반환한다() {
        LottoGrade grade = LottoGrade.getGrade(5, false);
        assertThat(grade).isEqualTo(LottoGrade.THIRD_GRADE);
    }

    @DisplayName("4개의 번호가 맞으면 4등을 반환한다.")
    @Test
    void 번호가_4개_맞으면_4등을_반환한다() {
        LottoGrade grade = LottoGrade.getGrade(4, false);
        assertThat(grade).isEqualTo(LottoGrade.FOURTH_GRADE);
    }

    @DisplayName("3개의 번호가 맞으면 5등을 반환한다.")
    @Test
    void 번호가_3개_맞으면_5등을_반환한다() {
        LottoGrade grade = LottoGrade.getGrade(3, false);
        assertThat(grade).isEqualTo(LottoGrade.FIFTH_GRADE);
    }

    @Test
    @DisplayName("유효하지 않은 맞춘 개수가 들어오면 CustomException을 던진다")
    void 유효하지_않은_맞춘_개수가_들어오면_예외를_발생시킨다() {
        int invalidCorrectCount = 10;
        assertThatThrownBy(() -> LottoGrade.getGrade(invalidCorrectCount, false))
                .isInstanceOf(CustomException.class)
                .hasMessage(ExceptionMessage.ERROR_MESSAGE_IS_NOT_VALID_CORRECT_COUNT.toString());
    }

}
