package lotto;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private Lotto lotto;
//    @Test
//    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @Test
    @DisplayName("로또 번호가 잘 생성되는지 확인")
    void 로또_번호_생성_테스트() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

}
