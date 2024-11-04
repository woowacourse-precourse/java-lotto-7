package lotto.policy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PolicyTest {

    @Test
    @DisplayName("로또 번호 스케일(6) 테스트")
    void 로또_번호_스케일(){
        //given
        int expectation = 6;
        //then
        int lottoNumberScale = LottoNumberPolicy.NUMBER_SCALE.number();
        //when
        assertThat(expectation).isEqualTo(lottoNumberScale);
    }

    @Test
    @DisplayName("로또 번호 최대값(45) 테스트")
    void 로또_번호_최대값(){
        //given
        int expectation = 45;
        //then
        int lottoMaxNumber = LottoNumberPolicy.MAX_NUMBER.number();
        //when
        assertThat(expectation).isEqualTo(lottoMaxNumber);
    }

    @Test
    @DisplayName("로또 번호 최소값(1) 테스트")
    void 로또_번호_최소값(){
        //given
        int expectation = 1;
        //then
        int lottoMaxNumber = LottoNumberPolicy.MIN_NUMBER.number();
        //when
        assertThat(expectation).isEqualTo(lottoMaxNumber);
    }

    @Test
    @DisplayName("로또 티켓값(1,000원) 테스트")
    void 로또_티켓값_테스트(){
        //given
        int expectation = 1000;
        //then
        int ticketPrice = LottoPricePolicy.LOTTO_TICKET_PRICE.price();
        //when
        assertThat(expectation).isEqualTo(ticketPrice);
    }
}