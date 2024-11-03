package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoVendor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoVendorTest {

    @DisplayName("금액을 받으면 해당하는 만큼 로또를 발행한다")
    @Test
    void issue() throws Exception{
        //given
        int amount = 10000;
        int lottoPrice = 1000;
        LottoVendor vendor = new LottoVendor();
        //when
        List<Lotto> lotto = vendor.issue(amount);
        //then
        assertThat(lotto.size()).isEqualTo(amount / lottoPrice);
     }
     
     @DisplayName("금액이 천원단위가 아니면 예외를 발생한다")
     @Test
     void amount_in_thousand() throws Exception{
         //given
         int amount = 1500;
         LottoVendor vendor = new LottoVendor();

         //when & then
         assertThatThrownBy(() -> vendor.issue(amount))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessage("금액은 천원단위여야 합니다.");
      }
     
}
