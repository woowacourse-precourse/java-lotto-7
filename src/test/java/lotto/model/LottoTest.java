package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("로또 번호의 개수가 6개이고 중복이 존재하지 않는다면 로또 객체를 생성할 수 있다.")
	void 로또_번호의_개수가_6개이고_중복이_없다면_객체를_생성한다() {
		// given
		List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
				.mapToObj(LottoNumber::from)
				.toList();

		// when
		Lotto lotto = new Lotto(lottoNumbers);

		// then
		assertThat(lotto.getNumbers()).isEqualTo(lottoNumbers);
	}

	@Test
	@DisplayName("로또 번호의 개수가 6개를 초과한다면 에러를 발생시킨다.")
	void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
		// given
		List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 7)
				.mapToObj(LottoNumber::from)
				.toList();

		// when, then
		assertThatThrownBy(() -> new Lotto(lottoNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
	}

    @Test
	@DisplayName("로또 번호에 중복된 숫자가 있으면 에러를 발생시킨다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		// given
		List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 5)
				.mapToObj(LottoNumber::from)
				.collect(Collectors.toList());
		lottoNumbers.add(LottoNumber.from(1));

		// when, then
		assertThatThrownBy(() -> new Lotto(lottoNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}
