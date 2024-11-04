package lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomNumberCreator {

    public List<Integer> createRandomNum(int start, int end, int count){
        List<Integer> randomNums = new ArrayList<>(Randoms.pickUniqueNumbersInRange(start, end, count));
        randomNums.sort(Comparator.naturalOrder());
        return randomNums;
    }
}
