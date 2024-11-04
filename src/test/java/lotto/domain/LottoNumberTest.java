package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = ERROR_MESSAGE + "숫자의 범위는 %d ~ %d 사이의 값입니다.";

    @Test
    @DisplayName("숫자 생성 테스트")
    void create_number_test() {
        LottoNumber number = LottoNumber.of(1);
        assertThat(number).isEqualTo(LottoNumber.of("1"));
    }

    @DisplayName("로또 숫자는 숫자만 입력 가능하다.")
    @Test
    void 로또_숫자는_숫자만_가능() {
        assertThatThrownBy(() -> LottoNumber.of("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Input : {0}")
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("숫자 범위 예외 테스트")
    void validate_range_test(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Input : {0}")
    @ValueSource(ints = {MIN_NUMBER - 1, MAX_NUMBER + 1})
    @DisplayName("숫자 범위 예외 메세지 테스트")
    void validate_message_range_test(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(LOTTO_NUMBER_RANGE_ERROR_MESSAGE, MIN_NUMBER, MAX_NUMBER);
    }
}