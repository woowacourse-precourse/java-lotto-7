package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoConstantTest {
    @DisplayName("로또 상수의 정수값이 일치한다.")
    @Test
    void 로또_상수의_정수값이_일치한다() {
        assertThat(LottoConstant.LOTTO_PURCHASE_AMOUNT.getIntValue()).isEqualTo(1000);
        assertThat(LottoConstant.LOTTO_SIZE.getIntValue()).isEqualTo(6);
        assertThat(LottoConstant.MIN_NUMBER.getIntValue()).isEqualTo(1);
        assertThat(LottoConstant.MAX_NUMBER.getIntValue()).isEqualTo(45);
    }

    @DisplayName("로또 상수의 문자열값이 일치한다.")
    @Test
    void 로또_상수의_문자열값이_일치한다() {
        assertThat(LottoConstant.LOTTO_PURCHASE_AMOUNT.getValue()).isEqualTo("1000");
        assertThat(LottoConstant.LOTTO_SIZE.getValue()).isEqualTo("6");
        assertThat(LottoConstant.MIN_NUMBER.getValue()).isEqualTo("1");
        assertThat(LottoConstant.MAX_NUMBER.getValue()).isEqualTo("45");
        assertThat(LottoConstant.DELIMITER.getValue()).isEqualTo(",");
    }
}
