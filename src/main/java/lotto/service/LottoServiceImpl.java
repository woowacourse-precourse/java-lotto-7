package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Result;
import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoStateException;
import lotto.repository.LottoRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;
    private final int ONE_LOTTO_PRICE = 1_000;

    public LottoServiceImpl(LottoRepository lottoRepositoryImpl) {
        this.lottoRepository = lottoRepositoryImpl;
    }

    @Override
    public void addLottoList(int amount, List<Integer> winNumbers, int bonusNumber) {
        int count = amount / ONE_LOTTO_PRICE;

        while (count-- > 0) {
            lottoRepository.addLottoNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList()));
        }
    }

    @Override
    public List<Lotto> getLottoList() {
        return lottoRepository.findAllLottoList();
    }

    @Override
    public void getLottoResult(Result result, List<Integer> winNumbers, int bonusNumber) {
        List<Lotto> lottoList = lottoRepository.findAllLottoList();

        for (Lotto lotto : lottoList) {
            int matchCount = getMatchCount(lotto.getNumbers(), winNumbers);
            boolean matchBonus = false;
            if (matchCount == 5) {
                matchBonus = checkMatchBonus(lotto.getNumbers(), bonusNumber);
            }

            updateLottoResult(result, matchCount, matchBonus);
        }
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        return (int) winNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private boolean checkMatchBonus(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == bonusNumber);
    }

    private void updateLottoResult(Result result, int matchCount, boolean matchBonus) {
        // try - catch?
        Optional<Ranking> optionalRanking = Ranking.findByMatchCountAndBonus(matchCount, matchBonus);

        if (optionalRanking.isPresent()) {
            Ranking ranking = optionalRanking.get();
            result.addWinPrize(ranking);
            result.addWinCount(ranking);
        }
    }
}
