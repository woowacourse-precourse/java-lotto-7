package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 생성 성공")
    @Test
    void newLottoTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 생성 실패: 로또 번호의 개수가 6개가 아님.")
    @ParameterizedTest
    @MethodSource("validateSizeData")
    void validateSizeTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    private static Stream<List<Integer>> validateSizeData() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @DisplayName("로또 생성 실패: 로또 번호가 1~45 사이의 숫자가 아님.")
    @ParameterizedTest
    @MethodSource("validateRangeData")
    void validateRangeTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
    }

    private static Stream<List<Integer>> validateRangeData() {
        return Stream.of(
                List.of(0, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @DisplayName("로또 생성 실패: 로또 번호에 중복된 숫자가 있음.")
    @Test
    void validateDuplicateTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("로또 생성 성공: 로또 번호가 올바르게 정렬된다.")
    @Test
    void lottoSortTest() {
        List<Integer> unsortedNumbers = List.of(6, 3, 5, 1, 4, 2);
        Lotto lotto = new Lotto(unsortedNumbers);

        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 생성 성공: 올바른 로또 양식을 만든다.")
    @Test
    void toStringTest() {
        List<Integer> numbers = List.of(3, 1, 4, 6, 5, 2);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
