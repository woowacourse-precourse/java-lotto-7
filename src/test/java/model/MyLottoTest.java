package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoTest {

    @Test
    @DisplayName("구입 금액에 해당하는 만큼 로또를 생성한다")
    void 로또_생성() {
        MyLotto myLotto = new MyLotto(5);

        assertThat(myLotto.getMyLotto()).hasSize(5);
        assertThat(myLotto.getMyLottoForPrint()).hasSize(5);
    }

    @Test
    @DisplayName("생성된 모든 로또는 유효한 번호여야 한다")
    void 유효한_로또_생성() {
        MyLotto myLotto = new MyLotto(3);

        myLotto.getMyLotto().forEach(lotto -> {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
        });
    }
}

