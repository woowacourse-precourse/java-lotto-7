package lotto.utils;

import lotto.model.Lotto;

import java.util.List;

public class CheckLotto {

    public static int countEqualLottoNumbers(Lotto myLotto,
                                             List<Integer> winningLotto){

        return (int) myLotto.getNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }

    public static boolean checkContainsBonusNumber(Lotto myLotto,
                                                   int bonusNumber){
        return myLotto.getNumbers()
                .contains(bonusNumber);
    }

}
