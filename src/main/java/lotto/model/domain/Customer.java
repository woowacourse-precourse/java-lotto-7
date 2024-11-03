package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final List<Lotto> lottos;
    private Integer id;
    private Integer payment;
    private Integer revenue;

    public Customer(String payment) {
        this.payment = Integer.parseInt(payment);
        this.revenue = 0;
        lottos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void updateId(Integer id) {
        this.id = id;
    }

    public Integer getPayment() {
        return payment;
    }

    public void updatePayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void updateRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
