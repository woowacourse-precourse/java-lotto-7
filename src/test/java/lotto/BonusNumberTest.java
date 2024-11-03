package lotto;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    @DisplayName("빈 문자열을 입력하면 예외가 발생한다.")
    void emptyNumber() {
        assertThatThrownBy(() -> new BonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1~45사이의 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    void inputChar() {
        assertThatThrownBy(() -> new BonusNumber("!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1부터 45 사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    void inputNotRange() {
        assertThatThrownBy(() -> new BonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}