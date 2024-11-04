package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("넘버를 입력했을 때 가지고 있다면 TRUE 반환하는지 확인")
    void checkLottoHaveBonusNum() {
        // given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 6;

        // when // then
        assertThat(lotto.containNumber(bonus));
    }

    @Test
    @DisplayName("중복되는 번호의 개수가 몇 개인지 정확히 반환하는지 테스트")
    void checkDuplicatesNumberTest() {
        // given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,7));
        int expect = 5;

        // when
        int count = lotto2.duplicatesNumber(lotto1);

        // then
        assertThat(count).isEqualTo(expect);
    }
}
