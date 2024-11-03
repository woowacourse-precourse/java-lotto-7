package lotto;

import java.util.EnumMap;
import java.util.List;

public class LottoWinningManager {
    InputHandler inputHandler = new InputHandler();
    PrintManager printManager = new PrintManager();

    public Lotto getWinningLotto() {
        while (true) {
            printManager.printWinningLottoNotice();
            List<Integer> inputLotto = inputHandler.parseToList(inputHandler.getInput());
            if (inputLotto == null) {
                continue;
            }
            if (NumberValidator.isValidLotto(inputLotto)) {
                Lotto winningLotto = new Lotto(inputLotto);
                return winningLotto;
            }
        }
    }

    public int getBonusNumber(Lotto winningLotto) {
        while (true) {
            printManager.printBonusNotice();
            String bonus = inputHandler.getInput();
            if (!NumberValidator.isValidNumber(bonus)) {
                continue;
            }
            final int bonusNumber = Integer.parseInt(bonus);
            if (NumberValidator.isValidBonus(bonusNumber, winningLotto)) {
                return bonusNumber;
            }
        }
    }

    public EnumMap<MatchCount, Integer> WinningResult(List<Lotto> purchasedLotto, Lotto winningLotto, int bonusNumber) {
        EnumMap<MatchCount, Integer> numberOfMatches = initializeEnumMap();
        for (Lotto lotto : purchasedLotto) {
            int duplicateCount = 0;
            duplicateCount = lotto.countDuplicates(winningLotto);
            boolean isBonus = lotto.isBonusInLotto(bonusNumber);
            setEnumMapValue(numberOfMatches, duplicateCount, isBonus);
        }
        return numberOfMatches;
    }

    public void showWinningResult(EnumMap<MatchCount, Integer> winningResult) {
        printManager.printWinningResult(winningResult);
    }

    public void showTotalYield(int totalLottoPrice, EnumMap<MatchCount, Integer> winningResult) {
        int totalYield = calculateTotalYield(int totalLottoPrice, EnumMap<MatchCount, Integer> winningResult);
        printManager.printTotalYield(totalYield);
    }

    private EnumMap<MatchCount, Integer> initializeEnumMap() {
        EnumMap<MatchCount, Integer> numberOfMatches = new EnumMap<>(MatchCount.class);
        for (MatchCount matchCount : MatchCount.values()) {
            numberOfMatches.put(matchCount, 0);
        }
        return numberOfMatches;
    }

    private EnumMap<MatchCount, Integer> setEnumMapValue(EnumMap<MatchCount, Integer> numberOfMatches, int duplicateCount, boolean isBonus) {
        if (duplicateCount == 3) {
            numberOfMatches.put(MatchCount.THREE, numberOfMatches.get(MatchCount.THREE) + 1);
        }
        if (duplicateCount == 4) {
            numberOfMatches.put(MatchCount.FOUR, numberOfMatches.get(MatchCount.FOUR) + 1);
        }
        if (duplicateCount == 5) {
            numberOfMatches = setEnumMapBonus(numberOfMatches, duplicateCount, isBonus);
        }
        if (duplicateCount == 6) {
            numberOfMatches.put(MatchCount.SIX, numberOfMatches.get(MatchCount.SIX) + 1);
        }
        return numberOfMatches;
    }

    private EnumMap<MatchCount, Integer> setEnumMapBonus(EnumMap<MatchCount, Integer> numberOfMatches, int duplicateCount, boolean isBonus) {
        if (isBonus) {
            numberOfMatches.put(MatchCount.FIVE_WITH_BONUS, numberOfMatches.get(MatchCount.FIVE_WITH_BONUS) + 1);
            return numberOfMatches;
        }
        numberOfMatches.put(MatchCount.FIVE, numberOfMatches.get(MatchCount.FIVE) + 1);
        return numberOfMatches;
        }
    }

    private int calculateTotalYield(int totalLottoPrice, EnumMap<MatchCount, Integer> winningResult) {

    }
}
