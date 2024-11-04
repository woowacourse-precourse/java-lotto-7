package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LottoGenerator {
    int lottoCount;
    int money;
    List<Lotto> lottoList = new ArrayList<>();
    Boolean keepGetLottoList = true;

    void getTicketCount(String input) throws IllegalArgumentException{
        if (input == null) throw new IllegalArgumentException("[ERROR] 입금액이 입력되지 않았습니다.");

        try {
            money = Integer.parseInt((input));
            Integer count = (int)(money/10);
            if ((money%1000) != 0|| money <= 0) throw new IllegalArgumentException("[ERROR] 입금액이 올바르지 않습니다. 1000 단위로 입력해주세요.");

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

    List<Lotto> getLottoList(String input) throws IllegalArgumentException{
        try{
            this.getTicketCount(input);
            keepGetLottoList = false;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            //throw new IllegalArgumentException();
            throw e;
        }
        return this.generateLotto(this.lottoCount);
    }

    void purchaseLotto(){
        while(keepGetLottoList){
            try{
                String money = getMoney();
                getLottoList(money);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }

        System.out.println(lottoCount+"개를 구매했습니다.");
        for (Lotto lotto: lottoList){
            Integer[] arr = lotto.getNumbers().toArray(new Integer[6]);
            System.out.println(Arrays.toString(arr));
        }
    }

    static String getMoney(){

        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();

        return input;
    }
}
