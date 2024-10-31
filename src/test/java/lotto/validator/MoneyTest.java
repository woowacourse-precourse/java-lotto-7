package lotto.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void int나_long_타입이_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> new Money("1000;").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 자연수로 입력해 주세요.");

        assertThatThrownBy(() -> new Money("1_000").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 자연수로 입력해 주세요.");

        assertThatThrownBy(() -> new Money("3.14159265").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 자연수로 입력해 주세요.");

        assertThatThrownBy(() -> new Money("20000000000L").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 자연수로 입력해 주세요.");
    }

    @Test
    void 로또1개_가격보다_돈이_적거나_1000원단위가_아니면_예외발생() {
        assertThatThrownBy(() -> new Money("500").isMultipleOfLottoPrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 최소 1000원부터 1000원 단위로 입력이 가능합니다.");

        assertThatThrownBy(() -> new Money("0").isMultipleOfLottoPrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 최소 1000원부터 1000원 단위로 입력이 가능합니다.");

        assertThatThrownBy(() -> new Money("-10000").isMultipleOfLottoPrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 최소 1000원부터 1000원 단위로 입력이 가능합니다.");

        assertThatThrownBy(() -> new Money("5050").isMultipleOfLottoPrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 최소 1000원부터 1000원 단위로 입력이 가능합니다.");
    }
}