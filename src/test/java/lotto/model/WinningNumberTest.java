package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @Test
    @DisplayName("당첨번호 생성시 보너스 번호 범위가 1~45가 아니면 예외 발생하는 테스트")
    void checkBonusNumberRange() {
        int bonusNumber = 100;
        List<Integer> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumber.add(i);
        }

        assertThatThrownBy(() -> {
            final WinningNumber winningNumber = new WinningNumber(lottoNumber, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
