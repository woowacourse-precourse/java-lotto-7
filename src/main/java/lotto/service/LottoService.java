package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.dto.LottoResultDto;
import lotto.validator.LottoValidator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public LottoResultDto createLottoList(int price) {
        LottoValidator.validateLottoPurchaseAmount(price);
        int purchaseQuantity = calculatePurchaseQuantity(price);
        return getLottoResult(purchaseQuantity);
    }

    public List<Integer> createWinningNumbers(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers).getNumbers();
    }

    public void checkBonusNumberValidity(int bonusNumber, List<Integer> winningNumbers) {
        LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
    }

    public List<Map<Integer, Boolean>> getLottoWinningResults(LottoResultDto lottoDto) {
        return checkLottoMatches(lottoDto);
    }

    private List<Map<Integer, Boolean>> checkLottoMatches(LottoResultDto lottoDto) {
        List<Integer> winningNumbers = lottoDto.getWinningNumbers();
        return lottoDto.getLottoList().stream()
                .map(lotto -> createMatchResult(lotto, winningNumbers, lottoDto.getBonusNumber()))
                .toList();
    }

    private Map<Integer, Boolean> createMatchResult(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatchingNumbers(lotto, winningNumbers);
        boolean bonusMatched = isBonusMatched(matchCount, lotto, bonusNumber);
        return Map.of(matchCount, bonusMatched);
    }

    private boolean isBonusMatched(int matchCount, List<Integer> lotto, int bonusNumber) {
        if (matchCount == 5) {
            return isBonusNumberMatched(lotto, bonusNumber);
        }
        return false;
    }

    private static int countMatchingNumbers(List<Integer> lottoList, List<Integer> winningNumbers) {
        return (int) lottoList.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusNumberMatched(List<Integer> lottoList, int bonusNumber) {
        return lottoList.contains(bonusNumber);
    }

    private int calculatePurchaseQuantity(int price) {
        return price / LOTTO_PRICE;
    }

    private LottoResultDto getLottoResult(int purchaseQuantity) {
        List<Lotto> lottoList = getLottoList(purchaseQuantity);
        return new LottoResultDto(purchaseQuantity, lottoList);
    }

    private List<Lotto> getLottoList(int purchaseQuantity) {
        return IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> new Lotto(getRandomNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
