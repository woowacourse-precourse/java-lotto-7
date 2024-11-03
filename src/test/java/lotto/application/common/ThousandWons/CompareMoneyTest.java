package lotto.application.common.ThousandWons;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ThousandWons - 목표 금액 비교")
public class CompareMoneyTest {


    @DisplayName("목표 금액보다 크거나 같으면 true 반환")
    @ParameterizedTest
    @ValueSource(ints = {3000, 5000})
    void 목표금액보다_크거나_같으면_true(int underOrEqualMoney) {
        // given
        ThousandWons money = ThousandWons.of("5000");

        // expect
        Assertions.assertThat(money.isMuchThanOrEqual(underOrEqualMoney)).isTrue();
        Assertions.assertThat(money.isMuchThanOrEqual(underOrEqualMoney)).isTrue();
    }

    @DisplayName("목표 금액보다 작으면 false 반환")
    @ParameterizedTest
    @ValueSource(ints = {6000, 10000})
    void 목표금액보다_작으면_false(int exceededMoney) {
        // given
        ThousandWons money = ThousandWons.of("5000");

        // expect
        Assertions.assertThat(money.isMuchThanOrEqual(exceededMoney)).isFalse();
    }

}
