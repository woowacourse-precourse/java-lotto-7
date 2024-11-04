package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParamsValidatorTest {

    @Test
    void 파라미터에_null이_없으면_예외가_발생하지_않는다() {
        //given
        List<Object> params = List.of(1, new Object(), Integer.valueOf("10"));

        //expected
        assertThatCode(() -> ParamsValidator.validateParamsNotNull(this.getClass(), params))
                .doesNotThrowAnyException();
    }

    @Test
    void 파라미터에_null이_하나라도_있으면_예외가_발생한다() {
        //given
        List<Object> params = List.of(1, new Object(), Integer.valueOf("10"));

        //expected
        assertThatThrownBy(() -> ParamsValidator.validateParamsNotNull(this.getClass(), params, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ParamsValidatorTest에 전달된 파라미터가 null입니다.");
    }
}
