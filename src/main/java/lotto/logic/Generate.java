package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Generate {
    final static String MESSAGE_GENERATE_AMOUNT = "개를 구매했습니다.";

    public static void run(int n){

        System.out.println(n+MESSAGE_GENERATE_AMOUNT);
        List<Integer> randomNumbers = new ArrayList<>();

        for(int i=0; i<n; i++) {
            randomNumbers=getRandom();
            System.out.println(randomNumbers);
        }


    }

    private static List<Integer> getRandom(){

        return pickUniqueNumbersInRange(1,45,6);

    }

}
