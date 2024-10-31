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
    public Map<Integer,Boolean> matchingNumber = new HashMap<>();
    public final int bonusNumber;



    public PlayLottoGame(ArrayList<Integer> winningNumbers, List<Lotto> lottoList, int bonusNumber) {
        this.lottoList=lottoList;
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
    }

    public Map<Integer, Boolean> play() {
        lottoList.forEach(lotto -> {
            long matchCount = lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            matchingNumber.put((int)matchCount,(winningNumbers.contains(bonusNumber)));
        });
        return matchingNumber;
    }


}
