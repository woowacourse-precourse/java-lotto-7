package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE_BEFORE_ADD_BONUS_NUMBER = 6;
    private static final int LOTTO_SIZE_AFTER_ADD_BONUS_NUMBER = 7;

    @DisplayName("로또 번호 1에서 45까지의 숫자 중 6개를 랜덤 추출한다.")
    @Test
    void 로또_번호_1에서_45까지의_숫자_중_6개를_랜덤_추출한다() {
        // given
        LottoService lottoService = new LottoService();

        // when
        Lotto lotto = new Lotto(lottoService.createRandomNumbers());

        // then
        List<Integer> lottoNumbers = lotto.getNumbersList();
        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_SIZE_BEFORE_ADD_BONUS_NUMBER);
        assertThat(lottoNumbers
                .stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER)
        )
                .isEqualTo(true);
    }

    @DisplayName("보너스 번호 한 개를 랜덤 생성한다.")
    @Test
    void 보너스_번호_한_개를_랜덤_생성한다() {
        // given
        LottoService lottoService = new LottoService();

        // when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int newBonusNumber = lottoService.createBonusNumber();
        lotto.addBonusNumber(newBonusNumber);

        // then
        int bonusNumber = lotto.getBonusNumber();
        assertThat(bonusNumber).isBetween(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

    // 예외 테스트

    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
