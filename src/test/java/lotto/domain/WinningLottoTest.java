package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.dto.WinningResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("provideLotto")
    void 플레이어의_로또를_보고_당첨_결과를_반환할_수_있다(Lotto lotto, WinningResult expected) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 3, 5, 7, 9, 11)), 2);
        WinningResult result = winningLotto.checkResult(lotto);

        assertThat(result.getMatchCount()).isEqualTo(expected.getMatchCount());
        assertThat(result.getBonusMatchCount()).isEqualTo(expected.getBonusMatchCount());
    }

    private static Stream<Arguments> provideLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), new WinningResult(4, 1)),
                Arguments.of(new Lotto(List.of(12, 13, 14, 15, 16, 17)), new WinningResult(0, 0)),
                Arguments.of(new Lotto(List.of(1, 3, 5, 7, 9, 11)), new WinningResult(6, 0))
        );
    }
}