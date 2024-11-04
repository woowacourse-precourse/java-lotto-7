package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LottoGenerator {
    int lottoCount;
    int money;
    List<Lotto> lottoList = new ArrayList<>();

    void getTicketCount(String input) throws Exception{
        if (input == null) throw new IllegalStateException("[ERROR] 입금액이 입력되지 않았습니다.");
        if (input.length()<4) throw new IllegalArgumentException("[ERROR] 입금액이 올바르지 않습니다. 1000 단위로 입력해주세요.");
        try {
            money = Integer.parseInt((input));
            this.lottoCount = money/1000;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입금액이 올바르지 않습니다. 1000 단위로 입력해주세요.");
        }
    }

    List<Lotto> generateLotto(int totalNum){
        for (int i = 0; i<totalNum; i++){
            List<Integer> numList = new ArrayList<>();
            numList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto a = new Lotto(numList);
            lottoList.add(a);
        }
        return lottoList;
    }

    List<Lotto> getLottoList(String input) throws Exception {
        this.getTicketCount(input);

        return this.generateLotto(this.lottoCount);
    }

    void purchaseLotto(String input) throws Exception {
        getLottoList(input);
        System.out.println(lottoCount+"개를 구매했습니다.");
        for (Lotto lotto: lottoList){
            Integer[] arr = lotto.getNumbers().toArray(new Integer[6]);
            System.out.println(Arrays.toString(arr));
        }
    }
}
