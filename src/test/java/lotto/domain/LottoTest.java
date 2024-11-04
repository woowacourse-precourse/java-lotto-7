package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domains.lotto.domain.Lotto;

class LottoTest {
	@DisplayName("Lotto 클래스가 올바르게 생성된다.")
	@Test
	void 로또_클래스가_올바르게_생성된다() {
		assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(Lotto.class);
	}

	@DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다")
	@Test
	void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
	}

	@DisplayName("로또 번호에 로또 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
	@Test
	void 로또_번호에_로또_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)));
	}

}
