package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    private static final String errorMessage = "[ERROR] 1 ~ 45 사이의 정수만 입력 가능합니다";

    @DisplayName("번호 생성 후 값 출력이 정상적이다.")
    @Test
    void 번호_생성_후_값_출력() {
        Number numberInteger = new Number(30);
        Number numberString = new Number("30");

        Assertions.assertThat(numberInteger.value()).isEqualTo(30);
        Assertions.assertThat(numberString.value()).isEqualTo(30);
    }

    @DisplayName("같은 값을 가진 두 번호 객체가 동일하다.")
    @Test
    void 같은_값_번호_객체_동일() {
        Number numberInteger = new Number(30);
        Number numberString = new Number("30");

        Assertions.assertThat(numberInteger).isEqualTo(numberString);
    }

    @DisplayName("번호에 특수문자가 입력되면 예외가 발생한다.")
    @Test
    void 번호에_특수문자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Number("!"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("!23"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("2!3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("23!"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);
    }

    @DisplayName("번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void 번호에_문자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Number("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("a1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("1a"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("a1b"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);
    }

    @DisplayName("번호에 공백이 입력되면 예외가 발생한다.")
    @Test
    void 번호에_공백이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Number(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("\n"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);
    }

    @DisplayName("번호에 공백을 포함한 숫자가 입력되면 예외가 발생한다.")
    @Test
    void 번호에_공백을_포함한_숫자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Number(" 12"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("12 "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("1 2"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);
    }

    @DisplayName("범위를 초과한 정수가 입력되면 예외가 발생한다.")
    @Test
    void 범위를_초과한_정수가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Number("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("-1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);

        assertThatThrownBy(() -> new Number("46"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(errorMessage);
    }


}