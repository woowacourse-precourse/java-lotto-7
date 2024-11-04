package lotto;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lotto.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBonusNumberTest {
    @Test
    void 보너스번호가_당첨번호와_중복되지_않을_경우_정상입력() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 기존 당첨 번호

        int validBonusNumber = 7; // 당첨 번호에 포함되지 않은 숫자
        assertThat(lotto.isBonusNumberValid(validBonusNumber)).isTrue();
    }

//    @Test
//    void 보너스번호에_정수가_아닌값이_입력되면_예외발생() {
//        assertThatThrownBy(() -> {
//            System.setIn(new ByteArrayInputStream("abc".getBytes())); // 정수가 아닌 값 입력
//            InputView.getBonusNumber(List.of(1, 2, 3, 4, 5, 6));
//        }).isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR]");
//    }

//    @Test
//    void 보너스번호에_0이_입력되면_예외발생() {
//        assertThatThrownBy(() -> {
//            System.setIn(new ByteArrayInputStream("0".getBytes())); // 0 입력
//            InputView.getBonusNumber(List.of(1, 2, 3, 4, 5, 6));
//        }).isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR]");
//    }

    @Test
    void 보너스번호에_음수가_입력되면_예외발생() {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream("-5".getBytes())); // 음수 입력
            InputView.getBonusNumber(List.of(1, 2, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
