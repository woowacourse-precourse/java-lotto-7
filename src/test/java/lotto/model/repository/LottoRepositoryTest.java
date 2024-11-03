package lotto.model.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.domain.Customer;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {

    private final LottoRepository lottoRepository = new LottoRepository();

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("8000");
    }

    @Test
    void Customer_저장_테스트() {
        // given

        // when
        Customer savedCustomer = lottoRepository.saveCustomer(customer);

        // then
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getPayment()).isEqualTo(8000);
    }

    @Test
    void Customer_조회_테스트() {
        // given
        lottoRepository.saveCustomer(customer);

        // when
        Customer foundCustomer = lottoRepository.findById(1);

        // then
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getPayment()).isEqualTo(8000);
    }

    @Test
    void Customer_로또_추가_테스트() {
        // given
        lottoRepository.saveCustomer(customer);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        // when
        int result = lottoRepository.updateCustomerLottos(1, List.of(lotto1, lotto2));

        // then
        assertThat(result).isEqualTo(1);
        assertThat(customer.getLottos()).hasSize(2);
        assertThat(customer.getLottos()).containsExactlyInAnyOrder(lotto1, lotto2);
    }
}
