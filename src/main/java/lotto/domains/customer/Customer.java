package lotto.domains.customer;

public class Customer {
	private static final int LOTTO_COST = 1000;
	private final int money;

	private Customer(int money) {
		this.money = money;
	}

	public static Customer from(int money) {
		return new Customer(money);
	}

	public int calculateAmount() {
		return money / LOTTO_COST;
	}


	//당첨 계산 메소드
}
