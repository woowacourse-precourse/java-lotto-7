package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.service.Lotto;
import lotto.service.Purchase;
import lotto.view.input.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.view.exception.ErrorMessage.numberCommerForat;
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


    @DisplayName("로또 번호 입력 시 숫자와 콤마 이외가 들어갈 경우 예외가 발생한다.")
    @Test
    void 로또_번호_입력_시_숫자와_콤마_이외가_들어갈_경우_예외가_발생한다() {
        //given
        Input input = new Input();
        String mockInput = "1,2,a,4,5,6\n";
        InputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);

        //when && then
        assertThatThrownBy(() -> input.getWinNumbers())
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR] 숫자와 ,만 입력해 주세요.");

    }


    @DisplayName("로또 추가 번호 입력 시 숫자 이외가 들어갈 경우 예외가 발생한다.")
    @Test
    void 로또_추가_번호_입력_시_숫자_이외가_들어갈_경우_예외가_발생한다() {
        //given
        Input input = new Input();
        String mockInput = "1,\n";
        InputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);

        //when && then
        assertThatThrownBy(() -> input.getBonusNumber())
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력해 주세요.");

    }

    @DisplayName("로또 추가 번호 입력 시 45 이상 및 1이하의 수가 들어갈 경우 예외가 발생한다.")
    @Test
    void 로또_추가_번호_입력_시_45이상_및_1이하의_수가_들어갈_경우_예외가_발생한다() {
        //given
        Input input = new Input();
        String mockInput = "46\n";
        InputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);

        //when && then
        assertThatThrownBy(() -> input.getBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

}
