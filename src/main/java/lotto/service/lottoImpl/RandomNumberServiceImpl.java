package lotto.service.lottoImpl;

import lotto.model.Lotto;

import java.util.List;

public interface RandomNumberServiceImpl {
    List<Lotto> createRandomNumber(int tickets);
}
