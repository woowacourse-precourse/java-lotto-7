package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "[4, 14, 22, 23, 40, 45]",
                            "[10, 14, 21, 22, 23, 37]",
                            "3개 일치 (5,000원) - ",
                            "4개 일치 (50,000원) - ",
                            "5개 일치 (1,500,000원) - ",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                            "6개 일치 (2,000,000,000원) - ",
                            "총 수익률은"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45),
                List.of(40, 23, 4, 14, 22, 45),
                List.of(21, 37, 23, 14, 22, 10)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 문자 입력")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ErrorMessage.IS_NOT_NUMBER.getMsg());
        });
    }

    @DisplayName("보너스 번호 여러 개 입력")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "4,5");
            assertThat(output()).contains(ErrorMessage.IS_NOT_NUMBER.getMsg());
        });
    }

    @DisplayName("보너스 번호 중복 입력")
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ErrorMessage.LOTTO_BONUS_NUM_DUPLICATION.getMsg());
        });
    }

    @DisplayName("로또 번호 중복 입력")
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,6,6");
            assertThat(output()).contains(ErrorMessage.LOTTO_NUMS_DUPLICATION.getMsg());
        });
    }

    @DisplayName("로또 번호 개수 초과 입력")
    @Test
    void 예외_테스트6() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ErrorMessage.LOTTO_SIZE_OUT_OF_RANGE.getMsg());
        });
    }

    @DisplayName("로또 번호 개수 미만 입력")
    @Test
    void 예외_테스트7() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ErrorMessage.LOTTO_SIZE_OUT_OF_RANGE.getMsg());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
