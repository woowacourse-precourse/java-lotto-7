package lotto.model;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    @DisplayName("판매자는 로또를 판매할 수 있다.")
    void should_SellLotto_When_GivenCustomer() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator(() ->
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Seller seller = new Seller(lottoGenerator);

        Customer customer = new Customer(new Money("1000"),
                     new MyLotto(new ArrayList<>()));

        AnswerNumbers answer = AnswerNumbers.from("1,2,3,4,5,6");
        BonusNumber bonus = new BonusNumber("7");
        //when
        seller.sellTo(customer);
        float earningRate = customer.getEarningRate(answer, bonus);
        //then
        Assertions.assertThat(earningRate).isEqualTo(2000000.0f);
    }
}