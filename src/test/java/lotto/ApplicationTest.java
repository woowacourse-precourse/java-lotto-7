package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 로또를_구매하고_당첨번호와_보너스번호를_통해_로또통계를_낸다() {
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
    void 구입금액에_문자가_들어가면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 구입금액이_1000보다_작으면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("999");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 구입금액이_100000보다_크면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("100001");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 구입금액이_1000단위가_아니면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 당첨번호에_1보다_작은_숫자가_있으면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("3000", "0,2,3,4,5,6");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 당첨번호에_45보다_큰_숫자가_있으면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("3000", "46,2,3,4,5,6");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 당첨번호에_중복이_있으면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("3000", "1,1,3,4,5,6");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 보너스번호가_1보다_작으면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 보너스번호가_15보다_크면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외메시지가_출력된다() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 잘못된_값을_10번_입력하면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(
                    "1000j", "1000j", "1000j", "1000j", "1000j",
                    "1000j", "1000j", "1000j", "1000j", "1000j"))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("최대 시도 횟수를 초과했습니다.");

            assertThat(output()).contains("최대 시도 횟수를 초과했습니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
