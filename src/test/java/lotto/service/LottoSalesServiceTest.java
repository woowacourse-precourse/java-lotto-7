package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}