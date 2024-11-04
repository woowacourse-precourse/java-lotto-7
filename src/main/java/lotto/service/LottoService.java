package lotto.service;

import static lotto.common.ErrorMessage.*;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.data.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.utils.StringUtils;

public class LottoService {

	private static final LottoService INSTANCE = new LottoService();

	private static final int LOTTO_PRICE = 1_000;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final String WINNER_NUMBERS_DELIMITER = ",";

	private final LottoRepository lottoRepository;

	private Set<Integer> winningNumbers;
	private int bonusNumber;

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

	public LottoResult spinning() {
		LottoResult lottoResult = new LottoResult();
		List<Lotto> lotto = lottoRepository.findAll();
		lotto.forEach(nowLotto -> {
			int winningNumbersCount = nowLotto.getWinningNumbersCount(winningNumbers);
			boolean hasBonusNumber = nowLotto.hasBonusNumber(bonusNumber);
			lottoResult.addResult(winningNumbersCount, hasBonusNumber);
		});
		return lottoResult;
	}

	private void validateAmount(int amount) {
		if (amount % 1_000 != 0) {
			throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
		}
	}

	private List<Integer> generateNumbers() {
		List<Integer> numbers
			= Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
		return numbers.stream().sorted().toList();
	}

	public void saveWinningNumbers(String input) {
		Set<Integer> numbers = Arrays.stream(input.split(WINNER_NUMBERS_DELIMITER))
			.map(numberAsString -> {
				int number = StringUtils.toNumber(numberAsString);
				validateNumberRange(number);
				return number;
			}).collect(Collectors.toSet());
		validateDuplicateNumbers(numbers);

		winningNumbers = numbers;
	}

	public void saveBonusNumber(String input) {
		int number = StringUtils.toNumber(input);

		validateNumberRange(number);
		validateDuplicateNumbers(number);

		bonusNumber = number;
	}

	private void validateNumberRange(int number) {
		if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
			throw new IllegalArgumentException(
				MessageFormat.format(NUMBER_OUT_OF_RANGE.getMessage(), LOTTO_START_NUMBER, LOTTO_END_NUMBER));
		}
	}

	private void validateDuplicateNumbers(Set<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(
				MessageFormat.format(DUPLICATE_NUMBERS.getMessage(), LOTTO_NUMBER_COUNT));
		}
	}

	private void validateDuplicateNumbers(int number) {
		if (winningNumbers.contains(number)) {
			throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
		}
	}
}
