package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.Constants.*;

public class LottoController {
	private final LottoService lottoService = new LottoService();

	public void run() {
		int purchaseAmount = inputPurchaseAmount();
		int lottoCount = purchaseAmount / Constants.LOTTO_PRICE;
		List<Lotto> lottoTickets = lottoService.generateLottoTickets(lottoCount);

		displayLottoTickets(lottoTickets);
		WinningLotto winningLotto = new WinningLotto(inputWinningNumbers(), inputBonusNumber());
		System.out.println();

		displayResults(lottoTickets, winningLotto, purchaseAmount);
	}

	public int inputPurchaseAmount() {
		int amount;
		while (true) {
			try {
				System.out.println(INPUT_PROMPT_PURCHASE_AMOUNT);
				amount = Integer.parseInt(Console.readLine());
				inputInvalidPrice(amount);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(LOTTO_PURCHASE_AMOUNT_ERROR);
			}
		}
		return amount;
	}

	private void inputInvalidPrice(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_ERROR);
		}

		if (amount % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_ERROR);
		}
	}

	private void displayLottoTickets(List<Lotto> lottoTickets) {
		System.out.println(lottoTickets.size() + "개를 구매했습니다.");

		for (Lotto lotto : lottoTickets) {
			System.out.println(lotto.getNumbers());
		}

		System.out.println();
	}

	public List<Integer> inputWinningNumbers() {
		System.out.println(Constants.INPUT_PROMPT_WINNING_NUMBERS);

		String[] inputs = Console.readLine().split(",");
		List<Integer> numbers = new ArrayList<>();

		for (String input : inputs) {
			numbers.add(Integer.parseInt(input.trim()));
		}

		System.out.println();

		return numbers;
	}

	public int inputBonusNumber() {
		System.out.println(INPUT_PROMPT_BONUS_NUMBER);
		return Integer.parseInt(Console.readLine());
	}

	private void displayResults(List<Lotto> tickets, WinningLotto winningLotto, int purchaseAmount) {
		System.out.println("당첨 통계\n---");

		int[] rankCounts = calculateRankCounts(tickets, winningLotto);
		int totalPrize = calculateTotalPrize(rankCounts);

		displayRankCounts(rankCounts);
		displayProfitRate(totalPrize, purchaseAmount);
	}

	public int[] calculateRankCounts(List<Lotto> tickets, WinningLotto winningLotto) {
		int[] rankCounts = new int[LottoRank.values().length];
		for (Lotto lotto : tickets) {
			LottoRank rank = lottoService.checkLottoRank(lotto, winningLotto);
			if (rank != LottoRank.NONE) {
				rankCounts[rank.ordinal()]++;
			}
		}
		return rankCounts;
	}

	private int calculateTotalPrize(int[] rankCounts) {
		int totalPrize = 0;
		for (int i = 0; i < rankCounts.length; i++) {
			totalPrize += rankCounts[i] * LottoRank.values()[i].getPrize();
		}
		return totalPrize;
	}

	private void displayRankCounts(int[] rankCounts) {
		System.out.println(MATCH_THREE_MESSAGE + rankCounts[LottoRank.FIFTH.ordinal()] + "개");
		System.out.println(MATCH_FOUR_MESSAGE + rankCounts[LottoRank.FOURTH.ordinal()] + "개");
		System.out.println(MATCH_FIVE_MESSAGE + rankCounts[LottoRank.THIRD.ordinal()] + "개");
		System.out.println(MATCH_FIVE_WITH_BONUS_MESSAGE + rankCounts[LottoRank.SECOND.ordinal()] + "개");
		System.out.println(MATCH_SIX_MESSAGE + rankCounts[LottoRank.FIRST.ordinal()] + "개");
	}

	private void displayProfitRate(int totalPrize, int purchaseAmount) {
		double profitRate = ((double) totalPrize / purchaseAmount) * 100;
		System.out.printf(TOTAL_YIELD_MESSAGE, profitRate);
	}

}
