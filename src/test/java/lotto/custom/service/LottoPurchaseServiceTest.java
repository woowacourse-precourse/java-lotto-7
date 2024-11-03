package lotto.custom.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.custom.common.ErrorMessages;
import lotto.custom.validator.CustomErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseServiceTest {
    private final LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

    @DisplayName("서비스_구입금액입력_NULL일때_테스트")
    @Test
    void 서비스_구입금액입력_NULL일때_테스트() {
        assertThatThrownBy(() -> lottoPurchaseService.run(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.NULL_INPUT);
    }

    @DisplayName("서비스_구입금액입력_빈문자열일때_테스트")
    @Test
    void 서비스_구입금액입력_빈문자열일때_테스트() {
        assertThatThrownBy(() -> lottoPurchaseService.run(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.EMPTY_STRING_INPUT);
    }

    @DisplayName("서비스_구입금액입력_공백으로구성되어있을때_테스트")
    @Test
    void 서비스_구입금액입력_공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> lottoPurchaseService.run("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.WHITESPACE_ONLY_INPUT);
    }

    @DisplayName("서비스_구입금액입력_숫자와공백외의문자가있을때_테스트")
    @Test
    void 서비스_구입금액입력_숫자와공백외의문자가있을때_테스트() {
        assertThatThrownBy(() -> lottoPurchaseService.run("123#5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.INVALID_CHARACTERS_INPUT);
    }

    @DisplayName("서비스_구입금액입력_숫자와숫자사이에공백이있을때_테스트")
    @Test
    void 서비스_구입금액입력_숫자와숫자사이에공백이있을때_테스트() {
        assertThatThrownBy(() -> lottoPurchaseService.run("300 00"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.SPACES_BETWEEN_NUMBERS);
    }

    @DisplayName("서비스_구입금액입력_int타입의범위를벗어날때_테스트")
    @Test
    void 서비스_구입금액입력_int타입의범위를벗어날때_테스트() {
        assertThatThrownBy(() -> lottoPurchaseService.run("2147483648")) // Integer.MAX_VALUE + 1
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.INT_OUT_OF_BOUNDS);
    }

    @DisplayName("서비스_구입금액입력_1000원으로나누어떨어지지않을때_테스트")
    @Test
    void 서비스_구입금액입력_1000원으로나누어떨어지지않을때_테스트() {
        assertThatThrownBy(() -> lottoPurchaseService.run("5400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.NOT_DIVISIBLE_BY_THOUSAND);
    }
}
