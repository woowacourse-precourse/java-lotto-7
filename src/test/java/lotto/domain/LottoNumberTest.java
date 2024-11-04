package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("1부터 45 사이의 숫자로 로또 번호를 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void createLottoNumber(int number) {
        assertThat(LottoNumber.of(number).getNumber()).isEqualTo(number);
    }

    @DisplayName("1보다 작은 숫자로 로또 번호를 생성할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createLottoNumberWithNumberUnderOne(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("45보다 큰 숫자로 로또 번호를 생성할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {46, 100})
    void createLottoNumberWithNumberOverFortyFive(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}