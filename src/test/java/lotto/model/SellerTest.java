package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SellerTest {
    @Test
    @DisplayName("Seller 객체를 생성할 수 있다.")
    void should_CreateSeller_When_GivenLottoGenerator() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());
        //when
        Seller seller = new Seller(lottoGenerator);
        //then
        Assertions.assertThat(seller).isNotNull();
    }

}