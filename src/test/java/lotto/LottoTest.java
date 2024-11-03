package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void 숫자_보유_검사_테스트(){
        Lotto lotto1 = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lotto1.hasValue(1)).isEqualTo(true);
        assertThat(lotto1.hasValue(9)).isEqualTo(false);

    }

    @Test
    void 겹치는_숫자_개수_테스트(){
        Lotto lotto1 = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<Integer>(Arrays.asList(6, 7, 8, 3, 1, 24)));
        Lotto lotto3 = new Lotto(new ArrayList<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)));

        assertThat(lotto1.equalSize(lotto1)).isEqualTo(6);
        assertThat(lotto1.equalSize(lotto2)).isEqualTo(3);
        assertThat(lotto1.equalSize(lotto3)).isEqualTo(0);

    }
}
