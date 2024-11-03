package lotto.model;

public class Customer {
    private Money budget;
    private final MyLotto myLotto;
    public Customer(Money budget, MyLotto myLotto) {
        this.budget = budget;
        this.myLotto = myLotto;
    }

}
