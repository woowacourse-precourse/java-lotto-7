package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoFactoryTest {
    @DisplayName("가격만큼 로또 생성 성공")
    @Test
    void 가격만큼_로또_생성_성공() {
        //given
        PriceToBuyLotto priceToBuyLotto = PriceToBuyLotto.of("5000");

        //when
        List<Lotto> lottoes = LottoFactory.drawLottoesByPrice(priceToBuyLotto);

        //then
        assertEquals(lottoes.size(), 5);
    }
}
