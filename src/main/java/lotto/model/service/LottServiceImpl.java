package lotto.model.service;

import java.util.ArrayList;
import java.util.List;

public class LottServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(int amount) {
        return amount / 1000;
    }

    @Override
    public List<Integer> extractWinningNumbersFromString(String str) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : str.split(",")) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

}
