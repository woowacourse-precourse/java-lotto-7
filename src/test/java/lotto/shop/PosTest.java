package lotto.shop;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.MessageCenter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PosTest {

    Pos pos = new Pos();

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000, 10000, 100000, 1000000})
    @DisplayName("구매장수는 입력한 금액을 1000원으로 나눈 값이다.")
    void 구매장수는_입력한_금액을_1000원으로_나눈_값이다(int money) {
        assertThat(pos.checkCount(money)).isEqualTo(money / 1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8000 ", " 8000", "  8000",
            "8000  ", " 8000 ", "     8000      "})
    @DisplayName("입력 금액 앞뒤로 공백이 있으면 자동으로 삭제된다.")
    void 입력_금액_앞뒤로_공백이_있으면_자동으로_삭제된다(String input) {
        assertThat(pos.parse(input)).isEqualTo(8000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10.000", "1000.000", "0",
            "-1", "-1000.000", "0.1000"})
    @DisplayName("입력 금액이 양의 정수가 아니면 예외가 발생한다.")
    void 입력_금액이_정수가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> pos.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_MONEY.get());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 금액이 비어있거나 NULL이면 예외가 발생한다.")
    void 입력_금액이_비어있거나_NULL이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> pos.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_MONEY.get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111", "0", "1",
            "2001", "8888", "12345", ""})
    @DisplayName("입력 금액이 1000으로 나뉘지 않으면 예외가 발생한다.")
    void 입력_금액이_1000으로_나뉘지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> pos.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_MONEY.get());
    }

}

