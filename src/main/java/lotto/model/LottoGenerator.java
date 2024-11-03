package lotto.model;

import static lotto.common.LottoConstant.MAX_NUMBER;
import static lotto.common.LottoConstant.MIN_NUMBER;
import static lotto.common.LottoConstant.TICKET_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public Lotto generateTicket(){
        return new Lotto(generateSixNumber());
    }

    private List<Integer> generateSixNumber(){
        List<Integer> sixNumbers =  Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, TICKET_SIZE)
                        .stream()
                        .sorted()
                        .toList();

        return sixNumbers;
    }
}