package lotto;

import java.util.ArrayList;
import java.util.List;

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
        int bonusNum = io.inputBonusNumber(jackpotNumbers);

        // 당첨 통계 출력
    }

    private static List<Integer> makeRandomLotto(){
        List<Integer> lotto = new ArrayList<Integer>();
        for(int i=0; i<6; i++){
            int randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,45);
            lotto.add(randomNum);
        }
        return lotto;
    }
}
