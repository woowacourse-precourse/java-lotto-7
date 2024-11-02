package lotto.domain;

import java.util.ArrayList;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void 로또_생성_테스트_성공() {
        // given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Lotto lotto = new Lotto(numbers);

        // when
        List<Integer> lottoNumbers = lotto.getNumbers();

        // then
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, lottoNumbers.toArray());
    }

    @Test
    void 로또_번호의_개수가_7개_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호의_개수가_5개_이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void 숫자의_범위가_0_이하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 범위는 1~45까지 입니다.");
    }

    @Test
    void 숫자의_범위가_46_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 범위는 1~45까지 입니다.");
    }
}
