package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class LottoLogic {
    private List<Lotto> lottos;
    private int lottoPrice;
    private int purchaseAmount;
    private Map<LottoEnum, Integer> winningCounts;
    
    //디폴트 생성자.
    public LottoLogic() {
        this(1000);
    }

    public LottoLogic(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.lottos = new ArrayList<Lotto>();
    }

    public List<Lotto> issueLottoAsPrice(int purchaseAmount) throws IllegalArgumentException {
        validatePurchaseAmount(purchaseAmount);

        int ticketCount = getTicketCount(purchaseAmount);

        for (int i = 0; i < ticketCount; ++i) {
            Lotto lotto = issueValidatedLotto();
            lottos.add(lotto);
        }

        setPurchaseAmount(purchaseAmount);

        return lottos;
    }

    private void validatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount < lottoPrice) {
            throw new IllegalArgumentException("[ERROR] 입력하신 값은 로또 값 " + lottoPrice + "(원) 보다 작습니다." );
        }

        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 입력하신 값은 로또 값 " + lottoPrice + "(원) 단위가 아닙니다." );
        }
    }

    private Lotto issueValidatedLotto() {
        while (true) {
            try {
                List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_VALUE, 
                                                                                Lotto.MAX_VALUE, Lotto.LOTTO_COUNT);
                randomNumbers = new ArrayList<>(randomNumbers);
                randomNumbers.sort(Comparator.naturalOrder());
                Lotto lotto = new Lotto(randomNumbers);
                return lotto;
            } catch (IllegalArgumentException iae) {
                continue;
            }
        }
    }

    public Map<LottoEnum, Integer> matchWinners(ValidationForm<List<Integer>> winningNumbersValidated, ValidationForm<Integer> bonusNumberValidated) {
        List<Integer> winningNumbers = winningNumbersValidated.getValue();
        int bonusNumber = bonusNumberValidated.getValue();

        Map<LottoEnum, Integer> winningCounts = initWinnigCount();

        for (Lotto lotto : lottos) {
            int winningCount = lotto.matchNumbers(winningNumbers);
            boolean winBonus = lotto.matchBonusNumber(bonusNumber);
            LottoEnum rank = getRankPerWinningCount(winningCount, winBonus);
            if (rank != LottoEnum.NONE) {
                winningCounts.put(rank, winningCounts.get(rank) + 1);
            }
        }

        setWinningCounts(winningCounts);
        return winningCounts;
    }

    private Map<LottoEnum, Integer> initWinnigCount() throws IllegalArgumentException {
        Map<LottoEnum, Integer> winningCount = new HashMap<>();

        for (LottoEnum rank : LottoEnum.values()) {
            if (rank == LottoEnum.NONE) {
                continue;
            }
            winningCount.put(rank, 0);
        }

        return winningCount;
    }

    private LottoEnum getRankPerWinningCount(int winningCount, boolean winBonus) {
        if (winningCount == 6) {
            return LottoEnum.FIRST;
        }

        if (winningCount == 5 && winBonus) {
            return LottoEnum.SECOND;
        }

        if (winningCount == 5) {
            return LottoEnum.THIRD;
        }

        if (winningCount == 4) {
            return LottoEnum.FOURTH;
        }

        if (winningCount == 3) {
            return LottoEnum.FIFTH;
        }

        return LottoEnum.NONE;
    }

    public ValidationForm<List<Integer>> validateWinningNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        return new ValidationForm<List<Integer>>(winningNumbers, 
                                                (list) -> {
                                                    checkDuplicate(winningNumbers);
                                                    checkNumbersInRange(winningNumbers);
                                                });
    }

    public ValidationForm<Integer> validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        return new ValidationForm<Integer>(bonusNumber, (number) -> {checkBonusNumber(number);});
    }


    private void checkDuplicate(List<Integer> winningNumbers) throws IllegalArgumentException {
        Set<Integer> duplicateChecker = new HashSet<>();
        for (int number : winningNumbers) {
            if (!duplicateChecker.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복 값이 있습니다.");
            }
        }
    }

    private void checkNumbersInRange(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (!winningNumbers.stream()
                            .allMatch(number -> number >= Lotto.MIN_VALUE && number <= Lotto.MAX_VALUE)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 하나의 값이 로또 번호 값 범위 "
                                                + Lotto.MIN_VALUE + "와 " + Lotto.MAX_VALUE
                                                + " 사이의 값이 아닙니다."); 
        }
    }

    private void checkBonusNumber(int bonusNumber) throws IllegalArgumentException {
        if (!(bonusNumber >= Lotto.MIN_VALUE) || !(bonusNumber <= Lotto.MAX_VALUE)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 값이 로또 번호 값 범위 " 
                                                + Lotto.MIN_VALUE + "와 " + Lotto.MAX_VALUE
                                                + " 사이의 값이 아닙니다.");
        }
    }

    public double calculateBenefit() {
        double benefit = 0.0;

        for (Map.Entry<LottoEnum, Integer> entry : this.winningCounts.entrySet()) {
            LottoEnum rank = entry.getKey();
            int winningCount = entry.getValue();
            benefit += rank.getPrize() * (double)winningCount;
        }

        benefit /= (double)this.purchaseAmount;
        benefit = Math.round(benefit * 1000.0) / 10.0;
        return benefit;
    }
    
    public int getTicketCount(int purchaseAmount) {
        return purchaseAmount / this.lottoPrice;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setWinningCounts(Map<LottoEnum, Integer> winningCounts) {
        this.winningCounts = winningCounts;
    }
}
