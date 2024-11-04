package lotto.model.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoBundle;
import lotto.model.domain.PurchaseMoney;
import lotto.model.domain.ReturnRate;
import lotto.model.domain.Winning;
import lotto.model.domain.WinningNumber;
import lotto.model.dto.WinningDTO;

class LottoServiceTest {
	private LottoService lottoService;

	@BeforeEach
	void setUp() {
		lottoService = new LottoService();
	}

	@DisplayName("구매 금액에 따른 PurchaseMoney 생성 테스트")
	@Test
	void 구입금액_생성_확인() {
		PurchaseMoney purchaseMoney = lottoService.createPurchaseMoney(1000);
		assertThat(purchaseMoney.getMoney()).isEqualTo(1000);
	}

	@DisplayName("로또 개수 계산 테스트")
	@Test
	void 로또_개수_계산_확인() {
		PurchaseMoney purchaseMoney = lottoService.createPurchaseMoney(5000);
		assertThat(lottoService.calculateLottoCount(purchaseMoney)).isEqualTo(5);
	}

	@DisplayName("로또 번들 생성 테스트")
	@Test
	void 로또_번들_생성_확인() {
		LottoBundle lottoBundle = lottoService.createLottoBundle(3);
		assertThat(lottoBundle.getLottoBundle()).hasSize(3);
	}

	@DisplayName("당첨 번호 DTO 생성 테스트")
	@Test
	void 당첨_DTO_생성_확인() {
		WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = new BonusNumber(winningNumber.getWinningNumber(), 7);

		WinningDTO winningDTO = lottoService.createWinningDTO(winningNumber, bonusNumber);
		assertThat(winningDTO.getWinningNumber()).containsExactly(1, 2, 3, 4, 5, 6);
		assertThat(winningDTO.getBonusNumber()).isEqualTo(7);
	}

	@DisplayName("당첨 번호 생성 테스트")
	@Test
	void 당첨_번호_생성_확인() {
		WinningNumber winningNumber = lottoService.createWinningNumber(List.of(1, 2, 3, 4, 5, 6));
		assertThat(winningNumber.getWinningNumber()).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@DisplayName("보너스 번호 생성 테스트")
	@Test
	void 보너스_번호_생성_확인() {
		WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = lottoService.createBonusNumber(winningNumber, 7);

		assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
	}

	@DisplayName("수익률 계산 테스트")
	@Test
	void 수익률_계산_확인() {
		Winning winning = new Winning(LottoBundle.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))),
			new WinningDTO(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)),
				new BonusNumber(List.of(1, 2, 3, 4, 5, 6), 7)));
		PurchaseMoney purchaseMoney = new PurchaseMoney(1000);

		ReturnRate returnRate = lottoService.calculateReturnRate(winning, purchaseMoney);
		assertThat(returnRate.calculate()).isGreaterThan(0);
	}
}
