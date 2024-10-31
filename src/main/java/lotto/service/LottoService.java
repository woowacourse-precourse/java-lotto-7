package lotto.service;

import java.util.List;

public class LottoService {

    public List<Integer> sortLottoNumbersAscending(List<Integer> lottoNumber) {
        for (int i = 0; i < lottoNumber.size() - 1; i++) {
            for (int j = 0; j <lottoNumber.size() - i - 1; j ++) {
                if (lottoNumber.get(j) > lottoNumber.get(j + 1)) {
                    int tmp = lottoNumber.get(j) ;
                    lottoNumber.set(j, lottoNumber.get(j + 1));
                    lottoNumber.set(j + 1, tmp) ;
                }
            }
        }
        return lottoNumber;
    }

    public int calculateLottoQuantities(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
