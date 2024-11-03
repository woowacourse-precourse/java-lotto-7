package lotto.domain.purchase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserMoneyTest {
    @DisplayName("spend시 값을 뺀 새로운 객체를 생성하는지 확인")
    @Test
    void testSpend() {
        UserMoney userMoney = new UserMoney(1000);
        UserMoney after = userMoney.spend(300);

        assertThat(after.getValue()).isEqualTo(700);
    }

    @DisplayName("earn시 값을 더한 새로운 객체를 생성하는지 확인")
    @Test
    void testEarn() {
        UserMoney userMoney = new UserMoney(1000);
        UserMoney after = userMoney.earn(300);

        assertThat(after.getValue()).isEqualTo(1300);
    }

    @DisplayName("다른 객체와의 값의 비율을 반환하는지 확인")
    @Test
    void testCalculateRatioTo() {
        UserMoney divisor = new UserMoney(8000);
        UserMoney dividend = new UserMoney(5000);
        float expected = 0.625f;

        float actual = divisor.calculateRatioTo(dividend);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("로또 구매 가능한 최고 금액의 UserMoney를 반환하는지 확인")
    @Test
    void testGetMaxSpendAvailable() {
        UserMoney userMoney = new UserMoney(8010);
        UserMoney expected = new UserMoney(8000);

        UserMoney actual = userMoney.getMaxSpendAvailable();

        assertThat(actual.getValue()).isEqualTo(expected.getValue());
    }
}