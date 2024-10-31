package lotto.service;

import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;
    private final int ONE_LOTTO_PRICE = 1000;

    public LottoServiceImpl(LottoRepository lottoRepositoryImpl) {
        this.lottoRepository = lottoRepositoryImpl;
    }

    @Override
    public void play(int amount, List<Integer> winNumbers, int bonusNumber) {
        generateLottoNumbers(amount / ONE_LOTTO_PRICE);

    }

    private void generateLottoNumbers(int number) {
        while (number-- > 0) {
            lottoRepository.addLottoNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList()));
        }
    }

    @Override
    public List<Lotto> showLottoList() {
        return lottoRepository.findAllLottoList();
    }

    @Override
    public void showResult() {

    }
}
