package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public List<List<Integer>> lottoNumbers(int cnt) {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            lottoNumbersList.add(lottoNumber);
        }

        return lottoNumbersList;
    }

}
