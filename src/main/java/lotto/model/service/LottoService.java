package lotto.model.service;

import java.util.List;

public interface LottoService {

    int calculateLottoCount(int amount);
    List<Integer> extractWinningNumbersFromString(String str);
    List<List<Integer>> lottoNumbers(int cnt);
}
