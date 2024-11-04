package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "9");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 9]",
                            "[17, 18, 19, 20, 21, 22]",
                            "[10, 11, 12, 13, 14, 15]",
                            "[31, 32, 33, 34, 35, 36]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 750,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 9),
                List.of(17, 18, 19, 20, 21, 22),
                List.of(10, 11, 12, 13, 14, 15),
                List.of(31, 32, 33, 34, 35, 36)
        );
    }
    @Test
    void 수익률_표기법_0일_경우_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[11, 12, 13, 14, 15, 19]",
                            "[17, 18, 19, 20, 21, 22]",
                            "[10, 11, 12, 13, 14, 15]",
                            "[31, 32, 33, 34, 35, 36]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(11, 12, 13, 14, 15, 19),
                List.of(17, 18, 19, 20, 21, 22),
                List.of(10, 11, 12, 13, 14, 15),
                List.of(31, 32, 33, 34, 35, 36)
        );
    }

    @Test
    void 오름차순_정렬_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "9");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 9]",
                            "[17, 18, 19, 20, 21, 22]",
                            "[10, 11, 12, 13, 14, 15]",
                            "[31, 32, 33, 34, 35, 36]"
                    );
                },
                List.of(1, 3, 2, 9, 5, 4),
                List.of(22, 18, 19, 21, 20, 17),
                List.of(10, 11, 12, 15, 14, 13),
                List.of(31, 32, 33, 34, 35, 36)
        );
    }

    @Test
    void 구입_금액_1000단위로_나누어_떨어지지_않는_경우() {
        assertSimpleTest(() -> {
            runException("4900");
            assertThat(output()).contains("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.");
        });
    }

    @Test
    void 구입_금액_숫자가_아닌_경우() {
        assertSimpleTest(() -> {
            runException("donghan");
            assertThat(output()).contains("[ERROR] 정수를 입력하세요.");
        });
    }

    @Test
    void 당첨_번호가_숫자가_아닌_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,dong,5,6");
            assertThat(output()).contains("[ERROR] 정수를 입력하세요.");
        });
    }

    @Test
    void 당첨_번호_숫자가_6개가_아닌_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,5,6");
            assertThat(output()).contains("[ERROR] 당첨 번호는 6자리여야 합니다.");
        });
    }

    @Test
    void 당첨_번호_숫자가_중복되는_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,3,5,6");
            assertThat(output()).contains("[ERROR] 중복된 수가 존재합니다.");
        });
    }

    @Test
    void 당첨_번호_숫자가_1_45_이내의_숫자가_아닌_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,99,3,5,6");
            assertThat(output()).contains("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    void 보너스_번호가_숫자가_아닌_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "donghan");
            assertThat(output()).contains("[ERROR] 보너스 번호는 1자리 정수여야 합니다.");
        });
    }

    @Test
    void 보너스_번호가_하나가_아닌_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "10,11");
            assertThat(output()).contains("[ERROR] 보너스 번호는 1자리 정수여야 합니다.");
        });
    }

    @Test
    void 보너스_번호가_1_45_이내의_숫자가_아닌_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "99");
            assertThat(output()).contains("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되는_경우() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "5");
            assertThat(output()).contains("[ERROR] 당첨 번호와 중복되지 않아야 합니다.");
        });
    }

    @Override
    public void runMain() { Application.main(new String[]{}); }
}
