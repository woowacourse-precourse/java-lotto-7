package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {

    InputHandler handler = new InputHandler();

    @Test
    void 구매_금액이_1000원_단위가_아닐_때_예외테스트() {
        assertThatThrownBy(() -> handler.checkValidPrice(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 범위가_1부터_45_사이가_아닐_때_예외테스트() {
        assertThatThrownBy(() -> handler.checkValidRange(70))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 당첨번호에_중복된_숫자가_있을_때_예외테스트() {
        String[] numberWithDuplicates = new String[]{"5","5","13","32","39","41"};
        assertThatThrownBy(() -> handler.checkDuplication(numberWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 보너스_번호가_당첨번호에_중복될_때_예외테스트() {
        assertThatThrownBy(() -> handler.checkValidBonusNumber(Arrays.asList(4, 8, 22, 24, 31, 44), 31))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
