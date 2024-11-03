package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputConverterTest {
    InputConverter inputConverter = new InputConverter();

    @Test
    void 입력한_금액만큼_로또매수_반환_테스트(){
        assertThat(inputConverter.purchaseAmount("12000")).isEqualTo(12);
        assertThat(inputConverter.purchaseAmount("99000")).isEqualTo(99);
    }

    @Test
    void 구매금액_단위로_입력하지_않은경우_예외발생(){
        assertThatThrownBy(()->inputConverter.purchaseAmount("12500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_형태의_입력이_아닌경우_예외가발생(){
        assertThatThrownBy(()->inputConverter.purchaseAmount("12S00"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->inputConverter.purchaseAmount("만원"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->inputConverter.purchaseAmount("1000.00"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매액이_로또보다_부족한경우_예외발생(){
        assertThatThrownBy(()->inputConverter.purchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->inputConverter.purchaseAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
