package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.error.ErrorType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NEED_NUMBER_IN_RANGE = "[ERROR] 구매 금액은 1000이상 10000000이하여야 합니다.";


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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액_입력_오류로_다시_입력받는_테스트() {
        assertSimpleTest(() -> {
            run("10", "1000", "10, 11, 12, 13, 14, 15", "45");
            assertThat(output()).contains(NEED_NUMBER_IN_RANGE);
        });
    }

    @Test
    void 당첨번호에_중복_숫자_입력_오류로_다시_입력받는_테스트() {
        assertSimpleTest(() -> {
            run("1000", "10, 10, 12, 13, 14, 15", "10, 11, 12, 13, 14, 15", "6");
            assertThat(output()).contains(ErrorType.NEED_DISTINCT_NUMBER.getMessage());
        });
    }

    @Test
    void 보너스_번호에_당첨번호와_중복_숫자_입력_오류로_다시_입력받는_테스트() {
        assertSimpleTest(() -> {
            run("1000", "10, 11, 12, 13, 14, 15", "15", "6");
            assertThat(output()).contains(ErrorType.NEED_DISTINCT_NUMBER.getMessage());
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
