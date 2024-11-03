package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 구입금액이_숫자가_아닌_경우_예외() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("구입금액은 숫자");
        });
    }
    @Test
    void 구입금액이_1000_단위가_아닌_경우_예외() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("구입금액은 1000원 단위");
        });
    }
    @Test
    void 당첨번호가_숫자가_아닌_경우_예외() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,%,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("당첨 번호는 숫자");
        });
    }
    @Test
    void 당첨번호가_1_이상_45_이하의_숫자가_아닌_경우_예외() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("당첨 번호는 1부터 45 사이");
        });
    }
    @Test
    void 당첨번호가_6개가_아닌_경우_예외() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("당첨 번호는 6개");
        });
    }
    @Test
    void 당첨번호가_중복인_경우_예외() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("당첨 번호에는 중복");
        });
    }
    @Test
    void 보너스_번호가_1_이상_45_이하의_숫자가_아닌_경우_예외() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","46");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("보너스 번호는 1부터 45 사이");
        });
    }
    @Test
    void 보너스_번호가_숫자가_아닌_경우_예외() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","a");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains("보너스 번호는 숫자");
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
