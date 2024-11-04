package lotto.service;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
	private LottoService lottoService;
	
	@BeforeEach
	void setUp() {
		lottoService = LottoServiceImpl.getInstance();
		lottoService.getAll().clear();	// 테스트 시작 전 저장소(Repository) 초기화
	}

	@Test
	@DisplayName("구매 금액에 따라 올바른 개수의 로또만 생성되고 저장")
	void createAll_validPurchaseAmount() {
		BigInteger purchaseAmount = BigInteger.valueOf(5000);
		
		lottoService.createAll(purchaseAmount);
		
		assertThat(lottoService.getAll()).hasSize(5);
	}
	
	@Test
	@DisplayName("저장된 모든 로또 반환")
	void getAll_returnsAllLottos() {
		BigInteger purchaseAmount = BigInteger.valueOf(3000);
		
		lottoService.createAll(purchaseAmount);
		
		List<Lotto> lottos = lottoService.getAll();
		assertThat(lottos).hasSize(3);
		assertThat(lottos.get(0).getNumbers()).hasSize(6);
	}
}
