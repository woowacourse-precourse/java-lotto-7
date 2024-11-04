package lotto.model.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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

class CalculateServiceTest {
	private LottoService lottoService;
	private CalculateService calculateService;

	@BeforeEach
	void setUp() {
		lottoService = new LottoService();
		calculateService = new CalculateService();
	}

	@DisplayName("로또 개수 계산 테스트")
	@Test
	void 로또_개수_계산_확인() {
		PurchaseMoney purchaseMoney = lottoService.createPurchaseMoney(5000);
		assertThat(calculateService.calculateLottoCount(purchaseMoney)).isEqualTo(5);
	}

	@DisplayName("수익률 계산 테스트")
	@Test
	void 수익률_계산_확인() {
		Winning winning = new Winning(LottoBundle.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))),
			new WinningDTO(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)),
				new BonusNumber(List.of(1, 2, 3, 4, 5, 6), 7)));
		PurchaseMoney purchaseMoney = new PurchaseMoney(1000);

		ReturnRate returnRate = calculateService.calculateReturnRate(winning, purchaseMoney);
		assertThat(returnRate.calculate()).isGreaterThan(0);
	}
}
