package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호가 1 부터 45 사이가 아니라면 예외를 발생한다.")
    @Test
    void outOfRangeLottoNumbers() {
        //given
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 46);

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

    @DisplayName("당첨 로또 번호와 보너스 번호가 중복된다면 true 를 반환한다.")
    @Test
    void duplicateBonusNumber() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3;

        //when
        boolean result = lotto.isDuplicateBonusNumber(bonusNumber);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호와 당첨 번호의 일치 개수를 계산할 수 있다.")
    @Test
    void countMatches() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        //when
        int matchCount = winningNumbers.countMatches(lotto);

        //then
        assertThat(matchCount).isEqualTo(6);
    }
}
