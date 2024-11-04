package lotto.service;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;

public class LottoService {

	private static final LottoService INSTANCE = new LottoService();

	private static final int LOTTO_PRICE = 1_000;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;

	private final LottoRepository lottoRepository;

	private LottoService() {
		this.lottoRepository = LottoRepository.getInstance();
	}

	public static LottoService getInstance() {
		return INSTANCE;
	}

	public List<Lotto> buy(int amount) {
		validateAmount(amount);

		int lottoQuantity = amount / LOTTO_PRICE;
		while (lottoQuantity-- > 0) {
			Lotto lotto = new Lotto(generateNumbers());
			lottoRepository.save(lotto);
		}

		return lottoRepository.findAll();
	}

	private void validateAmount(int amount) {
		if (amount % 1_000 != 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
		}
	}

	private List<Integer> generateNumbers() {
		List<Integer> numbers
			= Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
		Collections.sort(numbers);
		return numbers;
	}
}
