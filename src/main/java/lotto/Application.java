package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.LottoData.*;


public class Application {
    public static void main(String[] args) {

        List<Integer> winPrice = Randoms.pickUniqueNumbersInRange(START_NUM.getNum(), END_NUM.getNum(), BALLS.getNum());
        Lotto lotto = new Lotto(winPrice);
    }
}
