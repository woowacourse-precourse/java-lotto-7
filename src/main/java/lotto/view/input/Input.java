package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;

public class Input {

    public String purchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }


    public HashMap<Integer, List<Integer>> getLottoNumbers(int getPurchaseAccount) {
        System.out.println(getPurchaseAccount + "개를 구매했습니다.");

        HashMap<Integer, List<Integer>> getLottoNumbers = new HashMap<>();

        for(int i = 0 ; i< getPurchaseAccount; i++){
            getLottoNumbers.put(i, Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList());
            System.out.println(getLottoNumbers.get(i));
        }


        return getLottoNumbers;
    }

}
