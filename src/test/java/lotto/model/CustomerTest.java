package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    @DisplayName("Customer 객체를 생성할 수 있다.")
    void should_CreateCustomer() {
        // given
        Money budget = new Money("8000");
        MyLotto myLotto = new MyLotto(null);
        //when
        Customer customer = new Customer(budget, myLotto);
        //then
        Assertions.assertThat(customer).isNotNull();
    }

    @Test
    @DisplayName("고객은 로또를 구매할 수 있다.")
    void should_BuyLotto() {
        // given
        Money budget = new Money("8000");
        MyLotto myLotto = new MyLotto(new ArrayList<>());
        Customer customer = new Customer(budget, myLotto);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        // when
        customer.buyLotto(lottos);
        // then
        Assertions.assertThat(myLotto.getLottos()).hasSize(1);
    }
}