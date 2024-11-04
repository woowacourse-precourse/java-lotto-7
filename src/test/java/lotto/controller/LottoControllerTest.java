package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PrizeRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    private LottoController controller;
    private LottoService service;

    @BeforeEach
    void setUp() {
        service = new LottoService();
        controller = new LottoController(service);
    }

    @DisplayName("로또 구매 금액이 유효하지 않으면 예외가 발생한다")
    @Test
    void validatePurchaseAmount() {
        assertThatThrownBy(() -> controller.purchaseLottos("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 유효하지 않으면 예외가 발생한다")
    @Test
    void validateWinningNumbers() {
        assertThatThrownBy(() -> controller.createWinningLotto("1,2,3,4,5", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 유효하지 않으면 예외가 발생한다")
    @Test
    void validateBonusNumber() {
        assertThatThrownBy(() -> controller.createWinningLotto("1,2,3,4,5,6", "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매와 당첨 확인이 정상적으로 동작한다")
    @Test
    void purchaseAndCheckLotto() {
        List<Lotto> lottos = controller.purchaseLottos("3000");
        assertThat(lottos).hasSize(3);

        WinningLotto winningLotto = controller.createWinningLotto("1,2,3,4,5,6", "7");
        Map<PrizeRank, Integer> result = controller.checkWinning(lottos, winningLotto);
        assertThat(result).isNotNull();
    }
}
