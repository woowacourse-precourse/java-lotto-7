package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @DisplayName("돈 1,000원 당 로또 티켓 1개로 교환할 수 있다.")
    @ParameterizedTest
    @CsvSource({"1000, 1", "2000, 2"})
    void 돈_티켓_교환_테스트(int amount, int expected) {
        Money money = new Money(amount);
        assertThat(money.getTicket()).isEqualTo(expected);
    }

    @DisplayName("돈을 추가한 만큼 earnedMoney가 증가한다.")
    @ParameterizedTest
    @CsvSource({"1000, 1000"})
    void 돈_수익_테스트(int amount, int expected) {
        Money money = new Money();
        money.addMoney(amount);
        assertThat(money.getEarnedMoney()).isEqualTo(expected);
    }

    @DisplayName("돈을 사용한 만큼 spentMoney가 증가한다.")
    @ParameterizedTest
    @CsvSource({"1000, 1000"})
    void 돈_사용_테스트(int amount, int expected) {
        Money money = new Money(amount);
        money.getTicket();
        assertThat(money.getSpentMoney()).isEqualTo(expected);
    }
}
