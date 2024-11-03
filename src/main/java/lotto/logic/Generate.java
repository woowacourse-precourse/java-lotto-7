package lotto.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Generate {
    final static String MESSAGE_GENERATE_AMOUNT = "개를 구매했습니다.";

    public static List<List<Integer>> run(int n){

        System.out.println(n+MESSAGE_GENERATE_AMOUNT);
        List<List<Integer>> lottoNumbersList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            List<Integer> randomNumbers = getRandom();
            Collections.sort(randomNumbers);
            lottoNumbersList.add(randomNumbers);
            System.out.println(randomNumbers);
        }

     return lottoNumbersList;
    }

    private static List<Integer> getRandom(){

        return new ArrayList<>(pickUniqueNumbersInRange(1,45,6));

    }

}
