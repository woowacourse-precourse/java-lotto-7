package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoPurchasePriceValidatorTest {

    private final LottoPurchasePriceValidator lottoPurchasePriceValidator;
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_LOTTO_PURCHASE_PRICE = 1_000;
    private static final int MAX_LOTTO_PURCHASE_PRICE = 1_000_000_000;

    public LottoPurchasePriceValidatorTest() {
        this.lottoPurchasePriceValidator =
                new LottoPurchasePriceValidator(LOTTO_PRICE, MIN_LOTTO_PURCHASE_PRICE, MAX_LOTTO_PURCHASE_PRICE);
    }

    @Test
    public void 로또_구입_금액이_숫자가_아니라면_예외가_발생한다() {
        String lottoPurchasePrice = "12[46";

        assertThatThrownBy(() -> lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_구입_금액이_로또_가격으로_나누어떨어지지_않는다면_예외가_발생한다() {
        String lottoPurchasePrice = "1001";

        assertThatThrownBy(() -> lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_구입_금액이_최소_구입_금액_미만이라면_예외가_발생한다() {
        String lottoPurchasePrice = "999";

        assertThatThrownBy(() -> lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_구입_금액이_최대_구입_금액_이상이라면_예외가_발생한다() {
        String lottoPurchasePrice = "1000000000";

        assertThatThrownBy(() -> lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_로또_구입_금액_테스트() {
        String lottoPurchasePrice = "3000";

        lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice);
    }

    @Test
    public void 인트_타입_이상의_큰_수가_들어오는_경우_예외가_발생한다() {
        String lottoPurchasePrice = "10000000000";

        assertThatThrownBy(() -> lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice))
                .isNotInstanceOf(NumberFormatException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
