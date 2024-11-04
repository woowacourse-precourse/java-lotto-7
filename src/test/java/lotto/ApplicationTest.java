package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
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
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 로또번호_생성_성공_테스트() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6", "7");
            String output = output();
            assertThat(output).contains("[");
            assertThat(output).contains("]");
        });
    }

    @Test
    void 로또티켓_번호생성_성공_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 로또티켓_정렬확인_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "6,3,1,4,5,2", "7");
                    assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 로또티켓_당첨확인_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 로또발행_수량확인_테스트() {
        assertSimpleTest(() -> {
            run("3000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("3개를 구매했습니다.");
        });
    }

    @Test
    void 당첨통계_계산_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - ",
                            "4개 일치 (50,000원) - ",
                            "5개 일치 (1,500,000원) - ",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 수익률_계산_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains("총 수익률은 200000000.0%입니다.");
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입_금액이_1000원으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        });
    }

    @Test
    void 구입_금액이_1000원_미만이면_예외가_발생한다() {

        assertSimpleTest(() -> {
            runException("500");
            assertThat(output()).contains("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        });
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    @Test
    void 예외상황_처리후_재시도_테스트() {
        assertSimpleTest(() -> {
            // 첫 번째 시도: 잘못된 입력
            runException("1000j");
            assertThat(output()).contains("[ERROR] 숫자를 입력해 주세요.");

            // 두 번째 시도: 잘못된 당첨 번호 형식
            runException("1000", "1,2,3,4,5,a", "7");
            assertThat(output()).contains("[ERROR] 올바른 형식으로 입력해 주세요.");

            // 세 번째 시도: 올바른 입력으로 재시도
            run("1000", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .contains("1개를 구매했습니다.")
                    .contains("당첨 통계")
                    .contains("총 수익률은");

        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
