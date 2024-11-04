package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.Randoms;

class LottoRepositoryTest {
	private final LottoRepository lottoRepository = LottoRepository.getInstance();

	@AfterEach
	void tearDown() {
		lottoRepository.clear();
	}

	@DisplayName("로또 저장에 성공한다.")
	@Test
	void saveTest() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		assertThat(lottoRepository.save(lotto)).isEqualTo(lotto);
	}

	@DisplayName("저장되어 있는 로또 조회에 성공한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void findAllTest(int lottoQuantity) {
		for (int i = 0; i < lottoQuantity; i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			lottoRepository.save(lotto);
		}

		assertThat(lottoRepository.findAll()).hasSize(lottoQuantity);
	}
}