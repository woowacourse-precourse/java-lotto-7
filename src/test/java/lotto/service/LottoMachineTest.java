package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import lotto.Application;
import org.junit.jupiter.api.Test;
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

    @Test
    void 기능_정렬_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(43, 8, 21, 42, 23, 41),
                List.of(32, 5, 38, 11, 16, 3),
                List.of(36, 11, 44, 7, 16, 35),
                List.of(42, 1, 41, 8, 31, 11),
                List.of(16, 42, 13, 45, 38, 14),
                List.of(42, 7, 43, 11, 30, 40),
                List.of(22, 45, 2, 32, 13, 38),
                List.of(5, 1, 22, 45, 3, 14)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}