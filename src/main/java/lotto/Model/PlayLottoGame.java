package lotto.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class PlayLottoGame {
    public ArrayList<Integer> winningNumbers;
    public List<Lotto> lottoList;
    public Map<Integer,Integer> matchingNumber = new HashMap<>();



    public PlayLottoGame(ArrayList<Integer> winningNumbers, List<Lotto> lottoList) {
        this.lottoList=lottoList;
        this.winningNumbers=winningNumbers;
        for (int i = 0; i <= 6; i++) {
            matchingNumber.put(i, 0);
        }
    }

    public Map<Integer, Integer> play() {
        lottoList.forEach(lotto -> {
            long matchCount = lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            matchingNumber.put((int)matchCount,matchingNumber.get((int)matchCount)+1);
        });
        return matchingNumber;
    }


}
