package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
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

    @Test
    @DisplayName("로또 번호 오름차순 정렬")
    void checkNumbersSortByAsc(){
        //given
        List<Integer> testNumbers = new ArrayList<>();

        testNumbers.add(39);
        testNumbers.add(29);
        testNumbers.add(9);
        testNumbers.add(3);
        testNumbers.add(1);
        testNumbers.add(32);
        Collections.sort(testNumbers);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(9);
        numbers.add(29);
        numbers.add(32);
        numbers.add(39);
        //when
        Lotto lotto = new Lotto(testNumbers);

        //then
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);

    }


}
