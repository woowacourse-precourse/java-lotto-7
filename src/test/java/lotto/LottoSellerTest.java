package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoSellerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    @Test
    void 로또_금액_정상동작() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("8000");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
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
    void 로또_금액이_숫자가_아니면_에러_출력_후_재입력받는다() {
        assertSimpleTest(() -> {
            runException("8000a", "8000");
            assertThat(output())
                    .contains(ERROR_MESSAGE + "로또 금액은 숫자여야 합니다.");
        });
    }

    @Test
    void 로또_금액이_양수가_아니면_에러_출력_후_재입력받는다() {
        assertSimpleTest(() -> {
            runException("-8000", "8000");
            assertThat(output())
                    .contains(ERROR_MESSAGE + "로또 금액은 양수여야 합니다.");
        });
    }

    @Test
    void 로또_금액이_1000원으로_나누어_떨어지지_않으면_에러_출력_후_재입력받는다() {
        assertSimpleTest(() -> {
            runException("8500", "8000");
            assertThat(output())
                    .contains(ERROR_MESSAGE + "로또 금액은 1000원을 단위로 입력해야 합니다.");
        });
    }

    @Test
    void 로또_당첨_번호_정상동작() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6");
            assertThat(output())
                    .doesNotContain(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_당첨_번호_입력에_다른_문자가_포함되면_에러_출력_후_재입력받는다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2, ,4,5,6", "1,2,3,4,5,6");
            assertThat(output())
                    .contains(ERROR_MESSAGE + "숫자와 콤마(,)를 제외한 문자는 입력할 수 없습니다.");
        });
    }

    @Override
    public void runMain() {
        LottoSeller lottoSeller = new LottoSeller();
        lottoSeller.run();
    }
}