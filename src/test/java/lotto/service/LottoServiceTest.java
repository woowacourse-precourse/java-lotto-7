package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
	private LottoService lottoService;

	@BeforeEach
	void setUp() {
		lottoService = new LottoService();
	}

	@DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
	@Test
	void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
		assertThatIllegalArgumentException().isThrownBy(() -> lottoService.drawWinningNumbers("1,2,3,4,5"));
	}

	@DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
	@Test
	void 보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> lottoService.drawBonusNumber("1", List.of(1, 2, 3, 4, 5, 6)));
	}
}
