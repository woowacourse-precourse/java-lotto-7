package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoesTest {

    @DisplayName("로또 여러 장 생성 테스트")
    @Test
    void createLottoesTest() {
        //given
        Money money = Money.from("14000");

        //when
        Lottoes lottoes = Lottoes.from(money);

        //then
        assertThat(lottoes.getLottoes().size()).isEqualTo(14);
    }
}