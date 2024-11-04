package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        IO io = new IO();
        Customer customer = new Customer();

        int buyCount = io.inputBuyLottoPrice();
        for(int i = 0; i < buyCount; i++) {
            Lotto buyLotto = new Lotto(makeRandomLotto());

            customer.addLotto(buyLotto);
        }
        customer.printCustomerLotto();

        List<Integer> jackpotNumbers = io.inputCorrectNumbers();
        Lotto jackpotLotto = new Lotto(jackpotNumbers);
        int bonusNum = io.inputBonusNumber(jackpotNumbers);
        customer.setCorrectNumbers(jackpotLotto,bonusNum);
        customer.checkJackpot();
        customer.printJackpotList();
    }

    private static List<Integer> makeRandomLotto(){
        List<Integer> lotto = new ArrayList<Integer>();
        for(int i=0; i<6; i++){
            int randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,45);
            lotto.add(randomNum);
        }

        Set<Integer> set = new HashSet<>(lotto);
        if (set.size() != lotto.size()) {
            return makeRandomLotto();
        }
        return lotto;
    }
}
