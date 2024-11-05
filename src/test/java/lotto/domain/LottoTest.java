package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.validation.LottoNumbersValidator;
import lotto.view.input.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개 이상이면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1.2.3.4.5.6", "123456", "123, ,56", "1,2,3,,5,6", "abc", "!@1234", "1,a,3,4,5,6"})
    @DisplayName("로또 번호에 잘못된 형식이 포함되면 예외가 발생한다.")
    void 로또_번호에_잘못된_형식이_포함되면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            LottoNumbersValidator.validateLottoNumberFormat(input);
        }).isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("로또 번호가 1-45 범위가 아니라면 예외가 발생한다.")
    void 로또_번호가_1_45_범위가_아니라면_예외가_발생한다() {
        // when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 66)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
