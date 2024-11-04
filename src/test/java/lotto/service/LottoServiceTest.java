package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구매 가격에 따라 맞는 개수의 로또를 발행한다.")
    void testGenerateLottoForGivenPurchasePrice() {
        int count = 5;
        int price = Rule.LOTTO_PRICE * count;
        PurchasePrice purchasePrice = new PurchasePrice(price);

        LottoTickets lottoTickets = lottoService.generateLottoTickets(purchasePrice);

        assertThat(lottoTickets.tickets().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("입력한 당첨 번호를 가진 당첨번호 로또 객체를 반환한다.")
    void testReturnLottoIfInputIsValid() {
        String input = "1,2,3,4,5,6";
        Lotto mainNumbers = lottoService.createMainNumbers(input);
        assertThat(mainNumbers.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    void testThrowExceptionIfInputIsNotNumber() {
        String input = "1,2,3,4,5,a";
        assertThatThrownBy(() -> lottoService.createMainNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_NON_DIGIT_CHARACTER.getMessage());
    }
}
