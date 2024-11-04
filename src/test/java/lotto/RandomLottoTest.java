package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomLottoTest {
    @DisplayName("1000으로 나누어 떨어지지 않는 값이 주어졌을때 예외가 발생한다.")
    @Test
    void moneyTest() {
        RandomLotto randomLotto = RandomLotto.getInstance();
        assertThatThrownBy(() -> randomLotto.countCalculator(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
