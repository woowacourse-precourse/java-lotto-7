package lotto.domain.lottoMachine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.mock.FakeNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    @ParameterizedTest
    @MethodSource("provideLottoForReward")
    void 로또_당첨_상금을_확인할_수_있다(List<Integer> numbers, long expected) {
        // given
        Lotto lotto = Lotto.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7");
        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);

        Lottos lottos = Lottos.of(2, FakeNumberGenerator.from(numbers));
        Result result = Result.of(lottos, winningLotto);

        // when - then
        assertThat(result.getReward()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoForReward() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 4_000_000_000L),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 60_000_000),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 3_000_000),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), 100_000),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10), 10_000),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), 0)
        );
    }

}
