package lotto.service;


import static lotto.constants.InputException.VALID_AMOUNT_INPUT;
import static lotto.constants.InputException.VALID_INPUT_BONUS;

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
        } catch (Exception e) {
            System.out.println(VALID_AMOUNT_INPUT);
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
        for (String name : winNumber.split(",", -1)) {
            try {
                int number = Integer.parseInt(name);
                winNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("[ERROR] 잘못된 값입니다.");
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
        if (myLotto.size() == 5 && lotto.getNumbers().contains(bonusNumber)) {
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
        count *= 1000;
        int sum = 0;
        for (WinAmount winAmount : winLottoAmountHistory.keySet()) {
            sum += winLottoAmountHistory.get(winAmount) * winAmount.getAmountNum();
        }
        return sum / count * 100;
    }

    public void finalResult(EnumMap<WinAmount, Integer> winLottoAmountHistory, double amountPercent) {
        Output.result(winLottoAmountHistory);
        Output.adventure(amountPercent);
    }

}