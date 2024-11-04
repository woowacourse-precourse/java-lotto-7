package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessages.INPUT_EMPTY_ERROR;
import static lotto.exception.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    @DisplayName("보너스번호가 빈 문자열이면 예외가 발생한다 - 빈문자열일 경우")
    void 보너스번호가_빈_문자열이면_예외가_발생한다(){
        assertThatThrownBy(()->new BonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY_ERROR);
    }

    @Test
    @DisplayName("보너스번호가 빈 문자열이면 예외가 발생한다 - 공백일 경우")
    void 보너스번호가_빈_문자열이면_예외가_발생한다2(){
        assertThatThrownBy(()->new BonusNumber("     "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY_ERROR);
    }

    @Test
    @DisplayName("보너스번호가 1 이상 45 이하가 아니면 예외가 발생한다 - 범위에 해당하지 않는 숫자일 경우")
    void 보너스번호가_1_이상_45_이하가_아니면_예외가_발생한다(){
        assertThatThrownBy(()->new BonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }

    @Test
    @DisplayName("보너스번호가 1 이상 45 이하가 아니면 예외가 발생한다 - 문자일 경우")
    void 보너스번호가_1_이상_45_이하가_아니면_예외가_발생한다2(){
        assertThatThrownBy(()->new BonusNumber("jinyoung"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }
}