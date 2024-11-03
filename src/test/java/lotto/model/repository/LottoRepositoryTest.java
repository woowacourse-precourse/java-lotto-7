package lotto.model.repository;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.domain.Customer;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {

    private final LottoRepository lottoRepository = new LottoRepository();

    @Test
    void Customer_저장_테스트() {
        // given
        Customer customer = new Customer("8000");

        // when
        Customer savedCustomer = lottoRepository.saveCustomer(customer);

        // then
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getPayment()).isEqualTo(8000);
    }

    @Test
    void Customer_조회_테스트() {
        // given
        Customer customer = new Customer("8000");
        lottoRepository.saveCustomer(customer);

        // when
        Customer foundCustomer = lottoRepository.findById(1);

        // then
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getPayment()).isEqualTo(8000);
    }
}
