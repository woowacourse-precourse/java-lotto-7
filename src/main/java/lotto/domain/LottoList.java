package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        // 방어적 copy
        this.lottoList = new ArrayList<>(lottoList);
    }

    public static LottoList create(List<Lotto> lottoList) {
        return new LottoList(lottoList);
    }

    public long getSize() {
        return lottoList.size();
    }

    // 총 수익 및 LottoPrize 리스트 반환
    public LottoResult getLottoResult(WinningNumbers winningNumbers, BonusNumber bonusNumber, InputMoney inputMoney) {
        long totalEarning = 0;
        List<LottoPrize> lottoPrizes = new ArrayList<>();

        for (Lotto lotto : lottoList) {
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
        for (Lotto lotto : lottoList) {
            stringJoiner.add(lotto.result());
        }
        return stringJoiner.toString();
    }
}
