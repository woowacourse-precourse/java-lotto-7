package lotto.model.service;

import lotto.model.domain.Customer;
import lotto.model.repository.LottoRepository;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
    }

    public Integer savePayment(String payment) {
        Customer customer = new Customer(payment);
        lottoRepository.saveCustomer(customer);
        return customer.getId();
    }
}
