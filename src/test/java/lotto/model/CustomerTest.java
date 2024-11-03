package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

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
}