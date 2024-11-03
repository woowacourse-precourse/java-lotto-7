package lotto;

import lotto.Domain.GameInfo;
import lotto.Service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Constants.Error;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @ParameterizedTest
    @DisplayName("generateLotto 메서드 insufficientFunds 테스트")
    @ValueSource(ints = {1000, 2000})
    public void generateLotto_InsufficientFunds_테스트(int purchaseAmount) {
        assertThatThrownBy(() -> {
            GameInfo gameInfo = new GameInfo(purchaseAmount);
            while (true) {
                lottoService.generateLotto(gameInfo);
            }
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(Error.LACK_OF_FUNDS.getText());
    }

    @ParameterizedTest
    @DisplayName("generateLotto 기능테스트. generateLotto 가 remainingLottoAmount 를 1씩 줄이는지 체크")
    @ValueSource(ints = {1000, 2000, 3000})
    public void generateLotto_기능_테스트(int purchaseAmount) {
        assertSimpleTest(() -> {
            GameInfo gameInfo = new GameInfo(purchaseAmount);
            lottoService.generateLotto(gameInfo);
            assertThat(gameInfo.getRemainingLottoAmount()).isEqualTo(purchaseAmount / GameInfo.LOTTO_PRICE - 1);
        });
    }
}
