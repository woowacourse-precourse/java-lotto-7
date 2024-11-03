package lotto.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private static Stream<List<Integer>> argumentsForLottoNumbersSizeIsNot6() {
        return Stream.of(
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5, 6, 7, 8)
        );
    }

    private static Stream<List<Integer>> argumentsForLottoNumbersOutOfRange() {
        return Stream.of(
                List.of(-1, 2, 3, 4, 5, 6),
                List.of(0, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    private static Stream<List<Integer>> argumentsForIssueLottoManually() {
        return Stream.of(
                List.of(3, 21, 7, 41, 33, 42),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(10, 20, 30, 40, 41, 42)
        );
    }

    @DisplayName("예외 | 로또 번호가 6개가 아닌 경우")
    @ParameterizedTest
    @MethodSource("argumentsForLottoNumbersSizeIsNot6")
    void should_ThrowException_When_LottoNumbersSizeIsNot6(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("예외 | 로또 번호가 중복된 경우")
    @Test
    void should_ThrowException_When_LottoNumbersHasDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("예외 | 로또 번호가 1부터 45 사이가 아닌 경우")
    @ParameterizedTest
    @MethodSource("argumentsForLottoNumbersOutOfRange")
    void should_ThrowException_When_LottoNumbersIsOutOfRange(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
    }

    @DisplayName("성공 | 로또 번호가 6개인 경우")
    @Test
    void should_Success_When_ValidLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isNotNull();
    }

    @DisplayName("성공 | 자동 로또 발행")
    @Test
    void should_Success_When_IssueLotto() {
        Lotto lotto = Lotto.issue();

        List<Integer> numbers = Stream.of(lotto.toString().replaceAll("[\\[\\]\\s]", "").split(","))
                .map(Integer::parseInt)
                .toList();

        assertThat(lotto).isNotNull();
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("성공 | 수동 로또 발행")
    @ParameterizedTest
    @MethodSource("argumentsForIssueLottoManually")
    void should_Success_When_IssueLottoManually(List<Integer> numbers) {
        Lotto lotto = Lotto.issue(numbers);

        assertThat(lotto).isNotNull();
        assertThat(lotto.toString()).isEqualTo(numbers.toString());
    }
}
