package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoPurchaseMoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 구입금액이_1000원_미만이면_예외가_발생한다() {
        assertSimpleTest(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new LottoPurchaseMoney("500");
            });
            assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new LottoPurchaseMoney("1500");
            });
            assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액이_int_범위를_넘으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new LottoPurchaseMoney("2147483648"); // int 범위를 넘는 값
            });
            assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액이_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new LottoPurchaseMoney("abc");
            });
            assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액이_공백이면_예외가_발생한다() {
        assertSimpleTest(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new LottoPurchaseMoney("");
            });
            assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {}
}
