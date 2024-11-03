package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Stream;
import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("잘못된 문자열이 입력으로 들어오면 예외가 발생한다.")
    @NullAndEmptySource
    @ValueSource(strings = {"$$", "3 ,4*"})
    void invalidInput(final String input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("outOfRangeNumbers")
    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    void outOfRangeNumber(final List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    private static Stream<List<Integer>> outOfRangeNumbers() {
        return Stream.of(
                List.of(1, 2, 46, 4, 5, 6),
                List.of(1, 2, 0, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("로또 정상 생성 테스트")
    void validLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertNotNull(lotto);
    }
}
