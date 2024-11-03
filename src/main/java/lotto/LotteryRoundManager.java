package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryRoundManager {
    private final int UNIT_COST = 1000;
    private final String ERROR_MESSAGE = "[ERROR] ";

    private int cost;
    private List<Integer> winningNumber;
    private int bonusNumber;


    public PurchasedLotto purchaseLotto(int cost) {
        if (cost < 0 || cost > 200000000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "금액은 0원 이상 20억원 이하로 입력되어야 합니다.");
        }
        if (cost % UNIT_COST != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "금액은 1000원 단위로 입력되어야 합니다.");
        }
        return PurchasedLotto.generateLottos(
                cost / UNIT_COST,
                () -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
    }

}
