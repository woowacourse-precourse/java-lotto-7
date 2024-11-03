package lotto.model.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.domain.Customer;
import lotto.model.domain.Lotto;

public class LottoRepository {

    private final Map<Integer, Customer> customers = new LinkedHashMap<>();
    private int idSequence = 1;

    public Customer saveCustomer(Customer customer) {
        customer.updateId(idSequence);
        customers.put(idSequence++, customer);
        return customer;
    }

    public int updateCustomerLottos(Integer customerId, List<Lotto> lottos) {
        Customer customer = findById(customerId);
        customer.getLottos().addAll(lottos);
        return 1;
    }

    public Customer findById(Integer id) {
        return customers.get(id);
    }
}
