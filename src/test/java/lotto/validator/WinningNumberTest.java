package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void 로또_숫자_범위_테스트() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,67").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 1이상 45이하 자연수로 입력해 주세요.");
    }

    @Test
    void 숫자_중복_테스트() {
        assertThatThrownBy(() -> new WinningNumber("1,1,2,34,5,32").isSameNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되지 않는 6개의 숫자를 입력해 주세요.");

        assertThatThrownBy(() -> new WinningNumber("1,2,34,34,23,32,67").isSameNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되지 않는 6개의 숫자를 입력해 주세요.");
    }

    @Test
    void 구분자_쉼표_테스트() {
        assertThatThrownBy(() -> new WinningNumber("1,2-,3,4,5,6").isDelimitedByComma())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 쉼표(,)로 구분된 숫자를 입력해 주세요.");
    }
}