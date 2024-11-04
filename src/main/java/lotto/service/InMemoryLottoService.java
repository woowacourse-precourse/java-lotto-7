package lotto.service;

import static lotto.constant.LottoConstant.DELIMITER;
import static lotto.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.ONE;
import static lotto.constant.LottoConstant.PERCENT;
import static lotto.constant.LottoConstant.PROFIT_RATE_FORMAT;
import static lotto.constant.LottoConstant.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.repository.LottoRepository;

public class InMemoryLottoService implements LottoService {

    private final LottoRepository lottoRepository;
    private static InMemoryLottoService instance;

    private InMemoryLottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public static InMemoryLottoService getInstance(LottoRepository lottoRepository) {
        if (instance == null) {
            instance = new InMemoryLottoService(lottoRepository);
        }
        return instance;
    }

    @Override // 금액에 따라 로또 생성 및 저장
    public void buyLotto(String money) {

        int purchasableLottoCount = Integer.parseInt(money) / LOTTO_PRICE;

        for (int i = ZERO; i < purchasableLottoCount; i++) {
            List<Integer> lottoNumbers = createLottoNumbers();
            lottoRepository.save(new Lotto(lottoNumbers));
        }
    }

    @Override // 당첨 번호와 보너스 번호를 입력받아 당첨 통계 계산
    public Map<Rank, Integer> calculateLottoResults(String winNumbers, String bonusNumber) {

        List<Integer> winnerNumbers = Arrays.stream(winNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();

        int bonus = Integer.parseInt(bonusNumber);

        return getRankCounts(winnerNumbers, bonus);
    }

    @Override
    public String getPercent(Map<Rank, Integer> rankCounts) {
        long totalPrize = getTotalPrize(rankCounts);
        int totalPurchase = lottoRepository.count() * LOTTO_PRICE;
        double profitRate = (double) totalPrize / totalPurchase * PERCENT;
        return String.format(PROFIT_RATE_FORMAT, profitRate);
    }

    @Override
    public List<Integer> convertToNumbers(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public List<Lotto> getAllLottos() {
        return lottoRepository.findAll();
    }

    @Override
    public void deleteLottos() {
        lottoRepository.deleteAll();
    }

    private long getTotalPrize(Map<Rank, Integer> rankCounts) {
        long totalPrize = ZERO;
        for (Rank rank : Rank.values()) {
            totalPrize += (long) rankCounts.get(rank) * rank.getPrize();
        }
        return totalPrize;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private Map<Rank, Integer> getRankCounts(List<Integer> winnerNumbers, int bonus) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, ZERO);
        }

        List<Lotto> lottos = lottoRepository.findAll();

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winnerNumbers::contains)
                    .count();
            boolean isBonusMatch = lotto.getNumbers().contains(bonus);

            Rank rank = Rank.valueOf(matchCount, isBonusMatch);
            rankCounts.put(rank, rankCounts.get(rank) + ONE);
        }
        return rankCounts;
    }
}
