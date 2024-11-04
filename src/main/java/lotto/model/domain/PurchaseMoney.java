package lotto.model.domain;

public record PurchaseMoney(int money) {
	private static final int MINIMUM_MONEY_SIZE = 1000;
	private static final int REMAIN_OF_DIVIDE_MONEY = 0;

	public PurchaseMoney {
		validate(money);
	}

	private void validate(int money) {
		moreThanThousand(money);
		divideThousand(money);
	}

	private void moreThanThousand(int input) {
		if (input < MINIMUM_MONEY_SIZE) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
		}
	}

	private void divideThousand(int input) {
		if (input % MINIMUM_MONEY_SIZE != REMAIN_OF_DIVIDE_MONEY) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
		}
	}

	public int getLottoCount() {
		return money / MINIMUM_MONEY_SIZE;
	}
}
