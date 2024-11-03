package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
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
    @DisplayName("로또 번호 범위가 1~45을 벗어나면 예외가 발생한다.")
    @CsvSource({
            "0,1,2,3,4,5",
            "1,2,3,4,5,46"
    })
    void throwExceptionIfLottoNumberIsNotInRange(String numberString) {
        assertThatThrownBy(() -> new Lotto(Stream.of(numberString.split(","))
                .map(Integer::parseInt).toList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 변경하려 하면 예외 발생")
    @Test
    void throwExceptionIfModifyNumbersInLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> numbersFromLotto = lotto.getNumbers();

        assertThatThrownBy(() -> numbersFromLotto.set(0, 7)).isInstanceOf(UnsupportedOperationException.class);
    }
}
