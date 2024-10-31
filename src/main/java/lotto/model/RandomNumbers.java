package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbers {
    public RandomNumbers(){

    }
    public static List<Integer> randomNumberGenerator(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
