package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.common.exception.InvalidBonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외를 반환하는 테스트")
    @Test
    void winningLotto_duplicateBonusNumber_throwException() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        assertThatThrownBy(() -> new WinningLotto(lotto, new LottoNumber(1)))
                .isInstanceOf(InvalidBonusNumberException.class);
    }
}
