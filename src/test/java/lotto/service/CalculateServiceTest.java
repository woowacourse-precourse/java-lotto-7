package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.DrawNumbers;
import lotto.enums.IntEnum;
import lotto.enums.ListEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateServiceTest {
    private static final List<Integer> expectedMoneyGroup = List.of(5000, 50000, 1500000, 30000000, 2000000000);
    private static final Double expectedRatio = 2031500.0;

    private static DrawNumbers winningNumber;
    private static List<DrawNumbers> drawSets;
    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();

        winningNumber = new DrawNumbers(
                ListEnum.WINNING_LOTTO_NUMBERS.getList(),
                IntEnum.WINNING_BONUS_NUMBERS.getNumber()
        );

        //random drawn numbers set
        drawSets = ListEnum.getDrawSets();
    }

    @DisplayName("당첨 금액 리스트 일치 테스트")
    @Test
    void calculatePrizeMoney() {
        //when
        List<Integer> result = calculateService.calculatePrizeMoney(winningNumber, drawSets);
        //then
        assertEquals(expectedMoneyGroup, result);

    }

    @DisplayName("수익률 일치 테스트")
    @Test
    void calculateProfitRatio() {
        //given
        int purchaseAmount = 100000;
        List<Integer> prizeGroup = calculateService.calculatePrizeMoney(winningNumber, drawSets);
        //when
        Double result = calculateService.calculateProfitRatio(prizeGroup, purchaseAmount);
        //then
        assertEquals(expectedRatio, result);
    }
}