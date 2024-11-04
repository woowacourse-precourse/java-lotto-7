package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.repository.LottoRepository;
import lotto.utils.LottoGenerator;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;
    private LottoAnswer lottoAnswer;
    private BonusNumber bonusNumber;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void saveLottoAnswer(List<Integer> lottoAnswer) {
        this.lottoAnswer = new LottoAnswer(lottoAnswer);
    }

    public int getLottoCount(int money) {
        validateMoney(money);
        return money / LottoConstant.LOTTO_PRICE;
    }

    private void validateMoney(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력해주세요.");
        }
    }

    public void issueLottos(int count) {
        List<Lotto> lottos = LottoGenerator.getLottos(count);
        lottos.forEach(lottoRepository::save);
    }

    public List<LottoDto> getLottoList() {
        return lottoRepository.findAll().stream()
                .map(lotto -> new LottoDto(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    public void saveBonusNumber(Integer bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public LottoResultDto calculateResults(int purchaseMoney) {
        List<Lotto> userLottos = lottoRepository.findAll();
        Map<LottoRank, Integer> rankCountMap = initializeRankMap();

        userLottos.forEach(lotto -> {
            int matches = lotto.countMatchingNumbers(lottoAnswer);
            boolean bonusMatch = lotto.matchesBonusNumber(bonusNumber);
            LottoRank matchedRank = determineRank(matches, bonusMatch);
            if (matchedRank != null) {
                rankCountMap.put(matchedRank, rankCountMap.get(matchedRank) + 1);
            }
        });

        long totalPrize = calculateTotalPrize(rankCountMap);
        double returnRate = calculateReturnRate(purchaseMoney, totalPrize);
        return new LottoResultDto(rankCountMap, returnRate);
    }

    private Map<LottoRank, Integer> initializeRankMap() {
        return LottoRank.stream()
                .collect(Collectors.toMap(rank -> rank, rank -> 0, (a, b) -> a, () -> new EnumMap<>(LottoRank.class)));
    }

    private LottoRank determineRank(int matches, boolean bonusMatch) {
        return LottoRank.stream()
                .filter(rank -> rank.isMatch(matches, bonusMatch))
                .findFirst()
                .orElse(null);
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> rankCountMap) {
        return rankCountMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateReturnRate(int purchaseMoney, long totalPrize) {
        double rate = ((double) totalPrize / purchaseMoney) * 100;
        return BigDecimal.valueOf(rate).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public boolean isBonusNumberDuplicate(Integer bonusNumber) {
        return lottoAnswer.containsNumber(bonusNumber);
    }
}
