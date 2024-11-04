package lotto.service;


import static lotto.constants.InputException.VALID_AMOUNT_INPUT;
import static lotto.constants.InputException.VALID_INPUT_BONUS;
import static lotto.constants.InputException.VALID_WIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.WinAmount;
import lotto.validation.BonusNumberValidate;
import lotto.validation.BuyLottoValidate;
import lotto.view.Input;
import lotto.view.Output;

public class LottoService {
    private static final int LOTTO_NUMBER_SIX = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_MATCH_FIVE = 5;
    private static final int PROFIT_PERCENTAGE_CALCULATE = 100;
    private static final int SPLIT_ALL_TOKEN = -1;
    private static final int THOUSAND_MULTI_NUMBER = 1000;
    private static final int ZERO = 0;
    private static final String WIN_NUMBER_DELIMITER = ",";

    private final EnumMap<WinAmount, Integer> winLottoAmountHistory;
    private static boolean fiveAndBonus = false;

    public LottoService() {
        winLottoAmountHistory = new EnumMap<>(WinAmount.class);
        for (WinAmount winAmount : WinAmount.values()) {
            winLottoAmountHistory.put(winAmount, ZERO);
        }
    }

    public int buyLotto() {
        try {
            String inputAmount = Input.InputAmount();
            return BuyLottoValidate.lottoBuyValidation(inputAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(VALID_AMOUNT_INPUT.getMessage());
            return buyLotto();
        }
    }

    public Lotto pickLottoNumber() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIX));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public Lotto setWinNumber() {
        try {
            String inputWinNumber = Input.InputWinNumber();
            List<Integer> winNumber = numberSplit(inputWinNumber);
            return new Lotto(winNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWinNumber();
        }
    }

    public List<Integer> numberSplit(String winNumber) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String name : winNumber.split(WIN_NUMBER_DELIMITER, SPLIT_ALL_TOKEN)) {
            try {
                int number = Integer.parseInt(name);
                winNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(VALID_WIN_NUMBER.getMessage());
            }
        }
        return winNumbers;
    }

    public int setBonusNumber(Lotto winNumbers) {
        try {
            String inputBonusNumber = Input.InputBonusNumber();
            return BonusNumberValidate.bonusValidation(winNumbers.getNumbers(), inputBonusNumber);
        } catch (Exception e) {
            System.out.println(VALID_INPUT_BONUS.getMessage());
            return setBonusNumber(winNumbers);
        }
    }

    public EnumMap<WinAmount, Integer> compare_My_Win(Lotto[] myLotto, List<Integer> winNumbers, int bonusNumber) {
        Set<Integer> winNumber = new HashSet<>(winNumbers);
        for (Lotto lotto : myLotto) {
            Set<Integer> myLottoNumber = new HashSet<>(lotto.getNumbers());
            myLottoNumber.retainAll(winNumber);
            int overlappingNumber = myLottoNumber.size();
            checkBonus(lotto, myLottoNumber, bonusNumber);
            winAmountCompare(overlappingNumber);
        }
        return winLottoAmountHistory;
    }

    public void checkBonus(Lotto lotto, Set<Integer> myLotto, int bonusNumber) {
        if (myLotto.size() == LOTTO_MATCH_FIVE && lotto.getNumbers().contains(bonusNumber)) {
            fiveAndBonus = true;
        }
    }

    public void winAmountCompare(int overlappingNumber) {
        WinAmount winAmount = WinAmount.determineWinAmount(overlappingNumber, fiveAndBonus);
        if (winAmount != null) {
            winLottoAmountHistory.put(winAmount, winLottoAmountHistory.get(winAmount) + 1);
        }
    }

    public double resultSum(EnumMap<WinAmount, Integer> winLottoAmountHistory, double count) {
        count *= THOUSAND_MULTI_NUMBER;
        int sum = ZERO;
        for (WinAmount winAmount : winLottoAmountHistory.keySet()) {
            sum += winLottoAmountHistory.get(winAmount) * winAmount.getAmountNum();
        }
        return sum / count * PROFIT_PERCENTAGE_CALCULATE;
    }

    public void finalResult(EnumMap<WinAmount, Integer> winLottoAmountHistory, double amountPercent) {
        Output.result(winLottoAmountHistory);
        Output.adventure(amountPercent);
    }
}