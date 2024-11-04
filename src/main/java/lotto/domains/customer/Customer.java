package lotto.domains.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domains.lotto.domain.LottoPrizeNumbers;
import lotto.domains.lotto.domain.LottoTicket;
import lotto.domains.lotto.type.LottoPrize;
import lotto.exception.ExceptionMessage;
import lotto.view.OutputInterface;

public class Customer {
	private static final int LOTTO_COST = 1000;
	private static final int BONUS_COUNT = 1;
	private static final int FOUR_MATCH = 4;

	private final int money;
	private long prize;
	private double profit;

	private Customer(int money) {
		validate(money);
		this.money = money;
		this.prize = 0;
	}

	public static Customer from(int money) {
		return new Customer(money);
	}

	public int calculateAmount() {
		return money / LOTTO_COST;
	}

	public String formattingForPrintProfit() {
		return String.format(OutputInterface.PROFIT_INFORMATION.toString(), profit);
	}

	public void calculateProfit(Map<LottoPrize, Integer> lottoResult) {
		prize += lottoResult.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
			.sum();
		this.profit = (double)prize / (double)money * 100;
	}

	public List<Map<Integer, Boolean>> checkWinningStatus(LottoTicket lottoTickets,
		LottoPrizeNumbers lottoPrizeNumbers) {
		List<Map<Integer, Boolean>> matchingCount = new ArrayList<>();
		lottoTickets.getTickets().forEach(ticket -> {
			int count = (int)ticket.getNumbers().stream()
				.filter(lottoPrizeNumbers.getWinningNumbers()::contains).count();

			Map<Integer, Boolean> countAndHasBonus = new HashMap<>();
			if (count == FOUR_MATCH && ticket.getNumbers().contains(lottoPrizeNumbers.getBonusNumber())) {
				countAndHasBonus.put(count + BONUS_COUNT, true);
				matchingCount.add(countAndHasBonus);
				return;
			}
			countAndHasBonus.put(count, false);
			matchingCount.add(countAndHasBonus);
		});
		return matchingCount;
	}

	private static void validate(int money) {
		if (money < LOTTO_COST) {
			throw new IllegalArgumentException(ExceptionMessage.LOWER_THAN_MINIMUM_LOTTO_PRICE.toString());
		}
	}
}
