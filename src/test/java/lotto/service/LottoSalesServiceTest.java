package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSalesServiceTest {

    private final LottoSalesService lottoSalesService = new LottoSalesService();

    @DisplayName("주어진 개수에 맞게 로또를 발행한다.")
    @Test
    public void givenLottoQuantity_thenCreateLottos() {
        //given
        int quantity = 5;

        //when
        List<Lotto> lottos = lottoSalesService.createLottos(quantity);

        //then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @DisplayName("수량이 음수일 때 예외를 발생시킨다.")
    @Test
    public void givenNegativeQuantity_thenThrowException() {
        //given
        int negativeInputQuantity = -5;

        //then
        assertThrows(IllegalArgumentException.class,
            () -> lottoSalesService.createLottos(negativeInputQuantity));
    }

    @DisplayName("너무 큰 수량이 주어지면 예외를 발생시킨다.")
    @Test
    public void givenQuantityTooLarge_thenThrowException() {
        //given
        int epicQuantity = Integer.MAX_VALUE;

        //when & then
        assertThrows(IllegalArgumentException.class,
            () -> lottoSalesService.createLottos(epicQuantity));
    }

    @DisplayName("구매 금액이 주어지면 구매가능한 로또 수량을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "8000,8", "100_000_000,100_000"})
    public void givenPayment_whenCalculateAvailableQuantity_thenReturnQuantity(int payment, int expected) {
        //when
        int quantity = lottoSalesService.getAvailableLottoQuantity(payment);

        //then
        assertThat(quantity).isEqualTo(expected);
    }

    @DisplayName("구매금액이 음수이면 예외를 발생시킨다.")
    @Test
    public void givenInvalidPayment_thenThrowException() {
        //given
        int payment = -1000;

        //when & then
        assertThrows(IllegalArgumentException.class,
            () -> lottoSalesService.getAvailableLottoQuantity(payment));
    }

    @DisplayName("구매금액이 1000원 단위가 아니라면 예외를 발생시킨다.")
    @RepeatedTest(value = 4, name = "구매 금액 : 1{currentRepetition}00원")
    public void shouldThrowException_whenPaymentIsNotInThousands(RepetitionInfo repetition) {
        //given
        int payment = 1000 + repetition.getCurrentRepetition();

        //when & then
        assertThrows(IllegalArgumentException.class,
            () -> lottoSalesService.getAvailableLottoQuantity(payment));
    }
}