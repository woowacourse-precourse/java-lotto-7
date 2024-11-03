package lotto;

import lotto.model.Winning;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto_result.DrawNumbers;
import lotto.number_generator.NumberGenerator;
import lotto.number_generator.TestNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningTest {
    private final int hackedMinWinningNumber = Integer.parseInt(DrawNumberHacker.MIN_WINNING_NUMBER);
    private final int hackedMaxWinningNumber = Integer.parseInt(DrawNumberHacker.MAX_WINNING_NUMBER);
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void beforeEach() {
        NumberGenerator testNumberGenerator = new TestNumberGenerator(hackedMinWinningNumber, hackedMaxWinningNumber);
        this.lottoGenerator = new LottoGenerator(testNumberGenerator);
    }

    @DisplayName("1등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void firstPlaceTest() {
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        Lotto lotto = lottoGenerator.generate(lottoNumbers);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_FIRST_PLACE.getDrawNumbers();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.FIRST_PLACE);
    }

    @DisplayName("2등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void secondPlaceTest() {
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        Lotto lotto = lottoGenerator.generate(lottoNumbers);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_SECOND_PLACE.getDrawNumbers();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.SECOND_PLACE);
    }

    @DisplayName("3등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void thirdPlaceTest() {
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        Lotto lotto = lottoGenerator.generate(lottoNumbers);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_THIRD_PLACE.getDrawNumbers();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.THIRD_PLACE);
    }

    @DisplayName("4등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void fourthPlaceTest() {
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        Lotto lotto = lottoGenerator.generate(lottoNumbers);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_FOURTH_PLACE.getDrawNumbers();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.FOURTH_PLACE);
    }

    @DisplayName("5등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void fifthPlaceTest() {
        List<Integer> lottoNumbers = lottoGenerator.createNumbers();
        Lotto lotto = lottoGenerator.generate(lottoNumbers);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_FIFTH_PLACE.getDrawNumbers();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.FIFTH_PLACE);
    }
}
