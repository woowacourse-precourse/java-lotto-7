package lotto.enums;

import java.util.Arrays;
import java.util.function.BiPredicate;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public enum LottoRank {

    FAIL("", 0,
            (lottoMatchCount, bonusNumberMatch) -> {
                if (lottoMatchCount < 3) {
                    return true;
                }
                return false;
            }),
    FIFTH_PLACE("3개 일치 (5,000원) - %d개", 5_000,
            (lottoMatchCount, bonusNumberMatch) -> {
                if (lottoMatchCount == 3) {
                    return true;
                }
                return false;
            }),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개", 50_000,
            (lottoMatchCount, bonusNumberMatch) -> {
                if (lottoMatchCount == 4) {
                    return true;
                }
                return false;
            }),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개", 1_500_000,
            (lottoMatchCount, bonusNumberMatch) -> {
                if (lottoMatchCount == 5 && !bonusNumberMatch) {
                    return true;
                }
                return false;
            }),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30_000_000,
            (lottoMatchCount, bonusNumberMatch) -> {
                if (lottoMatchCount == 5 && bonusNumberMatch) {
                    return true;
                }
                return false;
            }),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개", 2_000_000_000,
            (lottoMatchCount, bonusNumberMatch) -> {
                if (lottoMatchCount == 6) {
                    return true;
                }
                return false;
            });


    final String message;
    final int prizeMoney;
    final BiPredicate<Integer, Boolean> increamentIfMatchCondition;

    LottoRank(String message, int prizeMoney, BiPredicate<Integer, Boolean> increamentIfMatchCondition) {
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.increamentIfMatchCondition = increamentIfMatchCondition;
    }

    public static LottoRank ofLottoAndWinningLottoAndBonusNumber(
            Lotto lotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        int lottoMatchCount = lotto.getMatchCountWinningLotto(winningLotto);
        boolean bonusNumberMatch = lotto.isMatchBonusNumber(bonusNumber);

        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.increamentIfMatchCondition.test(lottoMatchCount, bonusNumberMatch))
                .findAny()
                .orElse(FAIL);
    }

    public String getMessage() {
        return message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
