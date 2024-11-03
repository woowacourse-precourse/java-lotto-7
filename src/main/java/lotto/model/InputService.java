package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.*;

import java.util.*;

public class InputService {
    private static List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static Set<Integer> winningNumberSet = new HashSet<>();
    private static final String CONVERT_ERROR_MESSAGE = "[ERROR] 잘못된 입력값입니다. 입력값은 숫자여야합니다.";
    private static final String AMOUNT_ERROR_MESSAGE = "[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.";
    private static final String DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호가 중복될 수 없습니다.";
    private static final String DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호가 당첨 번호와 중복될 수 없습니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1이상 45이하여야 합니다.";
    private static final String BONUS_INVALID_VALUE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 반드시 1개여야 합니다.";

    public int purchaseValue() {
        String value = Console.readLine();
        return validatePurchaseValue(value);
    }

    public int validatePurchaseValue(String value) {
        int convertValue = convertToInt(value);

        checkDivisibleByThousand(convertValue);
        return convertValue;
    }

    public int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            System.out.println(CONVERT_ERROR_MESSAGE);
            throw new InvalidNumericException(CONVERT_ERROR_MESSAGE);
        }
    }

    public List<Lotto> lottoNumbersValue(int ticket) {
        for (int i = 0; i < ticket; i++) {
            List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumber);
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);
        }

        printLottoNumber(lottos);
        return lottos;
    }

    private void printLottoNumber(List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getNumbers().toString());
        }
    }

    public List<Integer> winningNumbersValue() {
        String value = Console.readLine();
        value = value.replaceAll("\\s", "");
        String[] winningNumber = value.split(",");
        for (String number : winningNumber) {
            int convertNumber = convertToInt(number);
            checkDuplicateWinningNumber(convertNumber);
            winningNumbers.add(convertNumber);
        }

        return winningNumbers;
    }

    public int bonusNumberValue() {
        String value = Console.readLine();

        checkInvalidValue(value);

        int convertValue = convertToInt(value);

        checkInvalidBonusNumber(convertValue);
        checkDuplicateBonusNumber(convertValue);
        return convertValue;
    }

    public boolean checkDivisibleByThousand(int value){
        if (value % 1000 != 0) {
            throw new InvalidPurchaseAmountException(AMOUNT_ERROR_MESSAGE);
        }
        return false;
    }

    public boolean checkDuplicateWinningNumber(int number) {
        if (!winningNumberSet.add(number)) {
            throw new InvalidDuplicateNumberException(DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE);
        }
        return false;
    }

    public boolean checkInvalidValue(String value){
        if(!value.matches("^\\s*\\d+\\s*$")){
            throw new InvalidBonusValueException(BONUS_INVALID_VALUE_ERROR_MESSAGE);
        }
        return false;
    }

    public boolean checkInvalidBonusNumber(int convertValue){
        if(convertValue < 1 || convertValue > 45){
            throw new InvalidBonusNumberException(BONUS_NUMBER_ERROR_MESSAGE);
        }
        return false;
    }

    public boolean checkDuplicateBonusNumber(int number) {
        if (!winningNumberSet.add(number)) {
            throw new InvalidDuplicateBonusNumberException(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
        }
        return false;
    }
}
