package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class LottoGenerator {

    private final int givenAmount;
    private final int numberOfLottos;
    private final List<Lotto> lottoList;

    public LottoGenerator(int givenAmount) {
        this.givenAmount = givenAmount;
        numberOfLottos = calculateNumberOfLottoTickets();
        lottoList = generateLotto(numberOfLottos);
        printLotto();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private int calculateNumberOfLottoTickets() {
        return givenAmount / 1000;
    }

    private List<Lotto> generateLotto(int number) {
        List<Lotto> lottoList = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private void printLotto() {
        System.out.println(numberOfLottos + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
