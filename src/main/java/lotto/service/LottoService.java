package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.dto.Lottos;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    public Lottos makeRandomLotto(Long money) {
        List<Lotto> createdLotto = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = pickRandomUniqueSixNumbers().stream().sorted().toList();
            createdLotto.add(new Lotto(numbers));
        }

        return new Lottos(createdLotto);
    }

    public List<Integer> pickRandomUniqueSixNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> splitSixNumbers(String numbers) {
        String[] numbersArray = splitNumbers(numbers);
        return convertToIntegerList(numbersArray);
    }

    private static String[] splitNumbers(String numbers) {
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length != 6) {
            throw new IllegalArgumentException(LottoServiceErrorConfig.COMMA_SPLIT_ERROR.getErrorMessage());
        }

        return numbersArray;
    }

    private static List<Integer> convertToIntegerList(String[] numbersArray) {
        try {
            return Arrays.stream(numbersArray).map(LottoService::convertStringToInt).sorted().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoServiceErrorConfig.STRING_TO_INT_CONVERT_ERROR.getErrorMessage());
        }
    }

    public Integer getBonusNumber(String number) {
        try {
            return convertStringToInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoServiceErrorConfig.STRING_TO_INT_CONVERT_ERROR.getErrorMessage());
        }
    }

    private static int convertStringToInt(String number) {
        int convertedNumber = Integer.parseInt(number);

        if (convertedNumber > 45 || convertedNumber <= 0) {
            throw new IllegalArgumentException(LottoServiceErrorConfig.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }

        return convertedNumber;
    }

    public List<Integer> calculateLottoResults(Lottos lottos, List<Integer> winningSixNumbers, Integer winningBonusNumber) {
        List<Integer> lottoMatchResults = new ArrayList<>(Collections.nCopies(5, 0));

        for (Lotto lotto : lottos.lottos()) {
            Integer result = calculateMatchingNumbers(lotto, winningSixNumbers, winningBonusNumber);

            if (!result.equals(LottoWinType.NO_MATCH.getType())) {
                lottoMatchResults.set(result, lottoMatchResults.get(result) + 1);
            }
        }

        return lottoMatchResults;
    }

    private Integer calculateMatchingNumbers(Lotto lotto, List<Integer> winningSixNumbers, Integer winningBonusNumber) {
        List<Integer> numbers = lotto.getNumbers();

        Set<Integer> nowNumber = new HashSet<>(numbers);
        Set<Integer> NowWinningNumber = new HashSet<>(winningSixNumbers);

        boolean bonusNumberMatched = nowNumber.contains(winningBonusNumber);

        eraseNotMatchedNumbers(nowNumber, NowWinningNumber);

        return calculateResultTypeIndex(nowNumber, bonusNumberMatched);
    }

    private static void eraseNotMatchedNumbers(Set<Integer> target, Set<Integer> eraser) {
        target.retainAll(eraser);
    }

    private static Integer calculateResultTypeIndex(Set<Integer> nowNumber, boolean winningBonusMatch) {
        if (nowNumber.size() == 3) {
            return LottoWinType.THREE_MATCH.getType();
        } else if (nowNumber.size() == 4) {
            return LottoWinType.FOUR_MATCH.getType();
        } else if (nowNumber.size() == 5) {
            if (winningBonusMatch) {
                return LottoWinType.FIVE_MATCH_WITH_BONUS.getType();
            }
            return LottoWinType.FIVE_MATCH.getType();
        } else if (nowNumber.size() == 6) {
            return LottoWinType.SIX_MATCH.getType();
        }
        return LottoWinType.NO_MATCH.getType();
    }

    public BigDecimal calculateEarningRate(Long money, List<Integer> lottoMatchResults) {
        BigInteger sumAllResults = BigInteger.ZERO;
        for (LottoWinType winType : LottoWinType.values()) {
            if (!winType.getType().equals(LottoWinType.NO_MATCH.getType())) {
                sumAllResults = sumAllResults.add(
                        BigInteger.valueOf(lottoMatchResults.get(winType.getType()) * LottoPrizeType.valueOf(winType.name()).getType())
                );
            }
        }

        BigDecimal sumAsDecimal = new BigDecimal(sumAllResults.multiply(BigInteger.valueOf(100)));
        BigDecimal divisor = new BigDecimal(money);
        return sumAsDecimal.divide(divisor, 2, RoundingMode.HALF_UP);
    }
}
