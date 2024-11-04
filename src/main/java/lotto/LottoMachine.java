package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    static final int START_NUM = 1;
    static final int END_NUM = 45;
    static final int BALLS = 6;


    public void action(int count, MyLotto myLotto) {
        int index = 0;
        while (index++ < count) {
            myLotto.add(randomLottoNumbers());
        }
    }

    private Lotto randomLottoNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, BALLS));
    }


}
