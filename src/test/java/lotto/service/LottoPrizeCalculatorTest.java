package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class LottoPrizeCalculatorTest {

    private LottoPrizeCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new LottoPrizeCalculator();
    }

    @Test
    public void testFirstPrize() {
        int matchedNumbers = 6;
        boolean bonusMatched = false;
        int prize = calculator.calculatePrize(matchedNumbers, bonusMatched);
        assertEquals(2_000_000_000, prize);
    }

    @Test
    public void testSecondPrize() {
        int matchedNumbers = 5;
        boolean bonusMatched = true;
        int prize = calculator.calculatePrize(matchedNumbers, bonusMatched);
        assertEquals(30_000_000, prize);
    }

    @Test
    public void testThirdPrize() {
        int matchedNumbers = 5;
        boolean bonusMatched = false;
        int prize = calculator.calculatePrize(matchedNumbers, bonusMatched);
        assertEquals(1_500_000, prize);
    }

    @Test
    public void testFourthPrize() {
        int matchedNumbers = 4;
        boolean bonusMatched = false;
        int prize = calculator.calculatePrize(matchedNumbers, bonusMatched);
        assertEquals(50_000, prize);
    }

    @Test
    public void testFifthPrize() {
        int matchedNumbers = 3;
        boolean bonusMatched = false;
        int prize = calculator.calculatePrize(matchedNumbers, bonusMatched);
        assertEquals(5_000, prize);
    }

    @Test
    public void testNoPrize() {
        int matchedNumbers = 2;
        boolean bonusMatched = false;
        int prize = calculator.calculatePrize(matchedNumbers, bonusMatched);
        assertEquals(0, prize);
    }}
