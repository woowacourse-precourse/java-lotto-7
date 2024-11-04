package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessages.INPUT_EMPTY_ERROR;
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
}