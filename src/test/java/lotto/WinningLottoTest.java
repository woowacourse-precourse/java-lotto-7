package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.common.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {
    @DisplayName("보너스 번호가 범위에 벗어날때 예외가 발생한다.")
    @Test
    void 보너스번호가_범위에_벗어날때_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,6), 46));
    }

    @DisplayName("보너스 번호가 이미 당첨번호에 존재할때 예외가 발생한다.")
    @Test
    void 보너스_번호가_이미_당첨번호에_존재할때_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,6), 1));
    }

    @DisplayName("당첨 결과 테스트")
    @ParameterizedTest
    @MethodSource("당첨결과데이터")
    void 당첨_결과_테스트(final Lotto lotto, final LottoResult lottoResult) {
        final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);

        Assertions.assertThat(winningLotto.getResult(lotto))
                .isEqualTo(lottoResult);
    }

    static Stream<Arguments> 당첨결과데이터() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoResult.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), LottoResult.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoResult.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), LottoResult.FORTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)), LottoResult.FIFTH),

                Arguments.of(new Lotto(List.of(11, 12, 13, 17, 18, 19)), LottoResult.NONE),
                Arguments.of(new Lotto(List.of(1, 7, 8, 9, 10, 11)), LottoResult.NONE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 45)), LottoResult.NONE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 8, 45)), LottoResult.NONE)
        );
    }
}