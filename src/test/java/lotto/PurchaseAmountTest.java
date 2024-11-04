package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Domain.LottoMachine;
import lotto.Domain.Lottos;
import lotto.Domain.PurchaseAmount;
import lotto.Messages.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void 구입_금액_입력값이_빈_문자열이면_예외처리(String input) {

        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    public void 구입_금액_입력값이_공백문자만_있으면_예외처리(String input) {

        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_PURCHASE_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1원", "1.0"})
    public void 구입_금액_입력값이_숫자아닌_문자가_있으면_예외처리(String input) {

        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    public void 구입_금액_입력값이_정수범위가_아니면_예외처리() {
        String input = String.valueOf(Integer.MAX_VALUE + 1L);

        assertThatThrownBy(() -> PurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INTEGER_OUT_PURCHASE_AMOUNT.getMessage());
    }


    @Test
    void 구입_금액이_충분하지_않으면_예외가_발생한다() {
        LottoMachine machine = LottoMachine.create();
        PurchaseAmount amount = PurchaseAmount.from("500");

        assertThatThrownBy(() -> machine.buyLottos(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 구입_금액으로_로또를_구매하면_해당_개수만큼_로또가_발행된다() {
        LottoMachine machine = LottoMachine.create();
        PurchaseAmount amount = PurchaseAmount.from("8000");

        Lottos lottos = machine.buyLottos(amount);

        assertThat(lottos.getLottosCount()).isEqualTo(8);
    }

}
