package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest
	@DisplayName("1 이상이거나 45 이하인 수로 로또 번호 객체 캐시를 반환 받을 수 있다.")
	@ValueSource(ints = {1, 45})
	void 로또_번호의_값이_1_이상이거나_45_이하라면_객체_캐시를_반환한다(int number) {
		// when
		LottoNumber lottoNumber = LottoNumber.from(number);

		// then
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@ParameterizedTest
	@DisplayName("1 미만이거나 45 초과인 수로 로또 번호 객체 캐시를 반환받는다면 에러를 발생시킨다.")
	@ValueSource(ints = {0, 46})
	void 로또_번호의_값이_1_미만이거나_45_초과라면_예외가_발생한다(int number) {
		// when, then
		assertThatThrownBy(() -> LottoNumber.from(number))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 로또 번호는 1 이상 45 이하이어야 합니다.");
	}
}