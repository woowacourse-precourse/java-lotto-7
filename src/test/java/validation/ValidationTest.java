package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 비어있는_문자열_테스트() {
        assertThatThrownBy(() -> Validation.blankInput(null))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.blankInput(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_숫자_전환_에러_테스트() {
        assertThatThrownBy(() -> Validation.numberInput("abx"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력_에러_테스트() {
        assertThatThrownBy(() -> Validation.numberInput("-1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최대금액_에러_테스트() {
        assertThatThrownBy(() -> Validation.overInput(100001))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또금액_나머지_에러_테스트(){
        assertThatThrownBy(() -> Validation.divideByLottoValue(1234))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
