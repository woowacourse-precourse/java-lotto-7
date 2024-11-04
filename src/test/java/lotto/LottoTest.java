package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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


    @DisplayName("로또 번호가 1부터 45사이가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "로또 번호가 {0}이면 예외가 발생한다.")
    @MethodSource("invalidLottoNumbersProvider")
    void 로또_번호는_1부터_45사이여야_한다(List<Integer> givenNumbers) {
        assertThatThrownBy(() -> new Lotto(givenNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> invalidLottoNumbersProvider() {
        return Stream.of(
                List.of(0, 10, 20, 30, 40, 50),  // 0과 50은 유효 범위를 벗어남
                List.of(1, 2, 3, 4, 5, 46),      // 46은 유효 범위를 벗어남
                List.of(-1, 10, 20, 30, 40, 45), // -1은 유효 범위를 벗어남
                List.of(1, 2, 3, 44, 45, 100)    // 100은 유효 범위를 벗어남
        );
    }
}
