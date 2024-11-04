package lotto.domain;

import global.errorMessage.CommonErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        // 방어적 copy
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos create(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public long getSize() {
        return lottos.size();
    }

    // 총 수익 및 LottoPrize 리스트 반환
    public LottoResult getLottoResult(WinningNumbers winningNumbers, BonusNumber bonusNumber, InputMoney inputMoney) {
        long totalEarning = 0;
        List<LottoPrize> lottoPrizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = winningNumbers.countMatchingNumbers(lotto);
            boolean containBonus = lotto.containBonusNumber(bonusNumber);
            LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, containBonus);

            if (lottoPrize != LottoPrize.NONE) {
                lottoPrizes.add(lottoPrize);
                totalEarning += lottoPrize.getPrize();
            }
        }

        return LottoResult.of(lottoPrizes, totalEarning,inputMoney);
    }

    public String result() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Lotto lotto : lottos) {
            stringJoiner.add(lotto.result());
        }
        return stringJoiner.toString();
    }
}
