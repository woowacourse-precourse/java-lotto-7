package lotto.model.domain;

import lotto.model.dto.WinningDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
	@DisplayName("당첨 내역 생성")
	@Test
	void 당첨_내역_생성() {
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
		WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));

		WinningDTO winningDTO = new WinningDTO(winningNumber, new BonusNumber(List.of(1, 2, 3, 4, 5, 6), 10));
		Winning winning = new Winning(new LottoBundle(List.of(lotto1, lotto2)), winningDTO);

		assertThat(winning.getRankCounts().get(Rank.FIRST)).isEqualTo(1);
		assertThat(winning.getRankCounts().get(Rank.SECOND)).isEqualTo(1);
	}
}
