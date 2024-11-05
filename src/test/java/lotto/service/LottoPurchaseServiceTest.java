package lotto.service;

import lotto.enums.ExceptionMessage;
import lotto.model.LottoMachine;
import lotto.model.LottoTicket;
import lotto.validator.AmountValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoPurchaseServiceTest {
    private AmountValidator amountValidator;
    private LottoMachine lottoMachine;
    private LottoPurchaseService lottoPurchaseService;
    @BeforeEach
    void setup(){
        amountValidator = new AmountValidator();
        lottoMachine = new LottoMachine();
        lottoPurchaseService = new LottoPurchaseService(amountValidator,lottoMachine);
    }

    @DisplayName("올바른 로또 구매 케이스")
    @Test
    void purchaseLotto_success(){
        String input = "2000";
        int expectedTicket = 2;

        LottoTicket lottoTicket = lottoPurchaseService.purchaseLotto(input);

        assertThat(expectedTicket).isEqualTo(2);
        assertThat(lottoTicket.getPurchase()).isEqualTo(2000);

    }

    @DisplayName("잘못된 금액으로 로또 구매 시 , 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "900"})
    void purchaseLotto_wrong_amount_throwsException(String input){

        assertThatThrownBy(() -> lottoPurchaseService.purchaseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
    }




}