package lotto.domain;

import lotto.message.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @DisplayName("천 단위로 입력된 금액이면 money 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 3_000, 4_000, 5_000, 100_000, 100_000_000})
    void createThousandUnitMoneyByThousandUnit(int thousandUnit) {
        Assertions.assertThat(new Money(thousandUnit))
            .isInstanceOf(Money.class);
    }

    @DisplayName("천 단위로 입력된 금액이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_001, 2_021, 2_020, 3_400, 4_530, 5_431, 100_100_100, 100_100_001})
    void createThousandUnitMoneyByNotThousandUnit(int notThousandUnit) {
        Assertions.assertThatThrownBy(() -> new Money(notThousandUnit))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ExceptionMessage.INVALID_UNIT);
    }
}