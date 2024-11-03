package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("새로운_로또_생성시_무작위로_생성된_로또값이_정상적으로_출력되는지_확인")
    @Test
    void 새로운_로또_생성시_무작위로_생성된_로또값이_정상적으로_출력되는지_확인() {
        LottoBuyer lottoBuyer = new LottoBuyer(10);

        ArrayList<Lotto> lottos = lottoBuyer.getLottos();
        String output = outContent.toString().trim();
        for (Lotto lotto : lottos) {
            String randomNumbers = lotto.getNumbers().toString();

            assertTrue(output.contains(randomNumbers));

        }
    }

    @Test
    void 로또_랭크_리스트가_3개이상맞췄을경우에만_제대로_생성됐는지_확인() {
        LottoBuyer lottoBuyer = new LottoBuyer(10);
        List<Integer> correctLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoBuyer.setWinningLottoAndBonusNumber(new Lotto(correctLotto), bonusNumber);
        ArrayList<LottoRank> lottoRanks = lottoBuyer.makeLottoRank();

        int rankSize = 0;
        for (Lotto lotto : lottoBuyer.getLottos()) {
            if (lotto.findDuplicateNumber(correctLotto) >= 3) {
                rankSize++;
            }
        }

        assertThat(rankSize).isEqualTo(lottoRanks.size());
    }


}