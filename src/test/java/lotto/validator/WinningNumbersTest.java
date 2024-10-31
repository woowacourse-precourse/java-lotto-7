package lotto.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest extends NsTest {

    @Test
    void 당첨번호가_아무런_값을_갖지_않는_경우() throws Exception{
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_쉼표로_구분자를_갖지_않는_경우() throws Exception{
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate("1&2,3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_1부터_45사이의_범위가_아닌_경우() throws Exception{
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate("1,2,3,4,5,55");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_중복된_경우() throws Exception{
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate("1,2,3,4,6,6");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_6자리가_아닌_경우() throws Exception{
        assertThatThrownBy(() -> {
            WinningNumbersValidator.validate("1,2,3,4,6,6,7");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}
