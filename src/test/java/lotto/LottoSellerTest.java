package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class LottoSellerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    @Test
    void 로또_금액이_숫자가_아니면_에러_출력_후_재입력받는다() {
        assertSimpleTest(() -> {
            run("8000a", "8000");
            assertThat(output())
                    .contains(ERROR_MESSAGE + "로또 금액은 숫자여야 합니다.");
        });
    }

    @Test
    void 로또_금액이_양수가_아니면_에러_출력_후_재입력받는다() {
        assertSimpleTest(() -> {
            run("-8000", "8000");
            assertThat(output())
                    .contains(ERROR_MESSAGE + "로또 금액은 양수여야 합니다.");
        });
    }

    @Test
    void 로또_금액이_1000원으로_나누어_떨어지지_않으면_에러_출력_후_재입력받는다() {
        assertSimpleTest(() -> {
            run("8500", "8000");
            assertThat(output())
                    .contains(ERROR_MESSAGE + "로또 금액은 1000원을 단위로 입력해야 합니다.");
        });
    }

    @Override
    public void runMain() {
        LottoSeller lottoSeller = new LottoSeller();
        lottoSeller.run();
    }
}