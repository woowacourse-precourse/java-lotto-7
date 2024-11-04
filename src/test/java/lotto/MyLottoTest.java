package lotto;

import lotto.domain.Lotto;
import lotto.domain.MyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class MyLottoTest {

    @DisplayName("일치하는 번호 갯수 체크 테스트")
    @Test
    void 일치하는_번호_갯수_체크_테스트() {
        MyLotto myLotto = new MyLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(myLotto.getMatchCount(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @DisplayName("보너스 일치 여부 확인 테스트")
    @Test
    void 보너스_일치_여부_확인_테스트() {
        MyLotto myLotto = new MyLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(myLotto.hasBonus(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(true);
    }
}
