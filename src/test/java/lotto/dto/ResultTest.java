package lotto.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("당첨번호 문자열형식이 일치하지 않는 경우에는 예외가 발생한다")
    @Test
    void 당첨번호_문자열형식이_일치하지_않는_경우에는_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Result("1,2,3,4,5*6")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

}