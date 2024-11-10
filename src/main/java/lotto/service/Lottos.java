package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public int money;
    public int count;

    public ArrayList<List<Integer>> lotto = new ArrayList<>();

    public Lottos(int money, int count) {
        this.money = money;
        this.count = count;
    }

    public void lottoDraw(){
        for (int i = 0; i < count; i++) {
            //중복되지 않은 정수 6개 반환
            lotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }
}
