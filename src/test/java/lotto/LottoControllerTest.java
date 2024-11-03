package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import lotto.controller.LottoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoControllerTest {

    private LottoController lottoController;
    private LottoManager lottoManager;

    @BeforeEach
    public void setUp() {
        lottoManager = new LottoManager();
        lottoController = new LottoController();
    }

    @DisplayName("유효한 입력으로 실행하면 성공해야 한다")
    @Test
    public void 유효한_입력으로_실행하면_성공해야_한다() {
        // Given
        int buyPrice = 5000;
        Money money = new Money(buyPrice);
        lottoManager.buyLotto(money);
        List<Lotto> lottoTickets = lottoManager.getLottoTickets();

        // Then
        assertEquals(5, lottoTickets.size(), "구매한 로또 개수가 잘못되었습니다.");
    }

    @DisplayName("잘못된 입력으로 예외를 처리해야 한다")
    @Test
    public void 잘못된_입력으로_예외를_처리해야_한다() {
        // Given
        int invalidBuyPrice = -5000;

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(invalidBuyPrice);
        });
    }
}
