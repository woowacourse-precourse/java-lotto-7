package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    public LottoRank prizeWinningDiscriminationPerLotto(
            List<Integer> winningNumbers,
            int bonusNumber,
            List<Integer> lotto
    ) {

        int countOfMatch = 0;
        boolean isMatchBonus = false;

        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                countOfMatch++;
            }
        }

        if (lotto.contains(bonusNumber)) isMatchBonus = true;

        return LottoRank.valueOf(countOfMatch, isMatchBonus);
    }

    public List<List<Integer>> publishLotto(int numberOfLotto) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(lotto);
        }
        return lottos;
    }

    public int calCulateLottoAmount(String purchaseAmount) {
        int amount = convertStringToInt(purchaseAmount);
        return amount / 1000;
    }

    public int calculateRateOfReturnMoney(int purchaseAmount, int totalWinningMoney) {
        return totalWinningMoney / purchaseAmount * 100;
    }

    private int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private List<Integer> convertStringToIntegerList(String numbers) {
        String[] splitNumbers = numbers.split(",");

        return Arrays.stream(splitNumbers)
                .map(this::convertStringToInt)
                .collect(Collectors.toList());
    }

}
