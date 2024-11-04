package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoConstants;
import lotto.model.Lotto;

public class LottoService {

    public int calculateLottoCount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / LottoConstants.PURCHASE_UNIT;
    }

    public List<Lotto> generateAutoLottoNumbers(int lottoCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto eachLottoNumbers = new Lotto(generateSortedAutoNumbers()); // 안에서 숫자 검증
            lottoNumbers.add(eachLottoNumbers);
        }
        return lottoNumbers;
    }

    public List<Integer> changeWinningNumbers(String winningNumbers) {
        String[] lottoNumbers = separateWinningNumbers(winningNumbers);
        return changeStringWinningNumbers(lottoNumbers);
    }

    public Map<Integer, Integer> calculateLottoStatistics(Lotto winningNumbers, String bonusNumber,
                                                          List<Lotto> generatedLottoNumbers) {
        Map<Integer, Integer> lottoStatistics = new HashMap<>();
        initLottoStatistics(lottoStatistics);
        for (Lotto eachLottoNumber : generatedLottoNumbers) {
            int equalNumsCount = countEqualAndBonusNumsCount(eachLottoNumber, winningNumbers, bonusNumber);
            incrementValue(lottoStatistics, equalNumsCount);
        }
        return lottoStatistics;
    }

    public int calculateProfits(Map<Integer, Integer> lottoStatistics) {
        return lottoStatistics.get(3) * LottoConstants.THREE_MATCHED_PRIZE
                + lottoStatistics.get(4) * LottoConstants.FOUR_MATCHED_PRIZE
                + lottoStatistics.get(5) * LottoConstants.FIVE_MATCHED_PRIZE
                + lottoStatistics.get(6) * LottoConstants.SIX_MATCHED_PRIZE
                + lottoStatistics.get(7) * LottoConstants.BONUS_MATCHED_PRIZE;
    }

    public double calculateRateOfReturn(int lottoCount, int lottoSum) {
        double rateOfReturn = ((double) lottoSum / (lottoCount * LottoConstants.PURCHASE_UNIT)) * 100;
        BigDecimal rateOfReturnRounded = new BigDecimal(rateOfReturn).setScale(2, RoundingMode.HALF_UP);

        return rateOfReturnRounded.doubleValue();
    }

    private List<Integer> generateSortedAutoNumbers() {
        List<Integer> autoNumbers = generateAutoNumbers();
        List<Integer> modifiableNumbers = new ArrayList<>(autoNumbers);
        Collections.sort(modifiableNumbers);
        return modifiableNumbers;
    }

    private List<Integer> generateAutoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.RANGE_START, LottoConstants.RANGE_END,
                LottoConstants.NUMBER_OF_CHOICES);
    }

    private String[] separateWinningNumbers(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 비어있을 수 없습니다.");
        }

        String[] numbers = winningNumbers.split(LottoConstants.DELIMITER);
        if (numbers.length == 1) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 , 로 구분되는 문자열이어야 합니다.");
        }
        return numbers;
    }

    private List<Integer> changeStringWinningNumbers(String[] lottoNumbers) {
        List<Integer> changedLottoNumbers = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            changedLottoNumbers.add(parseAndTrimWinningNumbers(lottoNumber));
        }
        return changedLottoNumbers;
    }

    private int parseAndTrimWinningNumbers(String lottoNumber) {
        try {
            return Integer.parseInt(lottoNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 정수여야 합니다.");
        }
    }

    private void initLottoStatistics(Map<Integer, Integer> lottoStatistics) {
        for (int i = 3; i <= 7; i++) {
            lottoStatistics.put(i, 0);
        }
    }

    private int countEqualAndBonusNumsCount(Lotto eachLottoNumber, Lotto winningNumbers, String bonusNumber) {
        int equalNumsCount = countEqualNumsLotto(eachLottoNumber, winningNumbers);
        if (equalNumsCount == 5 && hasBonusNumber(eachLottoNumber, bonusNumber)) {
            equalNumsCount = 7;
        }
        return equalNumsCount;
    }

    private int countEqualNumsLotto(Lotto eachLottoNumber, Lotto winningNumbers) {
        return eachLottoNumber.compareNumbers(winningNumbers);
    }

    private boolean hasBonusNumber(Lotto eachLottoNumber, String bonusNumber) {
        int changedBonusNumber = Integer.parseInt(bonusNumber);
        return eachLottoNumber.getNumbers().contains(changedBonusNumber);
    }

    private void incrementValue(Map<Integer, Integer> lottoStatistics, int equalNumsCount) {
        lottoStatistics.put(equalNumsCount, lottoStatistics.getOrDefault(equalNumsCount, 0) + 1);
    }

}
