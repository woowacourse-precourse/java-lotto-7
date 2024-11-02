package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

class LottoNumberTest {

	@Test
	@DisplayName("로또 번호의 값이 같다면 같은 객체이다.")
	void 로또_번호의_값이_같다면_같은_객체이다() {
		// given
		int number = Randoms.pickUniqueNumbersInRange(1, 45, 1).getFirst();

		// when
		LottoNumber lottoNumber1 = LottoNumber.from(number);
		LottoNumber lottoNumber2 = LottoNumber.from(number);

		// then
		assertThat(lottoNumber1 == lottoNumber2).isTrue();
	}
}