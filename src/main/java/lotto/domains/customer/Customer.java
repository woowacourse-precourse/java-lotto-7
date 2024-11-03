package lotto.domains.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domains.lotto.domain.LottoPrizeNumbers;
import lotto.domains.lotto.domain.LottoTicket;
import lotto.exception.ExceptionMessage;

public class Customer {
	private static final int LOTTO_COST = 1000;
	private static final int BONUS_COUNT = 1;
	private static final int FOUR_MATCH = 4;
	private final int money;

	private Customer(int money) {
		validate(money);
		this.money = money;
	}

	public static Customer from(int money) {
		return new Customer(money);
	}

	public int calculateAmount() {
		return money / LOTTO_COST;
	}

	public Map<Integer, Boolean> checkWinningStatus(LottoTicket lottoTickets,
		LottoPrizeNumbers lottoPrizeNumbers) {
		Map<Integer, Boolean> matchingCount = new HashMap<>();
		lottoTickets.getTickets().forEach(ticket -> {
			int count = (int)ticket.getNumbers().stream()
				.filter(lottoPrizeNumbers.getWinningNumbers()::contains).count();
			if (count == FOUR_MATCH && ticket.getNumbers().contains(lottoPrizeNumbers.getBonusNumber())) {
				matchingCount.put(count + BONUS_COUNT, true);
				return;
			}
			matchingCount.put(count, false);
		});
		return matchingCount;
	}

	private void validate(int money) {
		if (money < LOTTO_COST) {
			throw new IllegalArgumentException(ExceptionMessage.LOWER_THAN_MINIMUM_LOTTO_PRICE.toString());
		}
	}
}
