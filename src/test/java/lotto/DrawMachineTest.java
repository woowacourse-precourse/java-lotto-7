package lotto;

import lotto.committee.DrawMachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DrawMachineTest {

    DrawMachine drawMachine = new DrawMachine();

//    @Test
//    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
//        assertThatThrownBy(() -> drawMachine.runSingleDraw())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
