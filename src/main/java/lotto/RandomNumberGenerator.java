package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> genreateNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Arrays.sort(new List[]{numbers});
        return numbers;
    }
}
