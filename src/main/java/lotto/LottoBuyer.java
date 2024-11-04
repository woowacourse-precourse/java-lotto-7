package lotto;

import static lotto.Lotto.LOTTO_PRICE;
import static lotto.LottoRank.LOTTO_RANKS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusLottoNumber;
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";

    public LottoBuyer(long lottoCount) {
        buyLotto(lottoCount);
    }

    private void buyLotto(long lottoCount) {
        for (long i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
            lotto.printLotto();
        }
    }

    public void addManualLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
    }

    public void setWinningLottoAndBonusNumber(Lotto winningLotto, int bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public ArrayList<LottoRank> makeLottoRank() {
        ArrayList<LottoRank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int duplNumber = winningLotto.findDuplicateNumber(lotto.getNumbers());
            LottoRank lottoRank = specifyLottoRank(duplNumber, lotto);
            if (lottoRank != null) {
                ranks.add(specifyLottoRank(duplNumber, lotto));
            }
        }
        return ranks;
    }

    public LottoRank specifyLottoRank(int duplNumber, Lotto lotto) {
        if (duplNumber == 6) {
            return LottoRank.FIRST;
        }
        if (duplNumber == 5) {
            return checkBonusNumber(lotto);
        }
        if (duplNumber == 4) {
            return LottoRank.FOURTH;
        }
        if (duplNumber == 3) {
            return LottoRank.FIFTH;
        }
        return null;
    }

    public LottoRank checkBonusNumber(Lotto lotto) {
        boolean matchBonus = lotto.getNumbers().contains(bonusLottoNumber);
        if (matchBonus) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    public long calculateTotalPrize() {
        ArrayList<LottoRank> ranks = makeLottoRank();
        long totalPrize = 0;
        for (int i = LOTTO_RANKS.length - 1; i >= 0; i--) {
            LottoRank lottoRank = LOTTO_RANKS[i];
            long count = ranks.stream()
                    .filter(lottoRank::equals)
                    .count();
            totalPrize += lottoRank.countPrize(count);
        }
        return totalPrize;
    }

    public void printTotalPrize() {
        System.out.printf("%n" + WINNING_STATISTICS + "%n---%n");
        long totalPrize = calculateTotalPrize();
        System.out.printf(RATE_OF_RETURN, prizeFormat(totalPrize));
    }

    public String prizeFormat(long totalPrize) {
        long buyPrice = lottos.size();
        long totalPrizeForPercent = totalPrize * 100;  // 퍼센트(%) 계산을 위해 상금에 100을 곱한다.
        String format = String.format("%.1f", totalPrizeForPercent / (lottos.size() * (double) LOTTO_PRICE));
        return format;
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }
}
