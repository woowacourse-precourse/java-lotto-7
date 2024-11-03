package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @DisplayName("두 로또 번호를 비교하여 공통 번호 수를 알 수 있다.")
    @Test
    void common_num_count() throws Exception{
        //given
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(4, 5, 6, 7, 8, 9)));
        //when
        int commonCount = lotto1.countMatching(lotto2);
        //then
        assertThat(commonCount).isEqualTo(3);
     }

     @DisplayName("로또 번호에서 특정번호의 포함여부를 알 수 있다.")
     @Test
     void contains_one_number() throws Exception{
         //given
         Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
         //when
         boolean contains = lotto.contains(1);
         //then
         assertThat(contains).isTrue();
      }
}
