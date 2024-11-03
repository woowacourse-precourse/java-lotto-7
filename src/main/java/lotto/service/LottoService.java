package lotto.service;

import java.util.List;

public interface LottoService {
    int calculateLottoCount(int price);
    List<Integer> pickLottoNumbers();
}
