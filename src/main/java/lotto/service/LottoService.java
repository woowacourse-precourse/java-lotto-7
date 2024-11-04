package lotto.service;
import lotto.domain.AutoLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.rule.LottoRules;
import lotto.domain.rule.ResultCalculateRules;
import lotto.domain.rule.WinningRules;
import java.util.stream.Collectors;
import java.util.*;

import static lotto.domain.message.LottoErrorMessage.WINNING_NUMBER_FORMAT_ERROR;
import static lotto.domain.rule.LottoRules.AUTO_LOTTO_PRICE;
import static lotto.domain.message.LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO;
import static lotto.utils.DefaultErrorMessage.INVALID_INTEGER_FORMAT;
import static lotto.utils.DefaultErrorMessage.NULL_OR_EMPTY_INPUT;

public class LottoService {

    public List<AutoLotto> createAutoLottosByLottoPrice(String inputTotalLottoPrice) {
        List<AutoLotto> autoLottos = new ArrayList<>();

        validateDefaultInputPrice(inputTotalLottoPrice);
        validateLottoPrice(Integer.parseInt(inputTotalLottoPrice));
        int autoLottoCount = Integer.parseInt(inputTotalLottoPrice) / AUTO_LOTTO_PRICE.getValue();
        for (int i = 0; i < autoLottoCount; i++) {
            autoLottos.add(Lotto.createRandomLotto());
        }
        return autoLottos;
    }

    public WinningLotto createWinningLotto(String inputWinningLottoNumbers) {
        try {
            List<Integer> winningNumbers = Arrays.stream(inputWinningLottoNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            Lotto winningLotto = new Lotto(winningNumbers); // 로또 공통 유효성 검증
            return Lotto.createWinningLotto(winningLotto.getNumbers());
        } catch (Exception e) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public WinningLotto setWinningLottoBonusNumber(WinningLotto winningLotto, String bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
        return winningLotto;
    }


    public Map<WinningRules, Long> calculateResults(List<AutoLotto> autoLottos, WinningLotto winningLotto) {
        return autoLottos.stream()
                .collect(Collectors.groupingBy(
                        autoLotto -> determineWinningRule(autoLotto, winningLotto),
                        () -> new EnumMap<>(WinningRules.class),
                        Collectors.counting()
                ));
    }

    public float calculateWinningStatistics(Map<WinningRules, Long> results, List<AutoLotto> autoLottos) {
        long totalPrize = ResultCalculateRules.ZERO_LOTTO_PRICE.getValue().longValue();
        for (WinningRules rank : WinningRules.values()) {
            if (rank != WinningRules.NO_MATCH) {
                totalPrize += rank.getPrize() * results.getOrDefault(rank, ResultCalculateRules.DEFAULT_COUNT.getValue().longValue());
            }
        }
        double winningStatistics = ((double) totalPrize / (autoLottos.size() * LottoRules.AUTO_LOTTO_PRICE.getValue())) * ResultCalculateRules.PERCENTAGE_MULTIPLIER.getValue().floatValue();

        return (float) Math.round(winningStatistics * ResultCalculateRules.ROUNDING_SCALE.getValue().intValue()) / ResultCalculateRules.ROUNDING_SCALE.getValue().intValue();
    }

    private WinningRules determineWinningRule(AutoLotto autoLotto, WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(autoLotto, winningLotto);
        boolean bonusMatch = autoLotto.getNumbers().contains(winningLotto.getBonusNumber());
        return WinningRules.valueOf(matchCount, bonusMatch);
    }

    private int countMatchingNumbers(AutoLotto autoLotto, WinningLotto winningLotto) {
        return (int) autoLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private void validateDefaultInputPrice(String inputPrice) {
        validateNullOrEmpty(inputPrice);
        validateParsableToInt(inputPrice);
    }

    public void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT.getMessage());
        }
    }

    public void validateParsableToInt(String inputLottoPrice) {
        try{
            Integer.parseInt(inputLottoPrice);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_INTEGER_FORMAT.getMessage());
        }
    }

    private void validateLottoPrice(int totalLottoPrice) {
        if(isNotValidateLottoPrice(totalLottoPrice)){
            throw new IllegalArgumentException(INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
        }
    }

    private boolean isNotValidateLottoPrice(int totalLottoPrice) {
        return isZeroLottoPrice(totalLottoPrice) || !(isDivisibleByLottoPrice(totalLottoPrice));
    }

    private boolean isZeroLottoPrice(int totalLottoPrice) {
        return totalLottoPrice == 0;
    }

    private boolean isDivisibleByLottoPrice(int totalLottoPrice) {
        return totalLottoPrice % AUTO_LOTTO_PRICE.getValue() == 0;
    }



}
