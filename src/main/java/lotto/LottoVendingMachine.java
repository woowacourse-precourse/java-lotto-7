package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoVendingMachine {

    public List<Lotto> purchaseLottos(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        validateMoney(userInput);
        int money = Integer.parseInt(userInput);
        List<Lotto> lottos = new ArrayList<>();

        for(int i=1;i<=(money/1000);i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }

    public void validateMoney(String userInput){

    }
}
