package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    private static final LottoMachine LOTTO_MACHINE = new LottoMachine();

    static Stream<Arguments> lottoFactory() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 45), 5),
                Arguments.arguments(List.of(1, 2, 3, 4, 44, 45), 4),
                Arguments.arguments(List.of(1, 2, 3, 43, 44, 45), 3),
                Arguments.arguments(List.of(1, 2, 42, 43, 44, 45), 2),
                Arguments.arguments(List.of(1, 41, 42, 43, 44, 45), 1),
                Arguments.arguments(List.of(40, 41, 42, 43, 44, 45), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoFactory")
    public void 로또번호_당첨번호_비교_테스트(List<Integer> numbers, int expected) throws Exception {
        //Given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        //When
        int actual = LOTTO_MACHINE.compareLotto(lotto, winningNumbers);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> returnRateFactory() {
        return Stream.of(
                Arguments.arguments(5000, 8000, 62.5),
                Arguments.arguments(5000, 1000, 500.0),
                Arguments.arguments(0, 1000, 0.0),
                Arguments.arguments(1000, 1000, 100.0),
                Arguments.arguments(333, 1000, 33.3)
        );
    }

    @ParameterizedTest
    @MethodSource("returnRateFactory")
    public void 수익률_테스트(double totalPrize, double amount, double expected) throws Exception {
        //Given

        //When
        double actual = LOTTO_MACHINE.getReturnRate(totalPrize, amount);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}