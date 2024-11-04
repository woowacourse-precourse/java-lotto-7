package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    void hasBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7); //당첨 로또 번호가 1,2,3,4,5,6 보너스 7
        Lotto lottoWithBonusNumber = new Lotto(List.of(1,2,3,4,5,7)); //보너스 번호가 있는 로또
        Lotto lottoWithoutBonusNumber = new Lotto(List.of(1,2,3,4,5,6)); //보너스 번호가 없는 로또

        assertThat(winningLotto.hasBonusNumber(lottoWithBonusNumber.getNumbers())).isEqualTo(true);
        assertThat(winningLotto.hasBonusNumber(lottoWithoutBonusNumber.getNumbers())).isEqualTo(false);
    }
}