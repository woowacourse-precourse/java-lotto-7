package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueModel {
    public static ArrayList<Integer> getRandomLottoNumbers() {
        return (ArrayList<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> sortNumbers (List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }



}
