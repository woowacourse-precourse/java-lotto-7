package lotto.domain.validator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    @Test
    @DisplayName("로또 숫자로 6개 이상이 들어오면 예외를 발생시킨다.")
    void whenLengthOver6ThenThrowException() {
        //given
        List<Integer> invalidNumbers = List.of(4, 3, 17, 45, 33, 2, 1);

        //when then
        Assertions.assertThatThrownBy(() -> LottoValidator.validate(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("입력된 숫자 중 1-45 범위를 벗어나는 숫자가 있는 경우")
    void whenOutOfRangeLottoNumberThenThrowException() {
        //given
        List<Integer> invalidNumbers = List.of(4, 3, 1, 47, 33, 2);

        //when then
        Assertions.assertThatThrownBy(() -> LottoValidator.validate(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1-45 사이의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("입력된 숫자 중 중복된 숫자가 있는 경우")
    void whenDuplicateNumbersThenThrowException() {
        //given
        List<Integer> invalidNumbers = List.of(4, 3, 3, 45, 33, 2);

        //when then
        Assertions.assertThatThrownBy(() -> LottoValidator.validate(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}
