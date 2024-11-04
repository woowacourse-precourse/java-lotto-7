package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private final InputView inputView = new InputView();
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ERROR_MESSAGE_NUMBER = "숫자로 입력해야 합니다.";
    private static final String ERROR_MESSAGE_1000 = "구입 금액은 1000원 단위로 입력 해야 합니다.";
    private static final String ERROR_MESSAGE_WIN6 = "당첨 번호는 6개의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_MATCH = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_DISTINCT = "중복된 번호가 존재합니다.";


    @DisplayName("전체 로직 테스트")
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

    @DisplayName("전체 로직 테스트 - 6개 번호 일치로 1등 당첨 시")
    @Test
    void 전체_로직_1등_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 8, 9, 10, 11, 12]",
                            "[13, 14, 15, 16, 17, 18]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 66,666,666.67%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18)
        );
    }

    @DisplayName("전체 로직 테스트 - 5개 + 보너스 번호 일치로 2등 당첨 시")
    @Test
    void 전체_로직_2등_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 3, 4, 5, 7]",  // 5개 + 보너스 번호 일치
                            "[11, 12, 13, 14, 15, 16]",
                            "[21, 22, 23, 24, 25, 26]",
                            "[31, 32, 33, 34, 35, 36]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 600,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(11, 12, 13, 14, 15, 16),
                List.of(21, 22, 23, 24, 25, 26),
                List.of(31, 32, 33, 34, 35, 36)
        );
    }

    @DisplayName("구입 금액 입력 예외 테스트 - 숫자 형식이 아닌 경우")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_NUMBER);
        });
    }

    @DisplayName("구입 금액 입력 예외 테스트 - 1,000원 단위가 아닌 경우")
    @Test
    void 구입_금액_단위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1050");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_1000);
        });
    }

    @DisplayName("당첨 번호 입력 예외 테스트 - 숫자가 아닌 경우")
    @Test
    void 당첨_번호_숫자_예외_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,A", "7");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_NUMBER);
        });
    }

    @DisplayName("당첨 번호 입력 예외 테스트 - 6개가 아닌 경우")
    @Test
    void 당첨_번호_개수_예외_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5", "7");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_WIN6);
        });
    }

    @DisplayName("당첨 번호 입력 예외 테스트 - 1-45 범위를 벗어나는 경우")
    @Test
    void 당첨_번호_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "0,1,2,3,4,5", "7");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_MATCH);
        });
    }

    @DisplayName("당첨 번호 입력 예외 테스트 - 중복된 번호가 있는 경우")
    @Test
    void 당첨_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,2,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_DISTINCT);
        });
    }

    @DisplayName("보너스 번호 입력 예외 테스트 - 범위를 벗어나는 경우")
    @Test
    void 보너스_번호_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_MATCH);
        });
    }

    @DisplayName("보너스 번호 입력 예외 테스트 - 숫자 형식이 아닌 경우")
    @Test
    void 보너스_번호_숫자_형식_예외_테스트() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "abc");
            assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE_NUMBER);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
