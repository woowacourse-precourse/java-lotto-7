package lotto.model;

import static lotto.common.Constant.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    public RandomNumbers(){
    }

    public static ArrayList<List<Integer>> generateSortedRandomLottoSets(int times){
        ArrayList<List<Integer>> randomNumbers = new ArrayList<>();
        for (int i = ZERO; i < times; i++) {
            randomNumbers.add(generateSortedLottoNumbers());
        }
        return randomNumbers;
    }

    public static List<Integer> generateSortedLottoNumbers(){
        List<Integer> randomNumbers = new ArrayList<>(generateLottoNumbers());
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
    public static List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
