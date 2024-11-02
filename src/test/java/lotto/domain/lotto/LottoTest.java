package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("일치하는 번호의 개수를 정확하게 계산한다.")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void 일치하는_번호_개수를_정확하게_계산한다(Lotto lotto, int expected) throws Exception {
        List<Integer> winningNumbers = List.of(1, 9, 18, 27, 36, 45);

        int count = lotto.countHits(winningNumbers);

        assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
            Arguments.of(new Lotto(List.of(1, 9, 18, 27, 36, 45)), 6),
            Arguments.of(new Lotto(List.of(2, 9, 18, 27, 36, 45)), 5),
            Arguments.of(new Lotto(List.of(2, 3, 18, 27, 36, 45)), 4),
            Arguments.of(new Lotto(List.of(2, 3, 4, 27, 36, 45)), 3),
            Arguments.of(new Lotto(List.of(2, 3, 4, 5, 36, 45)), 2),
            Arguments.of(new Lotto(List.of(2, 3, 4, 5, 6, 45)), 1)
        );
    }

    @DisplayName("보너스 번호의 포함 여부를 정확하게 계산한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 18, 27, 36, 45})
    void 보너스번호_포함여부를_정확하게_계산한다(int bonusNumber) throws Exception {
        Lotto lotto = new Lotto(List.of(1, 9, 18, 27, 36, 45));

        boolean matches = lotto.hits(bonusNumber);

        assertThat(matches).isTrue();
    }
}
