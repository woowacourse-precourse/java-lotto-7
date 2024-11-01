package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User();

    @DisplayName("구입 금액만큼 로또 생성 확인")
    @Test
    void createLotto() {
        assertThat(user.createLotto(10).size()).isEqualTo(10);
    }
}