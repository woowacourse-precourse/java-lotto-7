package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("로또 번호의 숫자 범위(1~45)를 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideOutOfRangeNumbers")
    public void whenNumberOutOfRange_thenThrowException(List<Integer> numbers) {
        //when & then
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 가지고 있는 숫자를 형식에 맞게 보여준다.")
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    public void thenRepresentLotto(List<Integer> numbers) {
        //given
        Lotto lotto = new Lotto(numbers);
        String regex = "^\\[\\d+(, \\d+){5}\\]$";

        //when & then
        assertTrue(lotto.represent().matches(regex));
    }

    @DisplayName("로또는 숫자를 정렬해서 보여줘야 한다.")
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    public void shouldDisplaySortedList(List<Integer> numbers) {
        //given
        Lotto lotto = new Lotto(numbers);
        
        //when & then
        assertThat(lotto.getNumbers()).isSorted();
    }

    private static Stream<List<Integer>> provideValidNumbers() {
        return Stream.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(1, 2, 3, 4, 5, 45),
            List.of(4, 5, 45, 1, 2, 3),
            List.of(1, 2, 3, 4, 10, 20),
            List.of(40, 41, 42, 43, 44, 45)
        );
    }

    private static Stream<List<Integer>> provideOutOfRangeNumbers() {
        return Stream.of(
            List.of(0, 1, 2, 3, 4, 5),
            List.of(1, 2, 3, 4, 5, 46),
            List.of(0, 1, 2, 3, 4, 46),
            List.of(-1, 1, 2, 3, 4, Integer.MAX_VALUE),
            List.of(Integer.MIN_VALUE, 1, 2, 3, 4, 5)
        );
    }
}
