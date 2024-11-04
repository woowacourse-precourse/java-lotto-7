package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Application 테스트")
class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    static Stream<Arguments> 기능_테스트_케이스() {
        return Stream.of(
                Arguments.of(
                        new String[]{"8000", "1,2,3,4,5,6", "7"},
                        new String[]{
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
                                "총 수익률은 62.5%입니다."},
                        List.of(8, 21, 23, 41, 42, 43),
                        new List[]{
                                List.of(3, 5, 11, 16, 32, 38),
                                List.of(7, 11, 16, 35, 36, 44),
                                List.of(1, 8, 11, 31, 41, 42),
                                List.of(13, 14, 16, 38, 42, 45),
                                List.of(7, 11, 30, 40, 42, 43),
                                List.of(2, 13, 22, 32, 38, 45),
                                List.of(1, 3, 5, 14, 22, 45)
                        }
                ),
                Arguments.of(
                        new String[]{"5000", "1,4,5,6,30,12", "33"},
                        new String[]{
                                "5개를 구매했습니다.",
                                "[1, 20, 29, 33, 36, 37]",
                                "[12, 14, 16, 18, 21, 33]",
                                "[1, 4, 13, 16, 33, 43]",
                                "[4, 5, 8, 30, 35, 40]",
                                "[5, 8, 12, 36, 38, 40]",
                                "당첨 통계",
                                "---",
                                "3개 일치 (5,000원) - 1개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 0개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 100.0%입니다."},
                        List.of(1, 20, 29, 33, 36, 37),
                        new List[]{
                                List.of(12, 14, 16, 18, 21, 33),
                                List.of(1, 4, 13, 16, 33, 43),
                                List.of(4, 5, 8, 30, 35, 40),
                                List.of(5, 8, 12, 36, 38, 40)
                        }
                ),
                Arguments.of(
                        new String[]{"3000", "4,6,27,38,43,19", "44"},
                        new String[]{
                                "3개를 구매했습니다.",
                                "[20, 22, 25, 27, 33, 36]",
                                "[4, 6, 27, 38, 43, 44]",
                                "[6, 19, 21, 27, 28, 32]",
                                "당첨 통계",
                                "---",
                                "3개 일치 (5,000원) - 1개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 0개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 1000166.7%입니다."},
                        List.of(20, 22, 25, 27, 33, 36),
                        new List[]{
                                List.of(4, 6, 27, 38, 43, 44),
                                List.of(6, 19, 21, 27, 28, 32)
                        }
                )
        );
    }

    @ParameterizedTest(name = "args: {0}, expectedOutputs: {1}, firstRandomNumbers: {2}, remainingRandomNumbers: {3}")
    @MethodSource("기능_테스트_케이스")
    void 기능_테스트(
            String[] args,
            String[] expectedOutputs,
            List<Integer> firstRandomNumbers,
            List<Integer>... remainingRandomNumbers) {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(args);
                    assertThat(output()).contains(
                            expectedOutputs
                    );
                },
                firstRandomNumbers, remainingRandomNumbers
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
