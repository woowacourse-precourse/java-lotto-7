package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    void hasBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7);
        Lotto lottoWithBonusNumber = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lottoWithoutBonusNumber = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(winningLotto.hasBonusNumber(lottoWithBonusNumber.getNumbers())).isEqualTo(true);
        assertThat(winningLotto.hasBonusNumber(lottoWithoutBonusNumber.getNumbers())).isEqualTo(false);
    }
}