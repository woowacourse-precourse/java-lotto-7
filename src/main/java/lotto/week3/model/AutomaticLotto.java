package lotto.week3.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AutomaticLotto {


    public static List<List<Integer>> lottoNumberPrinting(int money){
        List<List<Integer>> answer = new ArrayList<>();
        if(money % 1000 != 0){
            for(int i = 0; i < money/1000; i++){
                List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                answer.add(integers);
            }
        }
        return answer;
    }
}
