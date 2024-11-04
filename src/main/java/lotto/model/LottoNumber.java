package lotto.model;

import static lotto.message.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

	static {
		IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
				.forEach(number -> lottoNumberCache.put(number, new LottoNumber(number)));
	}

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber from(int number) {
		checkLottoNumberRange(number);
		return lottoNumberCache.get(number);
	}

	public int getNumber() {
		return number;
	}

	private static void checkLottoNumberRange(int number) {
		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}
}
