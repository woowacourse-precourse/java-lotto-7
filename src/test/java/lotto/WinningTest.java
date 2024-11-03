package lotto;

import lotto.model.Winning;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoPublisher;
import lotto.model.draw_numbers.DrawNumbers;
import lotto.model.number_generator.NumberGenerator;
import lotto.model.number_generator.TestNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningTest {

    private static final int LOTTO_COUNT = 1;

    private LottoPublisher lottoPublisher;

    @BeforeEach
    void beforeEach() {
        int hackedMinWinningNumber = DrawNumberHacker.MIN_WINNING_NUMBER;
        int hackedMaxWinningNumber = DrawNumberHacker.MAX_WINNING_NUMBER;
        NumberGenerator testNumberGenerator = new TestNumberGenerator(hackedMinWinningNumber, hackedMaxWinningNumber);
        this.lottoPublisher = new LottoPublisher(testNumberGenerator);
    }

    @DisplayName("1등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void firstPlaceTest() {
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_FIRST_PLACE.getDrawNumbers();
        Lotto lotto = lottos.getFirst();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.FIRST_PLACE);
    }

    @DisplayName("2등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void secondPlaceTest() {
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_SECOND_PLACE.getDrawNumbers();
        Lotto lotto = lottos.getFirst();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.SECOND_PLACE);
    }

    @DisplayName("3등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void thirdPlaceTest() {
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_THIRD_PLACE.getDrawNumbers();
        Lotto lotto = lottos.getFirst();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.THIRD_PLACE);
    }

    @DisplayName("4등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void fourthPlaceTest() {
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_FOURTH_PLACE.getDrawNumbers();
        Lotto lotto = lottos.getFirst();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.FOURTH_PLACE);
    }

    @DisplayName("5등 당첨을 판단하지 못한 경우 예외가 발생합니다")
    @Test
    void fifthPlaceTest() {
        List<Lotto> lottos = lottoPublisher.publishLotto(LOTTO_COUNT);
        DrawNumbers testDrawNumbers = DrawNumberHacker.HACK_FIFTH_PLACE.getDrawNumbers();
        Lotto lotto = lottos.getFirst();

        Assertions.assertEquals(lotto.checkWinner(testDrawNumbers), Winning.FIFTH_PLACE);
    }
}
