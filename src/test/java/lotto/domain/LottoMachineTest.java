package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.GeneratedNumbers;
import lotto.dto.InputNumbers;
import lotto.dto.WinningStaticsPerConditions;
import lotto.dto.WinningResultStatics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 최종 결과를 반환하는 기능 테스트")
public class LottoMachineTest {

    static Stream<Arguments> provideGeneratedNumbersNoMatch() {
        return Stream.of(
                Arguments.of(new GeneratedNumbers(
                        List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new Lotto(Arrays.asList(6, 8, 9, 10, 11, 12)))
                ), new InputNumbers(Arrays.asList(13, 14, 15, 16, 17, 18), 6))
        );
    }

    static Stream<Arguments> provideGeneratedNumbersFifthPrizeWith2000Money() {
        return Stream.of(
                Arguments.of(new GeneratedNumbers(
                        List.of(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)),
                                new Lotto(Arrays.asList(6, 8, 9, 10, 11, 12)))
                ), new InputNumbers(Arrays.asList(1, 2, 3, 13, 14, 15), 35))
        );
    }

    static Stream<Arguments> provideGeneratedNumbersFourthPrizeWith8000Money() {
        return Stream.of(
                Arguments.of(new GeneratedNumbers(
                        List.of(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
                        )
                ), new InputNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7))
        );
    }


    @DisplayName("일치하는_번호가_없을_경우_상금_수익률은_없다")
    @ParameterizedTest
    @MethodSource("provideGeneratedNumbersNoMatch")
    void 일치하는_번호가_없을_경우_상금_수익률은_없다(GeneratedNumbers generatedNumbers, InputNumbers inputNumbers) {

        LottoMachine lottoMachine = new LottoMachine();
        int numberOfTickets = 2;

        WinningResultStatics winningResultStatics = lottoMachine.runMachine(generatedNumbers, inputNumbers,
                numberOfTickets);
        List<WinningStaticsPerConditions> winningNumbersStatics = winningResultStatics.getWinningNumbersStatics();

        assertThat(winningNumbersStatics.get(0).getMatchNumbers()).isEqualTo(0);
        assertThat(winningNumbersStatics.get(1).getMatchNumbers()).isEqualTo(0);
        assertThat(winningResultStatics.getWinningPrizeStatics()).isEqualTo("0.0");

    }

    @DisplayName("구매금액_2000원_최종결과가_5등인_경우")
    @ParameterizedTest
    @MethodSource("provideGeneratedNumbersFifthPrizeWith2000Money")
    void 구매금액_2000원_최종결과가_5등인_경우(GeneratedNumbers generatedNumbers, InputNumbers inputNumbers) {

        LottoMachine lottoMachine = new LottoMachine();
        int numberOfTickets = 2;

        WinningResultStatics winningResultStatics = lottoMachine.runMachine(generatedNumbers, inputNumbers,
                numberOfTickets);
        List<WinningStaticsPerConditions> winningNumbersStatics = winningResultStatics.getWinningNumbersStatics();

        assertThat(winningNumbersStatics.get(0).getMatchNumbers()).isEqualTo(1);
        assertThat(winningNumbersStatics.get(1).getMatchNumbers()).isEqualTo(0);
        assertThat(winningResultStatics.getWinningPrizeStatics()).isEqualTo("250.0");
    }

    @DisplayName("구매금액_8000원_최종결과가_5등인_경우")
    @ParameterizedTest
    @MethodSource("provideGeneratedNumbersFourthPrizeWith8000Money")
    void 구매금액_8000원_최종결과가_5등인_경우(GeneratedNumbers generatedNumbers, InputNumbers inputNumbers) {

        LottoMachine lottoMachine = new LottoMachine();
        int numberOfTickets = 8;

        WinningResultStatics winningResultStatics = lottoMachine.runMachine(generatedNumbers, inputNumbers,
                numberOfTickets);
        List<WinningStaticsPerConditions> winningNumbersStatics = winningResultStatics.getWinningNumbersStatics();

        assertThat(winningNumbersStatics.get(0).getMatchNumbers()).isEqualTo(1);
        assertThat(winningNumbersStatics.get(1).getMatchNumbers()).isEqualTo(0);
        assertThat(winningResultStatics.getWinningPrizeStatics()).isEqualTo("62.5");
    }
}
