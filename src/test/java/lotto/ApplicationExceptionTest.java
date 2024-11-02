package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class ApplicationExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트_3개일치_1개() {
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

    //에러메시지 상수로 만들어서 제대로 테스트
    @Test
    void 예외_테스트_구매금액_문자() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ErrorMessage.PURCHASE_TYPE_EXCEPTION);
        });
    }

    @Test
    void 예외_테스트_구매금액_음수() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ErrorMessage.PURCHASE_RANGE_EXCEPTION);
        });
    }

    @Test
    void 예외_테스트_구매금액_단위() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ErrorMessage.PURCHASE_UNIT_EXCEPTION);
        });
    }

    @Test
    void 예외_테스트_당첨번호_타입() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,k,6");
            assertThat(output()).contains(ErrorMessage.LOTTO_TYPE_EXCEPTION);
        });
    }

    @Test
    void 예외_테스트_당첨번호_공백() {
        assertSimpleTest(() -> {
            runException("2000", "1, ,2,3,4,5,6");
            assertThat(output()).contains(ErrorMessage.LOTTO_TYPE_EXCEPTION);
        });
    }

    @Test
    void 예외_테스트_당첨번호_중복() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,2,3,4,5");
            assertThat(output()).contains(ErrorMessage.LOTTO_DUPLICATE_EXCEPTION);
        });
    }

    @Test
    void 예외_테스트_당첨번호_범위_45초과() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,55");
            assertThat(output()).contains(ErrorMessage.LOTTO_RANGE_EXCEPTION);
        });
    }

    @Test
    void 예외_테스트_당첨번호_범위_1미만() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,-2");
            assertThat(output()).contains(ErrorMessage.LOTTO_RANGE_EXCEPTION);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
