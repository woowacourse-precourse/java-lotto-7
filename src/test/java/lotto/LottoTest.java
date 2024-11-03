package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("올바른 로또 번호가 주어졌을 때 객체 생성 성공")
    void 올바른_로또_번호가_주어졌을_때_객체_생성_성공() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto.getNumbers()).isEqualTo(validNumbers);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수를 반환한다")
    void 당첨_번호와_일치하는_개수를_반환한다() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);

        int matchingCount = lotto.countMatchingNumber(winningNumbers);
        assertThat(matchingCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는 경우 true를 반환한다")
    void 보너스_번호와_일치하는_경우_true를_반환한다() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        Lotto lotto = new Lotto(lottoNumbers);

        boolean hasBonus = lotto.isMatchingBonusNumber(3);
        assertThat(hasBonus).isTrue();
    }

    @Test
    @DisplayName("보너스 번호와 일치하지 않는 경우 false를 반환한다")
    void 보너스_번호와_일치하지_않는_경우_false를_반환한다() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        Lotto lotto = new Lotto(lottoNumbers);

        boolean hasBonus = lotto.isMatchingBonusNumber(10);
        assertThat(hasBonus).isFalse();
    }

}
