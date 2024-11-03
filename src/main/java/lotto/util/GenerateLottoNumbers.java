package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.GlobalConstant.MAX_NUMBER;
import static lotto.constant.GlobalConstant.MIN_NUMBER;
import static lotto.constant.GlobalConstant.ROUND_PICK;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.UserLotto;

public class GenerateLottoNumbers {

    public static List<UserLotto> generateLottoNumbers(int ticketQuantity) {
        return lottos(ticketQuantity);
    }

    public static List<UserLotto> lottos(int ticketQuantity) {
        List<UserLotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketQuantity; i++) {
            List<Integer> lottoNumbers = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, ROUND_PICK);
            lottos.add(new UserLotto(lottoNumbers));
        }
        return lottos;
    }

}
