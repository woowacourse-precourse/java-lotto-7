package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static lotto.Prize.*;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest extends NsTest {
    @ParameterizedTest
    @EnumSource(Prize.class)
    @DisplayName("당첨_기준과_금액_출력_테스트")
    void 당첨_기준과_금액_출력_테스트(Prize prize) {
        assertThat(prize.toString()).isEqualTo(expected(prize));
    }

    private String expected(Prize prize) {
        if (prize == FIRST) {
            return "6개 일치 (2,000,000,000원)";
        }
        if (prize == SECOND) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원)";
        }
        if (prize == THIRD) {
            return "5개 일치 (1,500,000원)";
        }
        if (prize == FOURTH) {
            return "4개 일치 (50,000원)";
        }
        if (prize == FIFTH) {
            return "3개 일치 (5,000원)";
        }
        return null;
    }

    @DisplayName("기능_테스트_getPrize")
    @Test
    void 기능_테스트_getPrize() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,8));
        Lotto lotto4 = new Lotto(List.of(1,2,3,4,7,8));
        Lotto lotto5 = new Lotto(List.of(1,2,3,7,8,9));
        Lotto lottoNo = new Lotto(List.of(1,2,7,8,9,10));
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6),7);
        assertThat(Prize.getPrize(lotto1, winningLotto)).isEqualTo(FIRST);
        assertThat(Prize.getPrize(lotto2, winningLotto)).isEqualTo(SECOND);
        assertThat(Prize.getPrize(lotto3, winningLotto)).isEqualTo(THIRD);
        assertThat(Prize.getPrize(lotto4, winningLotto)).isEqualTo(FOURTH);
        assertThat(Prize.getPrize(lotto5, winningLotto)).isEqualTo(FIFTH);
        assertThat(Prize.getPrize(lottoNo, winningLotto)).isEqualTo(DRAW);
    }

    @Override
    protected void runMain() {

    }
}
