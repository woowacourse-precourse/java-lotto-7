package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoRepository {
    List<Lotto> findAllLottoes();

    void addLottoNumbers(List<Integer> lottoNumbers);
}
