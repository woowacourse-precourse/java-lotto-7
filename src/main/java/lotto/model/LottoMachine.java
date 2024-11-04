package lotto.model;

import lotto.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<List<Integer>> generateLotto(int purchase) {
        List<List<Integer>> lottoLists = new ArrayList<>();
        int count = purchase / 1000;

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = RandomNumber.getRandomNumber();
            lottoLists.add(lottoNumbers);
        }

        return lottoLists;
    }
}
