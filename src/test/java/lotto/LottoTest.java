package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import lotto.view.InputView;

import java.util.List;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest {

    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void restoreSystemInStream() {
        System.setIn(originalSystemIn);
    }

    private void redirectSystemIn(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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
    void 로또번호가_1에서_45_범위밖인_경우_예외발생() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6))) // 0 포함
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46))) // 46 포함
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @Test
//    public void testGetWinLottoNumbers_LeadingComma() {
//        redirectSystemIn(",1,2,3,4,5,6");
//        assertThatThrownBy(() -> InputView.getWinLottoNumbers())
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 번호는 쉼표로 시작할 수 없습니다.");
//    }

    @Test
    void 유효한_로또번호_입력시_정상생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 유효한 번호

        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

//    @Test
//    public void testGetWinLottoNumbers_EmptyInput() {
//        redirectSystemIn("");
//        assertThatThrownBy(() -> InputView.getWinLottoNumbers())
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 당첨 번호를 입력해야 합니다.");
//    }

}
