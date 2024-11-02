package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domains.customer.Customer;

public class CustomerTest {
	@DisplayName("Customer 클래스가 올바르게 생성된다.")
	@Test
	void Customer_클래스가_올바르게_생성된다() {
		assertThat(new Customer(3000)).isInstanceOf(Customer.class);
	}

	@DisplayName("올바른 로또 개수를 계산한다.")
	@Test
	void 올바른_로또_개수를_계산한다() {
		Customer customer = new Customer(3000);
		assertThat(customer.calculateAmount()).isEqualTo(3);
	}
}
