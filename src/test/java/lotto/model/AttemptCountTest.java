package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCountTest {

    @ParameterizedTest
    @DisplayName("구입 금액이 1000의 배수일 경우 AttemptCount 객체가 정상적으로 생성된다.")
    @ValueSource(ints = {1000, 2000, 3000, 5000})
    void createAttemptCountSuccessfully(int purchaseAmount) {
        // when
        AttemptCount attemptCount = AttemptCount.from(purchaseAmount);

        // then
        assertThat(attemptCount.getCount()).isEqualTo(purchaseAmount / 1000);
    }

    @ParameterizedTest
    @DisplayName("구입 금액이 1000의 배수가 아닐 경우 예외를 발생시킨다.")
    @ValueSource(ints = {500, 1500, 2500, 3333})
    void throwExceptionWhenPurchaseAmountIsNotThousandMultiple(int invalidAmount) {
        // when & then
        assertThatThrownBy(() -> AttemptCount.from(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.THOUSAND_UNIT.message());
    }
}
