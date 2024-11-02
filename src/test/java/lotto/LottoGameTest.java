package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.global.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    private LottoGame lottoGame;
    private final LottoGenerateStrategy stubStrategy = () -> List.of(1, 2, 3, 4, 5, 6);

    @BeforeEach
    void setUp() {
        int userInput = 1000;
        lottoGame = new LottoGame(userInput, stubStrategy);
    }

    @DisplayName("생성자 테스트")
    @Test
    void construct() {
        Assertions.assertThat(lottoGame).isNotNull();
    }

    @DisplayName("사용자 입력 금액이 올바르지 않으면 예외가 발생한다")
    @Test
    void validation() {
        int invalidUserInput = 1001; // 1000 으로 떨어지지 않음
        assertThatThrownBy(() -> new LottoGame(invalidUserInput, stubStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
    }

    @DisplayName("수익률 계산에 성공한다")
    @Test
    void getEarningRate() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoGame customGame = new LottoGame(1000, () -> numbers);
        float earningRate = customGame.getEarningRate(numbers, 7);
        Assertions.assertThat(earningRate).isEqualTo(200_000_000.0f);
    }
}
