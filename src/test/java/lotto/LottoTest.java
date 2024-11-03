package lotto;

import lotto.domain.Lotto;
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

    @ParameterizedTest
    @MethodSource("invalidLottoNumbers")
    @DisplayName("로또 번호가 1 ~ 45 범위가 아니면 예외가 발생한다.")
    void 로또_번호가_일부터_사십오_안에_속하지_않으면_예외_발생(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> invalidLottoNumbers() {
        return Stream.of(
                List.of(0, 2, 3, 4, 5, 6),   // 0이 포함된 경우
                List.of(1, 2, 3, 4, 5, 46), // 46이 포함된 경우
                List.of(-1, 2, 3, 4, 5, 6),  // 음수가 포함된 경우
                List.of(1, 2, 3, 4, 5, 999) // 범위를 벗어난 큰 숫자가 포함된 경우
        );
    }
    @ParameterizedTest
    @MethodSource("duplicateLottoNumbers")
    @DisplayName("로또 번호가 중복되면 예외가 발생한다")
    void 로또_번호가_중복되면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> duplicateLottoNumbers() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 5),
                List.of(1, 2, 3, 4, 45, 45)
        );
    }
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
