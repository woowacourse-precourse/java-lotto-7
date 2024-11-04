package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import lotto.Application;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest extends NsTest {

    static Arguments createParam(List<Integer> lotto, int fifth, int fourth, int third, int second, int first,
                                 String rate) {
        return Arguments.of(lotto, fifth, fourth, third, second, first, rate);
    }

    static Stream<Arguments> lottoMachineFactory() {
        return Stream.of(
                createParam(List.of(1, 2, 3, 4, 5, 6), 0, 0, 0, 0, 1, "200,000,000.0%"),
                createParam(List.of(1, 2, 3, 4, 5, 7), 0, 0, 0, 1, 0, "3,000,000.0%"),
                createParam(List.of(1, 2, 3, 4, 5, 45), 0, 0, 1, 0, 0, "150,000.0%"),
                createParam(List.of(1, 2, 3, 4, 44, 45), 0, 1, 0, 0, 0, "5,000.0%"),
                createParam(List.of(1, 2, 3, 43, 44, 45), 1, 0, 0, 0, 0, "500.0%"),
                createParam(List.of(1, 2, 42, 43, 44, 45), 0, 0, 0, 0, 0, "0.0%")
        );
    }

    @ParameterizedTest
    @MethodSource("lottoMachineFactory")
    void 로또당첨_테스트(List<Integer> lotto, int fifth, int fourth, int third, int second, int first, String rate) {
        //Given
        String amount = "3000";
        String winningNumber = "1,2,3,4,5,6";
        String BonusNumber = "7";
        int cnt = Integer.parseInt(amount) / 1000;

        //When, Then
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(amount, winningNumber, BonusNumber);
                    assertThat(output()).contains(
                            String.format("%d개를 구매했습니다.", cnt),
                            lotto.toString(),
                            String.format("3개 일치 (5,000원) - %d개", fifth * cnt),
                            String.format("4개 일치 (50,000원) - %d개", fourth * cnt),
                            String.format("5개 일치 (1,500,000원) - %d개", third * cnt),
                            String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", second * cnt),
                            String.format("6개 일치 (2,000,000,000원) - %d개", first * cnt),
                            String.format("총 수익률은 %s입니다.", rate)
                    );
                },
                lotto,
                lotto,
                lotto
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}