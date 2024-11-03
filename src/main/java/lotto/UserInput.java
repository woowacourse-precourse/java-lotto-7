package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserInput {

    private static final int lottoPrice = 1000;
    private static final int lottoNumberCount = 6;
    private static final int lottoNumberMin = 1;
    private static final int lottoNumberMax = 45;
    private int numberOfLotto;
    private final List<Integer> winNumbers = new ArrayList<>();
    private int bonusNumber;

    public void purchaseAmountInput() {

        System.out.println("구입 금액을 입력해주세요.");

        String amount = readLine();

        validPurchaseAmountInput(amount);

        this.numberOfLotto = Integer.parseInt(amount) / lottoPrice;
    }

    public void winNumbersInput() {

        System.out.println("당첨 번호를 입력해주세요.");

        String[] winNumbersInput = readLine().split(",");

        validWinNumbersInput(winNumbersInput);

        for (String winNumber : winNumbersInput) {
            this.winNumbers.add(Integer.parseInt(winNumber));
        }
    }

    public void bonusNumberInput() {

        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");

        String bonusNumberInput = readLine();

        validBonusNumberInput(bonusNumberInput);

        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    private void validPurchaseAmountInput(String input) {

        int amount;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }

        if (amount < lottoPrice) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 " + lottoPrice + "원 이상이어야 합니다.");
        }

        if (amount % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 " + lottoPrice + "원 단위여야 합니다.");
        }
    }

    private void validWinNumbersInput(String[] winNumbersInput) {

        if (winNumbersInput.length != lottoNumberCount) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + lottoNumberCount +
                    "개여야 합니다.");
        }

        HashSet<String> duplicates = new HashSet<>();
        for (String winNumber : winNumbersInput) {
            if (!duplicates.add(winNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
        }

        for (String winNumber : winNumbersInput) {
            try {
                Integer.parseInt(winNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }

        for (String winNumber : winNumbersInput) {
            if (Integer.parseInt(winNumber) < lottoNumberMin|| Integer.parseInt(winNumber) > lottoNumberMax) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 " + lottoNumberMin + "부터 " +
                        lottoNumberMax + " 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validBonusNumberInput(String bonusNumberInput) {

        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        if (bonusNumber < lottoNumberMin || bonusNumber > lottoNumberMax) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + lottoNumberMin + "부터 " +
                    lottoNumberMax + " 사이의 숫자여야 합니다.");
        }

        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
