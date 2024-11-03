package lotto;

import lotto.domain.lottery.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호를 가져온다.")
    @Test
    void getNumbers(){
    //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        List<Integer> numbers = lotto.getNumbers();

        //then
        Assertions.assertThat(numbers.get(0)).isEqualTo(1);

    }

    @DisplayName("로또 번호를 가져온다.")
    @Test
    void countMatchingWinningNumbers(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 3, 5, 7, 9, 10);
        //when
        Integer matchingWinningNumbers = lotto.countMatchingWinningNumbers(winningNumbers);
        //then
        Assertions.assertThat(matchingWinningNumbers).isEqualTo(3);
    }

    @DisplayName("일치하는 번호가 없으면 0을 반환한다")
    @Test
    void countMatchingWinningNumbers2(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(13, 32, 17, 7, 9, 10);
        //when
        Integer matchingWinningNumbers = lotto.countMatchingWinningNumbers(winningNumbers);
        //then
        Assertions.assertThat(matchingWinningNumbers).isEqualTo(0);
    }
}
