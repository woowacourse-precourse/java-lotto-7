package lotto.domain.prizelotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 당첨에 관한 기능을 확인한다.")
class PrizeLottoTest {

    @ParameterizedTest
    @DisplayName("각 로또 당첨 조건의 만족을 확인한다.")
    @MethodSource("providePrizeLotto")
    void isSatisfyPrizeRule(int count, PrizeLotto prizeLotto, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        boolean satisfyPrizeRule = prizeLotto.isSatisfyPrizeRule(count, lottoNumbers, winNumbers);
        assertThat(satisfyPrizeRule).isTrue();
    }

    private static Stream<Arguments> providePrizeLotto() {
        return Stream.of(
                Arguments.of(3, new FifthPrizeLotto(), List.of(1, 2, 3, 4, 5, 6),
                        new WinNumbers(List.of(1, 2, 3, 9, 10, 11), 7)),
                Arguments.of(4, new FourthPrizeLotto(), List.of(1, 2, 3, 4, 5, 6),
                        new WinNumbers(List.of(1, 2, 3, 4, 9, 10), 7)),
                Arguments.of(5, new ThirdPrizeLotto(), List.of(1, 2, 3, 4, 5, 22),
                        new WinNumbers(List.of(1, 2, 3, 4, 5, 10), 7)),
                Arguments.of(5, new SecondPrizeLotto(), List.of(1, 2, 3, 4, 5, 7),
                        new WinNumbers(List.of(1, 2, 3, 4, 5, 10), 7)),
                Arguments.of(6, new FirstPrizeLotto(), List.of(1, 2, 3, 4, 5, 6),
                        new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 7))
        );
    }
}
