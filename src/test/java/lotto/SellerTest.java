package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.Person;
import lotto.domain.Seller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class SellerTest {
    
    @Test
    @DisplayName("금액에 맞는 로또 개수를 구매한다")
    void sellLotto() {
        //given
        Money money = new Money(5000);
        Seller seller = new Seller(new LottoMachine());
        Person person = new Person(money);

        //when
        seller.sellLottoTo(person);

        //then
        assertThat(person.getLottos().getQuantity()).isSameAs(5);
    }
}