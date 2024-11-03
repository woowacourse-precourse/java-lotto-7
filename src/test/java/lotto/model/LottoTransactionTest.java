package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTransactionTest {
  private LottoTransaction lottoTransaction;

  @BeforeEach
  public void setUp() {
    lottoTransaction = new LottoTransaction();
  }

  @Test
  public void 투입한_금액_확인() {
    int amount = 10000;
    lottoTransaction.setAmount(amount);
    assertEquals(amount, lottoTransaction.getAmount(), "투입 금액 불일치");
  }

  @Test
  public void 구입한_로또_저장_확인() {
    List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
    );

    lottoTransaction.setPurchasedLottos(lottos);
    assertEquals(lottos, lottoTransaction.getPurchasedLottos(), "저장을 원한 로또와 저장된 로또 불일치");
  }

  @Test
  public void 매칭_카운트_추가_테스트() {
    PrizeRank prizeRank = PrizeRank.FIRST;

    lottoTransaction.addMatchCount(prizeRank);
    lottoTransaction.addMatchCount(prizeRank);

    EnumMap<PrizeRank, Integer> matchCounts = lottoTransaction.getMatchCounts();
    assertEquals(2, matchCounts.get(prizeRank).intValue());
  }

  @Test
  public void 초기_매칭_카운트_테스트() {
    EnumMap<PrizeRank, Integer> matchCounts = lottoTransaction.getMatchCounts();

    for (PrizeRank rank : PrizeRank.values()) {
      assertEquals(0, matchCounts.get(rank).intValue());
    }
  }


}