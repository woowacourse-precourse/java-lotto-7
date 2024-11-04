package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static void checkEmptyInput(String userInputcarsName){
        if(userInputcarsName.isEmpty()) throw new IllegalArgumentException("[ERROR] 빈문자열이 들어왔습니다.");
        if(userInputcarsName == null) throw new IllegalArgumentException("[ERROR] null값이 들어왔습니다.");
    }

    public static List<Integer> getRandomNumbers(int minNum, int maxNum, int numCount){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(minNum, maxNum, numCount));
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }
}
