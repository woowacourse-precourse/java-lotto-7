package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCreatorTest {

	private static final int LOTTO_NUMBER_COUNT = 6;

	private final LottoCreator lottoCreator	= new LottoCreator();

	@Test
	@DisplayName("로또 번호의 개수가 6개인 구매 로또를 생성할 수 있다.")
	void 로또_번호의_개수가_6개인_구매_로또를_생성한다() {
		// when
		Lotto purchasedLotto = lottoCreator.createPurchasedLotto();

		// then
		assertEquals(LOTTO_NUMBER_COUNT, purchasedLotto.getNumbers().size());
	}

	@Test
	@DisplayName("중복이 존재하지 않는 구매 로또를 생성할 수 있다.")
	void 중복이_존재하지_않는_구매_로또를_생성한다() {
		// when
		Lotto purchasedLotto = lottoCreator.createPurchasedLotto();
		Set<LottoNumber> uniqueNumbers = new HashSet<>(purchasedLotto.getNumbers());

		// then
		assertEquals(uniqueNumbers.size(), purchasedLotto.getNumbers().size());
	}

	@Test
	@DisplayName("파라미터로 전달받은 정수 리스트를 토대로 당첨 로또를 생성할 수 있다.")
	void 정수_리스트를_토대로_당첨_로또를_생성한다() {
		// given
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

		// when
		Lotto winningLotto = lottoCreator.createWinningLotto(numbers);

		// then
		assertEquals(numbers.size(), winningLotto.getNumbers().size());
		assertIterableEquals(numbers, winningLotto.getNumbers().stream()
				.map(LottoNumber::getNumber)
				.toList());
	}
}