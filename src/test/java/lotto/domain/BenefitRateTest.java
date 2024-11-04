package lotto.domain;


import lotto.model.BoughtLottos;
import lotto.model.condition.SpendingMoney;
import lotto.model.outcome.CountByPrizeGrade;
import lotto.model.outcome.LottoBenefitRate;
import lotto.model.winlotto.BasicWinLottoNumbers;
import lotto.model.winlotto.BonusWinLottoNumber;
import lotto.model.winlotto.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenefitRateTest {
    SpendingMoney spendingMoney = new SpendingMoney("7000");
    BasicWinLottoNumbers basicWinLottoNumbers =
            new BasicWinLottoNumbers("1,2,3,4,5,6");
    BonusWinLottoNumber bonusWinLottoNumber =
            new BonusWinLottoNumber("7", basicWinLottoNumbers);
    WinLotto winLotto = new WinLotto(basicWinLottoNumbers, bonusWinLottoNumber);

    @Test
    @DisplayName("소수점 아래 2번째 자리가 5보다 작을 때")
    void test1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    BoughtLottos boughtLottos =
                            BoughtLottos.getFromSpendingMoney(spendingMoney);
                    CountByPrizeGrade gradesCount =
                            CountByPrizeGrade.getOfBoughtAndWinLotto(boughtLottos, winLotto);
                    LottoBenefitRate rate =
                            LottoBenefitRate
                                    .getOfCountByGradeAndSpendMoney(gradesCount,
                                            spendingMoney.get());
                    assertEquals("21571.4", rate.toString());

                },
                List.of(1,2,3,10,11,12), // 3개 일치 (상금 : 5,000원)
                List.of(1,2,3,10,11,12), // 3개 일치 (상금 : 5,000원)
                List.of(1,2,3,4,5,10),   // 5개 일치 (상금 : 1,500,000원)
                List.of(10,11,12,13,14,15), // 0개 일치
                List.of(10,11,12,13,14,15), // 0개 일치
                List.of(10,11,12,13,14,15), // 0개 일치
                List.of(10,11,12,13,14,15)  // 0개 일치
        );
    }

    @Test
    @DisplayName("소수점 아래 2번째 자리가 5보다 클 때")
    void test2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    BoughtLottos boughtLottos =
                            BoughtLottos.getFromSpendingMoney(spendingMoney);
                    CountByPrizeGrade gradesCount =
                            CountByPrizeGrade.getOfBoughtAndWinLotto(boughtLottos, winLotto);
                    LottoBenefitRate rate =
                            LottoBenefitRate
                                    .getOfCountByGradeAndSpendMoney(gradesCount,
                                            spendingMoney.get());
                    assertEquals("21642.9", rate.toString());

                },
                List.of(1,2,3,10,11,12), // 3개 일치 (상금 : 5,000원)
                List.of(1,2,3,10,11,12), // 3개 일치 (상금 : 5,000원)
                List.of(1,2,3,10,11,12), // 3개 일치 (상금 : 5,000원)
                List.of(1,2,3,4,5,10),   // 5개 일치 (상금 : 1,500,000원)
                List.of(10,11,12,13,14,15), // 0개 일치
                List.of(10,11,12,13,14,15), // 0개 일치
                List.of(10,11,12,13,14,15)  // 0개 일치
        );
    }
}
