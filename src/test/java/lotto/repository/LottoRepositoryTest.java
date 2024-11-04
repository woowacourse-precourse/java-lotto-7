package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class LottoRepositoryTest {
	private LottoRepository lottoRepository;
	
	@BeforeEach
	void setUp() {
		lottoRepository = LottoRepositoryImpl.getInstance();
	}
	
	@Test
	@DisplayName("로또 번호를 저장하고 조회")
	void saveAll_and_findAll() {
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
		
		lottoRepository.saveAll(List.of(lotto1, lotto2));
		
		List<Lotto> lottos = lottoRepository.findAll();
		assertThat(lottos).contains(lotto1, lotto2);
	}
}
