package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @Test
    @DisplayName("로또 객체 생성 성공")
    void testLottoCreationWithValidNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertEquals(numbers, lotto.getNumbers());
    }

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
    @MethodSource("invalidNumberCountData")
    @DisplayName("로또 번호가 6개가 아니면 예외 발생")
    void testLottoCreationWithInvalidNumbers(List<Integer> numbers) {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers),
                "로또 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("invalidNumberRangeData")
    @DisplayName("로또 번호가 1~45 범위를 벗어날 경우 예외 발생")
    void testLottoCreationWithOutOfRangeNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6); // 0이 범위 밖

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers),
                "로또 번호는 1~45 사이 숫자여야합니다.");
    }

    static Stream<List<Integer>> invalidNumberCountData() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2),
                Arrays.asList(1),
                Arrays.asList()
        );
    }

    static Stream<List<Integer>> invalidNumberRangeData() {
        return Stream.of(
                Arrays.asList(0, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 46),
                Arrays.asList(-1, 2, 3, 4, 5, 6),
                Arrays.asList(100, 200, 300, 400, 500, 600)
        );
    }
}
