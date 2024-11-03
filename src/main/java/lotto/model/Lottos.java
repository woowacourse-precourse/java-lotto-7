package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.constant.ErrorMessage;
import lotto.model.constant.Values;

public class Lottos {

	private List<Lotto> lottos = new ArrayList<>();
	private HashMap<LottoRank, Integer> winningResult = new HashMap<>();

	public Lottos() {
		for (LottoRank rank : LottoRank.values()) {
			winningResult.put(rank, 0);
		}
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public HashMap<LottoRank, Integer> getWinningResult() {
		return winningResult;
	}

	public int calculateNumberOfLotto(String str) {
		int number = validateNumber(str);
		int buyingNumber = validateDivisible(number) / Values.PRICE_PER_LOTTO;

		return buyingNumber;
	}

	private int validateNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_MESSAGE);
		}
	}

	private int validateDivisible(int num) {
		if (num % Values.PRICE_PER_LOTTO != 0) {
			throw new IllegalArgumentException(ErrorMessage.DIVISIBLE_ERROR_MESSAGE);
		}
		return num;
	}

	public void createLotto() {
		Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange
			(Values.LEAST_LOTTO_NUMBER, Values.MOST_LOTTO_NUMBER, Values.SIZE_OF_LOTTO));
		lottos.add(lotto);
	}

	public void addRank(LottoRank rank) {
		int updateCount = winningResult.get(rank) + 1;
		winningResult.put(rank, updateCount);
	}

	public long calculateWinningPrize() {
		long totalPrize = 0;

		for (LottoRank rank : LottoRank.values()) {
			totalPrize += (long)rank.getPrize() * winningResult.get(rank);
		}

		return totalPrize;
	}

}
