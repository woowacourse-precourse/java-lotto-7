package lotto;

import lotto.controller.LottoController;
import lotto.model.Bonus;
import lotto.model.Lotto;
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

    @Test
    void 로또_번호의_입력_값_숫자_입력후_리스트_반환(){
        String userInput = "1, 2, 3, 4, 5, 6";
        LottoController lottoController = new LottoController();
        List<Integer> userNumbers = lottoController.getUserNumbers(userInput);
        assertThat(userNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호의_입력_값_숫자가_아닌_입력값이_있으면_예외가_발생한다(){
        String userInput = "1,e,f";
        LottoController lottoController = new LottoController();

        assertThatThrownBy(() -> lottoController.getUserNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 숫자여야 합니다.");
    }

    @Test
    void 로또_번호의_입력_값_중복_이씨으면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않는 숫자를 입력해야 합니다.");
    }

    @Test
    void 보너스_번호의_입력_값_중복_있으면_예외가_발생한다(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new Bonus(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 입력하신 로또 번호와 중복되지 않아야 합니다.");
    }



}
