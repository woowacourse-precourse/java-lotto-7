package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosCreatorTest {
    @Test
    void Lottos생성테스트() {
        // given
        Money money = new Money("8000");
        LottosCreator lottosCreator = new LottosCreator();

        // when
        System.out.println("=====Logic Start=====");

        Lottos lottos = lottosCreator.createLottos(money);

        System.out.println("=====Logic End=====");
        // then
        assertThat(lottos.getBuyLottoQuantity()).isEqualTo(8);
    }
}