package lotto;

import lotto.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    void 구매한_금액이_1000원_미만이면_예외가_발생한다(){
        assertThatThrownBy(() -> new User(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매한_금액이_1000원_단위가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new User(1111))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
