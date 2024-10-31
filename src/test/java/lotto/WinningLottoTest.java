package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.LottoRank;
import lotto.model.WinningLotto;

public class WinningLottoTest {

	@Test
	void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
		assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), "7"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), "7"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 보너스_번호의_문자열이_숫자가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), "7"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 보너스_번호가_로또_번호의_범위가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), "50"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 보너스_번호를_저장한다() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), "7");

		assertThat(winningLotto.getBonusNumber())
			.isEqualTo(7);
	}

	@Test
	void 당첨_순위를_결정한다() {
		WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), "7");

		assertThat(winningLotto.calculateRank(List.of(1, 2, 3, 4, 5, 6)))
			.isInstanceOf(LottoRank.FIRST.getClass());

		assertThat(winningLotto.calculateRank(List.of(1, 2, 3, 4, 5, 7)))
			.isInstanceOf(LottoRank.SECOND.getClass());

		assertThat(winningLotto.calculateRank(List.of(1, 2, 3, 4, 5, 9)))
			.isInstanceOf(LottoRank.THIRD.getClass());

		assertThat(winningLotto.calculateRank(List.of(1, 2, 3, 4, 8, 7)))
			.isInstanceOf(LottoRank.FORTH.getClass());

		assertThat(winningLotto.calculateRank(List.of(1, 2, 3, 10, 9, 7)))
			.isInstanceOf(LottoRank.FIFTH.getClass());

		assertThat(winningLotto.calculateRank(List.of(1, 2, 9, 10, 11, 12)))
			.isInstanceOf(LottoRank.BOOM.getClass());
	}
}
