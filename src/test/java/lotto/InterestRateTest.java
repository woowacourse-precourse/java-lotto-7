package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.prize.WinningStatus;
import lotto.domain.statistic.Statistic;
import lotto.domain.user.User.UserLottoInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InterestRateTest {

    Statistic statistic;
    List<UserLottoInfo> userLottoInfos;
    Integer purchaseCost;

    @BeforeEach
    void setUp() {
        statistic = new Statistic();

        userLottoInfos = new ArrayList<>();
        userLottoInfos.add(new UserLottoInfo(new Lotto(List.of(1, 2, 3, 4, 5, 6)), WinningStatus.fifth));
        userLottoInfos.add(new UserLottoInfo(new Lotto(List.of(1, 2, 3, 4, 5, 7)), WinningStatus.fifth));
        userLottoInfos.add(new UserLottoInfo(new Lotto(List.of(1, 2, 3, 4, 8, 9)), WinningStatus.fifth));
        userLottoInfos.add(new UserLottoInfo(new Lotto(List.of(1, 2, 3, 10, 11, 12)), WinningStatus.fifth));
        userLottoInfos.add(new UserLottoInfo(new Lotto(List.of(1, 2, 3, 14, 15, 16)), WinningStatus.fourth));

        purchaseCost = 5000;
    }

    @DisplayName("수익률_계산")
    @Test
    void 수익률_계산() {
        double interestRate = statistic.getInterestRate(userLottoInfos, purchaseCost);

        assertThat(interestRate).isEqualTo(1400.0);
    }

}
