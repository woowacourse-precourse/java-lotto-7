package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {
    @Test
    void 숫자_외의_문자를_포함하면_예외가_발생한다() {
        assertThatThrownBy(() -> ExceptionHandler.validateNumeric("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_음수면_예외가_발생한다() {
        assertThatThrownBy(() -> ExceptionHandler.isPositiveNumber(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_천원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> ExceptionHandler.isThousandDivisible(10220))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 보너스_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> ExceptionHandler.isLottoNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> ExceptionHandler.isLottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
