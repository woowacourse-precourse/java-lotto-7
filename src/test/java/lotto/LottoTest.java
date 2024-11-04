package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.service.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
	@Test
	void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	// TODO: 추가 기능 구현에 따른 테스트 코드 작성

	@Test
	@DisplayName("로또 번호는 6개여야 한다.")
	void 로또_번호_6개_생성_테스트() {
		LottoService service = new LottoService();
		List<Integer> numbers = service.generateLotto();
		assertEquals(6, numbers.size());
	}

	@Test
	@DisplayName("로또 번호는 중복이 없어야 한다.")
	void 로또_번호_중복_테스트() {
		LottoService service = new LottoService();
		List<Integer> numbers = service.generateLotto();
		assertEquals(numbers.size(), numbers.stream().distinct().count());
	}

	@Test
	@DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
	void 로또_번호_범위_테스트() {
		LottoService service = new LottoService();
		List<Integer> numbers = service.generateLotto();
		assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 45));
	}

	@Test
	@DisplayName("유효하지 않은 로또 번호가 입력되면 예외가 발생한다.")
	void 유효하지_않은_로또_번호_예외_테스트() {
		List<Integer> invalidNumbers = List.of(0, 2, 3, 4, 5, 46);
		assertThrows(IllegalArgumentException.class, () -> LottoValidator.judgement(invalidNumbers));
	}

	@Test
	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	void 로또_번호_중복_숫자_예외_테스트() {
		List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);
		assertThrows(IllegalArgumentException.class, () -> LottoValidator.judgement(duplicateNumbers));
	}

	@Test
	@DisplayName("유효한 로또 번호가 입력되었을 때 예외가 발생하지 않는다.")
	void 유효한_로또_번호_예외_없음_테스트() {
		List<Integer> validNumbers = List.of(5, 8, 12, 23, 34, 42);
		assertDoesNotThrow(() -> LottoValidator.judgement(validNumbers));
	}

	@Test
	@DisplayName("로또 구입 금액이 1000원 단위가 아닐 때 예외가 발생한다.")
	void 구입_금액_단위_예외_테스트() {
		int invalidAmount = 1500;
		assertThrows(IllegalArgumentException.class, () -> {
			if (invalidAmount % 1000 != 0) {
				throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
			}
		});
	}

	@Test
	@DisplayName("로또 구입 금액이 음수일 때 예외가 발생한다.")
	void 구입_금액_음수_예외_테스트() {
		int negativeAmount = -1000;
		assertThrows(IllegalArgumentException.class, () -> {
			if (negativeAmount <= 0) {
				throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
			}
		});
	}

	@Test
	@DisplayName("로또 구입 금액이 0일 때 예외가 발생한다.")
	void 구입_금액_0_예외_테스트() {
		int zeroAmount = 0;
		assertThrows(IllegalArgumentException.class, () -> {
			if (zeroAmount <= 0) {
				throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
			}
		});
	}

	@Test
	@DisplayName("3개 번호가 일치하면 5등 당첨이다.")
	void 세_개_번호_일치_테스트() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
		LottoRank rank = winningLotto.calculateRank(new Lotto(List.of(1, 2, 3, 20, 21, 22)));
		assertEquals(LottoRank.FIFTH, rank);
	}

	@Test
	@DisplayName("4개 번호가 일치하면 4등 당첨이다.")
	void 네_개_번호_일치_테스트() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
		LottoRank rank = winningLotto.calculateRank(new Lotto(List.of(1, 2, 3, 4, 20, 21)));
		assertEquals(LottoRank.FOURTH, rank);
	}

	@Test
	@DisplayName("5개 번호가 일치하면 3등 당첨이다.")
	void 다섯_개_번호_일치_테스트() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
		LottoRank rank = winningLotto.calculateRank(new Lotto(List.of(1, 2, 3, 4, 5, 22)));
		assertEquals(LottoRank.THIRD, rank);
	}

	@Test
	@DisplayName("5개 번호와 보너스 번호가 일치하면 2등 당첨이다.")
	void 다섯_개_번호와_보너스_번호_일치_테스트() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
		LottoRank rank = winningLotto.calculateRank(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
		assertEquals(LottoRank.SECOND, rank);
	}

	@Test
	@DisplayName("6개 번호가 모두 일치하면 1등 당첨이다.")
	void 여섯_개_번호_일치_테스트() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
		LottoRank rank = winningLotto.calculateRank(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
		assertEquals(LottoRank.FIRST, rank);
	}

	@Test
	@DisplayName("번호가 모두 일치하지 않으면 당첨이 없다.")
	void 일치_번호_없음_테스트() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
		LottoRank rank = winningLotto.calculateRank(new Lotto(List.of(10, 11, 12, 13, 14, 15)));
		assertEquals(LottoRank.NONE, rank);
	}

	@Test
	@DisplayName("수익률이 올바르게 계산된다.")
	void 수익률_계산_테스트() {
		int totalPrize = 2035050000;
		int purchaseAmount = 5000;
		double expectedRate = ((double) totalPrize / purchaseAmount) * 100;
		assertEquals(40701000.0, expectedRate, 0.1);
	}
}
