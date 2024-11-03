package lotto.model;

import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppConstant.LOTTO_UNIT_PRICE;
import static lotto.common.AppErrorType.DIVIDED_BY_PRICE_ERROR;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> buyLottoByPrice(int money) {
        validateDivideByUnit(money);
        int count = money / LOTTO_UNIT_PRICE;
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int start = LOTTO_START_RANGE;
            int end = LOTTO_END_RANGE;
            int numberCount = LOTTO_NUMBER_COUNT;

            List<Integer> pickedNumberList = Randoms.pickUniqueNumbersInRange(start, end, numberCount);
            lottoList.add(new Lotto(pickedNumberList));
        }

        return lottoList;
    }

    private void validateDivideByUnit(int money) {
        if (money <= 0 || money % LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(DIVIDED_BY_PRICE_ERROR.getMessage());
        }
    }

    public WinningLotto generateWinningLotto(Lotto lotto, int winningBonusNumber) {
        return new WinningLotto(lotto, winningBonusNumber);
    }

    public LottoStatistic generateLottoStatistic(WinningLotto winningLotto, List<Lotto> lottoList) {
        List<LottoRank> rankList = lottoList.stream()
                .map(lotto -> lotto.getRankFrom(winningLotto))
                .toList();
        return new LottoStatistic(rankList);
    }
}
