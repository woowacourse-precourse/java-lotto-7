package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {

    public ArrayList<Lotto> generateLottoList(int price) {
        ArrayList<Lotto> myLotto = new ArrayList<>();
        int numberOfTickets = countTickets(price);
        printConfirmMessage(numberOfTickets);
        for (int i = 0; i < numberOfTickets; i++) {
            myLotto.add(generateMyLotto());
        }
        return myLotto;
    }

    public int countTickets(int price) {
        return (price / 1000);
    }

    public Lotto generateMyLotto() {
        while (true) {
            try {
                List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                Lotto singleLotto = new Lotto(lottoNumbers);
                printLotto(singleLotto);
                return singleLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printConfirmMessage(int numberOfTickets) {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
    }

    public void printLotto(Lotto singleLotto) {
        System.out.println("[" + singleLotto.getNumberString() + "]");
    }
}
