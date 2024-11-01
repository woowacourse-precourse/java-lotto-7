package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Lotto mainLotto = LottoDraw.inputWinningNumbers();
        mainLotto.bonusNumber = LottoDraw.inputBonusNumber(mainLotto);

        //System.out.println(mainLotto.toString());
    }

}


