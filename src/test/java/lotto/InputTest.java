package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

class InputTest {

	private TestInput input;

	@BeforeEach
	void 테스트_인스턴스_생성() {
		input = new TestInput();
	}

	@Test
	void 올바른_금액_입력() {
		input.입력값("1000");
		assertDoesNotThrow(() -> input.amountInput());
	}

	@Test
	void 예외처리_숫자가_아닌_값_입력() {
		input.입력값("abc");
		assertThrows(IllegalArgumentException.class, () -> input.amountInput());
	}

	@Test
	void 예외처리_1000원_미만_입력() {
		input.입력값("900");
		assertThrows(IllegalArgumentException.class, () -> input.amountInput());
	}

	@Test
	void 예외처리_100000원_초과_입력() {
		input.입력값("999999");
		assertThrows(IllegalArgumentException.class, () -> input.amountInput());
	}

	@Test
	void 예외처리_1000단위가_아닌_경우() {
		input.입력값("1111");
		assertThrows(IllegalArgumentException.class, () -> input.amountInput());
	}

	@Test
	void 올바른_로또번호_입력() {
		input.입력값("1,2,3,4,5,6");
		assertDoesNotThrow(() -> input.winningNumber());
	}

	@Test
	void 예외처리_입력받은_로또번호가_숫자가_아닌_경우() {
		input.입력값("1,2,a,3,4,5");
		assertThrows(IllegalArgumentException.class, () -> input.winningNumber());
	}

	@Test
	void 예외처리_입력받은_로또번호가_1에서_45사이의_값이_아닌_경우() {
		input.입력값("1,2,3,4,0,45");
		assertThrows(IllegalArgumentException.class, () -> input.winningNumber());
	}

	@Test
	void 올바른_보너스번호_입력() {
		input.입력값("7");
		assertDoesNotThrow(() -> input.bonusInput(input.로또번호(List.of(1, 2, 3, 4, 5, 6))));
	}

	@Test
	void 예외처리_입력받은_보너스번호가_숫자값이_값이_아닌_경우() {
		input.입력값("a");
		assertThrows(IllegalArgumentException.class, () -> input.bonusInput(input.로또번호(List.of(1, 2, 3, 4, 5, 6))));
	}

	@Test
	void 예외처리_입력받은_보너스번호가_당첨번호와_중복값인_경우() {
		input.입력값("1");
		assertThrows(IllegalArgumentException.class, () -> input.bonusInput(input.로또번호(List.of(1, 2, 3, 4, 5, 6))));
	}

	@Test
	void 예외처리_입력받은_보너스번호가_1에서_45사이의_값이_아닌_경우() {
		input.입력값("0");
		assertThrows(IllegalArgumentException.class, () -> input.bonusInput(input.로또번호(List.of(1, 2, 3, 4, 5, 6))));
	}

	static class TestInput extends Input {
		private String testInput;
		private List<Integer> testList;

		void 입력값(String input) {
			this.testInput = input;
		}

		List<Integer> 로또번호(List<Integer> list) {
			return this.testList = list;
		}

		@Override
		public String readLine() {
			return testInput;
		}

		@Override
		public int amountInput() {
			try {
				System.out.println("구입금액을 입력해 주세요.");
				String amount = readLine();
				Amount amountCheck = new Amount(amount);
				return amountCheck.getAmount();
			} catch (IllegalArgumentException e) {
				System.err.println(e);
				// 테스트 코드에서 무한 반복을 막기위해 재귀 호출 코드 제거
				throw e;
			}
		}

		@Override
		public List<Integer> winningNumber() {
			try {
				System.out.println();
				System.out.println("당첨 번호를 입력해 주세요.");
				String winning = readLine();
				WinningNumber winningNumber = new WinningNumber(winning);
				Lotto lotto = new Lotto(winningNumber.winningCheck());
				return lotto.listValueCheck();
			} catch (IllegalArgumentException e) {
				System.err.println(e);
				// 테스트 코드에서 무한 반복을 막기위해 재귀 호출 코드 제거
				throw e;
			}
		}

		@Override
		public int bonusInput(List<Integer> winningList) {
			try {
				System.out.println();
				System.out.println("보너스 번호를 입력해 주세요.");
				String bonus = readLine();
				BonusNumber bonusList = new BonusNumber(bonus, winningList);
				return bonusList.bounsCheck();
			} catch (IllegalArgumentException e) {
				System.err.println(e);
				// 테스트 코드에서 무한 반복을 막기위해 재귀 호출 코드 제거
				throw e;
			}
		}
	}
}
