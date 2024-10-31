package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.global.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoProviderTest {
    @Test
    void construct() {
        int userInput = 1000_00;
        LottoProvider lottoProvider = new LottoProvider(userInput);
        Assertions.assertThat(lottoProvider).isNotNull();
    }

    @Test
    void validation() {
        int userInput = 1001; // 1000 으로 떨어지지 않음
        assertThatThrownBy(() -> new LottoProvider(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
    }

    @Test
    void generateLottos() {
        int userInput = 1000; // 1 회 시행
        LottoProvider lottoProvider = new LottoProvider(userInput);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = lottoProvider.generateLottos(() -> numbers);
        Assertions.assertThat(lottos)
                .hasSize(1)
                .containsExactly(new Lotto(numbers));
    }
}
