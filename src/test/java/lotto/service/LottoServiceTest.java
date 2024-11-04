package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoWinnerPrize;
import lotto.model.PurchasedLotto;
import lotto.util.ErrorMessage;
import lotto.util.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(new InputValidator());
    }

    @DisplayName("구매 금액에 따라 로또 개수를 계산")
    @Test
    void calculateLottoQuantityTest() {
        int purchaseAmount = 5000;
        int expectedQuantity = 5;

        int actualQuantity = lottoService.calculateLottoQuantity(purchaseAmount);

        assertThat(actualQuantity).isEqualTo(expectedQuantity);
    }

    @DisplayName("구매한 로또를 생성")
    @Test
    void createPurchasedLottoTest() {
        int lottoQuantity = 3;

        PurchasedLotto purchasedLotto = lottoService.createPurchasedLotto(lottoQuantity);

        assertThat(purchasedLotto).isNotNull();
        assertThat(purchasedLotto.getLottos().size()).isEqualTo(lottoQuantity);
    }

    @DisplayName("당첨금과 구매금액에 따라 수익률을 계산")
    @Test
    void getRateOfReturnTest() {
        Map<LottoWinnerPrize, Integer> prizeCount = new HashMap<>();
        prizeCount.put(LottoWinnerPrize.FIRST_PRIZE, 1);
        int purchaseAmount = 10000;

        double rateOfReturn = lottoService.getRateOfReturn(prizeCount, purchaseAmount);

        assertThat(rateOfReturn).isGreaterThan(0);
    }

    @DisplayName("당첨 목록을 정렬하여 반환")
    @Test
    void getPrizeListTest() {
        Map<LottoWinnerPrize, Integer> prizeCount = new HashMap<>();
        prizeCount.put(LottoWinnerPrize.FIRST_PRIZE, 1);
        prizeCount.put(LottoWinnerPrize.SECOND_PRIZE, 2);

        List<LottoWinnerPrize> prizeList = lottoService.getPrizeList(prizeCount);

        assertThat(prizeList).isNotEmpty();
        assertThat(prizeList.getFirst()).isEqualTo(LottoWinnerPrize.SECOND_PRIZE);
    }

    @DisplayName("당첨 로또를 생성할 때 입력값이 유효한 경우 로또를 생성")
    @Test
    void createWinningLottoTest() {
        String winningNumbersInput = "1,2,3,4,5,6";
        Lotto winningLotto = lottoService.createWinningLotto(winningNumbersInput);

        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("구매 금액이 유효하지 않으면 예외가 발생")
    @Test
    void getPurchaseAmountInvalidInputTest() {
        String invalidPurchaseAmountInput = "invalidInput";

        assertThatThrownBy(() -> lottoService.getPurchaseAmount(invalidPurchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INPUT_TYPE_INT.getMessage());
    }

    @DisplayName("보너스 번호가 유효하지 않으면 예외가 발생")
    @Test
    void getBonusNumberInvalidInputTest() {
        String invalidBonusNumberInput = "invalidInput";

        assertThatThrownBy(() -> lottoService.getBonusNumber(invalidBonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INPUT_TYPE_INT.getMessage());
    }
}
