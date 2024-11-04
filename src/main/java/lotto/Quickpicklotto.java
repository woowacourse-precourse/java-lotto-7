package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Quickpicklotto {

    public List<List<Integer>> randomLotto(int number){
        List<List<Integer>> twoDList_lotto =new ArrayList<>();
        for (int i=0;i<number;i++){
            List<Integer> numbers=pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            twoDList_lotto.add(numbers);
        }
       return twoDList_lotto;
    }
}
