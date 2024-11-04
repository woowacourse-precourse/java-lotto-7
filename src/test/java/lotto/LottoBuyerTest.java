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

    @DisplayName("로또_랭크_리스트가_번호를_3개이상맞췄을경우에만_제대로_생성됐는지_확인")
    @Test
    void 로또_랭크_리스트가_번호를_3개이상맞췄을경우에만_제대로_생성됐는지_확인() {
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

    @Test
    @DisplayName("LottoRank의_값이_정상적으로_list에_담기는지_확인")
    void LottoRank의_값이_정상적으로_list에_담기는지_확인() {
        LottoBuyer buyer = new LottoBuyer(0);
        buyer.addManualLotto(List.of(1, 2, 3, 4, 5, 6));
        buyer.addManualLotto(List.of(1, 2, 3, 4, 5, 7));
        buyer.setWinningLottoAndBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        ArrayList<LottoRank> ranks = buyer.makeLottoRank();

        assertTrue(ranks.contains(LottoRank.FIRST));
        assertTrue(ranks.contains(LottoRank.SECOND));
    }

    @Test
    @DisplayName("LottoRank의_값이_정상적으로_반환되는지_확인")
    void LottoRank의_값이_정상적으로_반환되는지_확인() {
        LottoBuyer buyer = new LottoBuyer(0);
        buyer.addManualLotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        buyer.setWinningLottoAndBonusNumber(winningLotto, 7);

        assertThat(LottoRank.FIRST).isEqualTo(buyer.specifyLottoRank(6, buyer.getLottos().get(0)));
        assertThat(LottoRank.SECOND).isEqualTo(buyer.specifyLottoRank(5, buyer.getLottos().get(0)));
    }

    @Test
    @DisplayName("보너스_번호에_따라_2등_3등_정상반환_되는지_확인")
    void 보너스_번호에_따라_2등_3등_정상반환_되는지_확인() {
        LottoBuyer buyer = new LottoBuyer(5);
        Lotto lottoWithBonus = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lottoWithoutBonus = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        buyer.setWinningLottoAndBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertThat(LottoRank.SECOND).isEqualTo(buyer.checkBonusNumber(lottoWithBonus));
        assertThat(LottoRank.THIRD).isEqualTo(buyer.checkBonusNumber(lottoWithoutBonus));
    }

    @Test
    @DisplayName("상금_반환_확인")
    void 상금_반환_확인() {
        LottoBuyer buyer = new LottoBuyer(0);
        buyer.addManualLotto(List.of(1, 2, 3, 4, 5, 6));
        buyer.setWinningLottoAndBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        long totalPrize = buyer.calculateTotalPrize();
        assertThat(LottoRank.FIRST.getPrizeAmount()).isEqualTo(totalPrize);
    }

    @Test
    @DisplayName("총_수익률_반환_확인")
    void 총_수익률_반환_확인() {
        LottoBuyer buyer = new LottoBuyer(0);
        buyer.addManualLotto(List.of(1, 2, 3, 4, 5, 6));
        buyer.setWinningLottoAndBonusNumber(new Lotto(List.of(4, 5, 6, 11, 12, 13)), 7);

        String formattedPrize = buyer.prizeFormat(LottoRank.FIFTH.getPrizeAmount());

        assertThat("500.0").isEqualTo(formattedPrize);
    }


}