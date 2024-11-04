package lotto.service;

import lotto.Lotto;

import java.util.List;

public class OutputService {
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
