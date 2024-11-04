package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @DisplayName("구매 금액이 로또 가격의 배수가 아니면 예외가 발생한다.")
    @Test
    void 구매_금액이_로또_가격의_배수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> user.setPrice(1001)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            user.setLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            user.setBonusNumber(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 넘어서면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_넘어서면_예외가_발생한다() {
        assertThatThrownBy(() -> user.setBonusNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
