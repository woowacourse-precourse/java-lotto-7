package lotto.service;


import static lotto.constants.InputException.VALID_AMOUNT_INPUT;
import static lotto.constants.InputException.VALID_INPUT_BONUS;
import static lotto.constants.InputException.VALID_WIN_NUMBER;
import static lotto.constants.LottoRule.LOTTO_MATCH_FIVE;
import static lotto.constants.LottoRule.PROFIT_PERCENTAGE_CALCULATE;
import static lotto.constants.LottoRule.SPLIT_ALL_TOKEN;
import static lotto.constants.LottoRule.Thousand_Multi_Number;
import static lotto.constants.LottoRule.USE_ZERO;
import static lotto.constants.LottoRule.WIN_NUMBER_DELIMITER;

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

// util, 컬렉션 수정, 테스트, 리팩토링, 클린 코드
public class LottoService {
    private final EnumMap<WinAmount, Integer> winLottoAmountHistory;
    private static boolean fiveAndBonus = false;

    public LottoService() {
        winLottoAmountHistory = new EnumMap<>(WinAmount.class);
        for (WinAmount winAmount : WinAmount.values()) {
            winLottoAmountHistory.put(winAmount, 0);
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
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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
        for (String name : winNumber.split(WIN_NUMBER_DELIMITER.getDelimiter(), SPLIT_ALL_TOKEN.getValue())) {
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

    public EnumMap<WinAmount, Integer> comPareMyLotto_WinLotto(Lotto[] lottos, List<Integer> winNumbers,
                                                               int bonusNumber) {
        Set<Integer> winNumber = new HashSet<>(winNumbers);
        for (Lotto lotto : lottos) {
            Set<Integer> myLotto = new HashSet<>(lotto.getNumbers());
            myLotto.retainAll(winNumber);
            int correctNumber = myLotto.size();
            checkBonus(lotto, myLotto, bonusNumber);
            compare(correctNumber);
        }
        return winLottoAmountHistory;
    }

    public void checkBonus(Lotto lotto, Set<Integer> myLotto, int bonusNumber) {
        if (myLotto.size() == LOTTO_MATCH_FIVE.getValue() && lotto.getNumbers().contains(bonusNumber)) {
            fiveAndBonus = true;
        }
    }

    public void compare(int correctNumber) {
        if (correctNumber == 3) {
            winLottoAmountHistory.put(WinAmount.Three, winLottoAmountHistory.get(WinAmount.Three) + 1);
        } else if (correctNumber == 4) {
            winLottoAmountHistory.put(WinAmount.Four, winLottoAmountHistory.get(WinAmount.Four) + 1);
        } else if (correctNumber == 5 && !fiveAndBonus) {
            winLottoAmountHistory.put(WinAmount.Five, winLottoAmountHistory.get(WinAmount.Five) + 1);
        } else if (correctNumber == 5) {
            winLottoAmountHistory.put(WinAmount.FiveBonus, winLottoAmountHistory.get(WinAmount.FiveBonus) + 1);
            fiveAndBonus = false;
        } else if (correctNumber == 6) {
            winLottoAmountHistory.put(WinAmount.Six, winLottoAmountHistory.get(WinAmount.Six) + 1);
        }
    }


    public double resultSum(EnumMap<WinAmount, Integer> winLottoAmountHistory, double count) {
        count *= Thousand_Multi_Number.getValue();
        int sum = USE_ZERO.getValue();
        for (WinAmount winAmount : winLottoAmountHistory.keySet()) {
            sum += winLottoAmountHistory.get(winAmount) * winAmount.getAmountNum();
        }
        return sum / count * PROFIT_PERCENTAGE_CALCULATE.getValue();
    }

    public void finalResult(EnumMap<WinAmount, Integer> winLottoAmountHistory, double amountPercent) {
        Output.result(winLottoAmountHistory);
        Output.adventure(amountPercent);
    }

}