package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputUtil {
    private static final String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void printPurchaseAmountMessage(int count){
        System.out.println("\n"+count+PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printUserLotto(List<List<Integer>> lottoNumbers){
        for(List<Integer> lotto:lottoNumbers){
            System.out.println(lotto);
        }
    }

    public static List<List<Integer>> generateLottoNumbers(int count){
        List<List<Integer>> lottoNumbers= new ArrayList<>();
        for(int i = 0; i < count; i++){
            List<Integer> lotto = generateSingleLotto();
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }

    private static List<Integer> generateSingleLotto(){
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < LOTTO_NUMBER_COUNT){
            int number = Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
            if(!numbers.contains(number)) numbers.add(number);
        }
        Collections.sort(numbers);
        return numbers;
    }
}
