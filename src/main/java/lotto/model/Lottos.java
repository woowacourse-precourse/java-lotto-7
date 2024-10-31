package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lottos {

	private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자가 아닙니다.";
	private static final String DIVISIBLE_ERROR_MESSAGE = "[ERROR] 1000으로 나눌 수 없습니다.";
	private static final int DIVISOR = 1000;

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
		int buyingNumber = validateDivisible(number) / DIVISOR;

		return buyingNumber;
	}

	private int validateNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
		}
	}

	private int validateDivisible(int num) {
		if (num % DIVISOR != 0) {
			throw new IllegalArgumentException(DIVISIBLE_ERROR_MESSAGE);
		}
		return num;
	}

	public void createLotto() {
		Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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
