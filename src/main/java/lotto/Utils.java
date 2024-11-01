package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Model.Lotto;

public class Utils {
    public static List<Integer> setLottoNums(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public static void printLottos(List<Lotto> lottos){
        System.out.println();
        System.out.println(lottos.size()+Constants.LOTTO_AMOUNT_OUTPUT);
        lottos.stream().forEach(lotto -> lotto.printLotto());
    }
    public static ArrayList<Integer> toArrayList(String nums){
       return Arrays.stream(nums.split(Constants.DELIMITER))
               .map(Integer::parseInt)
               .collect(Collectors.toCollection(ArrayList::new));
    }
}
