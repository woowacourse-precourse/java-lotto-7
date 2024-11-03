package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    List<Integer> purchaseNumber;
    WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        purchaseNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            purchaseNumber.add(i);
        }

        List<Integer> winningNumData = new ArrayList<>();
        winningNumData.add(1);
        winningNumData.add(2);
        winningNumData.add(3);
        winningNumData.add(10);
        winningNumData.add(11);
        winningNumData.add(12);
        int bonusNumber = 8;
        winningNumber = new WinningNumber(winningNumData, bonusNumber);
    }

    @Test
    @DisplayName("당첨번호 생성시 보너스 번호 범위가 1~45가 아니면 예외 발생하는 테스트")
    void checkBonusNumberRange() {
        int bonusNumber = 100;

        assertThatThrownBy(() -> {
            final WinningNumber InvalidWinningNumber = new WinningNumber(winningNumber.getNumbers(), bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
