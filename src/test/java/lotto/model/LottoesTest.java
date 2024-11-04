package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoesTest {
    @DisplayName("생성된 로또들 size getter 성공")
    @Test
    void 생성된_로또들_size_getter_성공(){
        //given
        PriceToBuyLotto priceToBuyLotto = PriceToBuyLotto.of("1000");
        Lottoes lottoes = new Lottoes(priceToBuyLotto);
        //when
        //then
        assertEquals(1, lottoes.getLottoesCount());
    }
}
