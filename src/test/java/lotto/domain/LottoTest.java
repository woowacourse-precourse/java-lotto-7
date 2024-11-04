package lotto.domain;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    Lotto lotto;

    public void setup(){
        lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
    }

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
    @DisplayName("로또 당첨 번호가 올바른 숫자로 입력된 경우")
    public void test1(){
        setup();

        assertThat(lotto.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("로또 당첨 번호가 1 ~ 45 범위를 벗어난 경우")
    public void test2(){
        assertThatThrownBy(() -> new Lotto(List.of(111, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 정상적으로 입력된 경우")
    public void test3(){
        setup();

        lotto.addBonusNumber("7");

        assertThat(lotto.getNumbers().get(6)).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호가 빈 값인 경우")
    public void test4(){
        setup();

        assertThatThrownBy(() -> lotto.addBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우")
    public void test5(){
        setup();

        assertThatThrownBy(() -> lotto.addBonusNumber("test"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복인 경우")
    public void test6(){
        setup();

        assertThatThrownBy(() -> lotto.addBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아닌 경우")
    public void test7(){
        setup();

        assertThatThrownBy(() -> lotto.addBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}
