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

    @Test
    @DisplayName("로또 한장의 당첨순위가 올바른지 확인하는 테스트")
    void getWinningRank() {
        final int FIFTH = 5;
        final int FORTH = 4;
        final int THIRD = 3;
        final int SECOND = 2;
        final int FIRST = 1;
        final int NOT_WIN = 0;
        int currentRank;
        Lotto lotto;

        //5등 체크
        lotto = new Lotto(new ArrayList<>(List.of(1,2,3,39,40,41)));
        currentRank = winningNumber.getWinningRank(lotto);
        Assertions.assertEquals(FIFTH, currentRank);

        //4등 체크
        lotto = new Lotto(new ArrayList<>(List.of(1,2,3,10,40,41)));
        currentRank = winningNumber.getWinningRank(lotto);
        Assertions.assertEquals(FORTH, currentRank);

        //3등 체크
        lotto = new Lotto(new ArrayList<>(List.of(1,2,3,10,11,41)));
        currentRank = winningNumber.getWinningRank(lotto);
        Assertions.assertEquals(THIRD, currentRank);

        //2등 체크
        lotto = new Lotto(new ArrayList<>(List.of(1,2,3,10,11,8)));
        currentRank = winningNumber.getWinningRank(lotto);
        Assertions.assertEquals(SECOND, currentRank);

        //1등 체크
        lotto = new Lotto(new ArrayList<>(List.of(1,2,3,10,11,12)));
        currentRank = winningNumber.getWinningRank(lotto);
        Assertions.assertEquals(FIRST, currentRank);

        //미당첨 체크
        lotto = new Lotto(new ArrayList<>(List.of(1,2,38,39,40,41)));
        currentRank = winningNumber.getWinningRank(lotto);
        Assertions.assertEquals(NOT_WIN, currentRank);
    }
}
