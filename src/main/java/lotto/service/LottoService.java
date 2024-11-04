package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.global.string.AnswerConstants;
import lotto.global.string.ErrorConstants;

public class LottoService {
    private int money;
    private List<List<Integer>> lottoTickets = new ArrayList<>();

    /*
    구매금액에 따른 로또 번호 생성
     */
    public void generateLottoNumbers() {
        int amount = getAmount(money);

        if(amount > 0) {
            while(amount > 0){
                List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                lottoTickets.add(lottoNum);

                amount--;
            }
        }
        printLottoTickets(lottoTickets);
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println(lottoTickets.size() + AnswerConstants.PURCHASE_COMPLETE_MSG);

        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

    public int getAmount(int money) {
        validateAmountIsMultipleOfThousand(money);
        this.money = money;
        return money / 1000;
    }

    private void validateAmountIsMultipleOfThousand(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorConstants.THOUSAND_UNITS_ERROR_MSG);
        }
    }

}
