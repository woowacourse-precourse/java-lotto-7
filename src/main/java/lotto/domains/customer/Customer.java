package lotto.domains.customer;

public class Customer {
	private static final int LOTTO_COST = 1000;
	private final int money;

	public Customer(int money) {
		this.money = money;
	}

	public int calculateAmount(int money) {
		return money / LOTTO_COST;
	}

	//당첨 계산 메소드
}
