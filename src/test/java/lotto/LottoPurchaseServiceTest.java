package lotto;

import lotto.domain.model.ErrorMessages;
import lotto.domain.service.LottoPurchaseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoPurchaseServiceTest {

    private final LottoPurchaseService purchaseService = new LottoPurchaseService();

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> purchaseService.purchaseTickets(1500)
        );
        assert exception.getMessage().equals(ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 구입_금액이_음수일_경우_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> purchaseService.purchaseTickets(-1000)
        );
        assert exception.getMessage().equals(ErrorMessages.NEGATIVE_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 구입_금액이_1000원_미만일_경우_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> purchaseService.purchaseTickets(500)
        );
        assert exception.getMessage().equals(ErrorMessages.MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 구입_금액이_0일_경우_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> purchaseService.purchaseTickets(0)
        );
        assert exception.getMessage().equals(ErrorMessages.ZERO_PURCHASE_AMOUNT.getMessage());
    }
}
