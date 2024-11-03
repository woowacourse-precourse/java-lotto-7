package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Status;
import utils.Pair;

public class Validator {
    public static final Integer LOTTO_MIN = 1;
    public static final Integer LOTTO_MAX = 45;
    public static final Integer LOTTO_SIZE = 6;
    public static final Integer LOTTO_COST = 1000;
    public static final Pair<Integer, Integer> LOTTO_NUMBER_SCOPE = new Pair<>(LOTTO_MIN, LOTTO_MAX);

    public static void validateInitialMoney(String money) {
        validateNumber(money);
        validatePositiveNumber(money);
        validateNonCharge(Long.parseLong(money));
    }

    public static void validateNumber(String inputContent) {
        try {
            Long.parseLong(inputContent);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 정수가 아닙니다.");
        }
    }

    public static void validatePositiveNumber(String inputContent) {
        long convertedContent = Long.parseLong(inputContent);
        if (convertedContent <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 0 이하의 음수입니다.");
        }
    }

    public static void validateNonCharge(long criteriaMoney) {
        if (!isHavingCharge(criteriaMoney, LOTTO_COST)) {
            throw new IllegalArgumentException("[ERROR] 잔액이 있습니다. " + LOTTO_COST + "단위로 입력해주세요.");
        }
    }

    private static boolean isHavingCharge(long criteriaMoney, int cost) {
        return criteriaMoney % cost == 0;
    }

    public static void validateLottoNumbers(List<Integer> elements) {
        validateUniqueElements(elements);
        validateLottoNumbersInRange(elements);
    }

    public static void validateUniqueElements(List<?> groups) {
        Set<Object> uniqueGroup = new HashSet<>(groups);
        if (uniqueGroup.size() < groups.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 값이 있습니다.");
        }
    }

    public static void validateLottoNumbersInRange(List<Integer> groups) {
        for (Integer element : groups) {
            validateNumberInLottoRange(element);
        }
    }

    public static void validateNumberInLottoRange(Integer number) {
        if (!isScope(number, LOTTO_NUMBER_SCOPE)) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 범위에 맞지 않습니다.");
        }
    }

    private static boolean isScope(Integer number, Pair<Integer, Integer> scope) {
        if (scope.first != null && number < scope.first) {
            return false;
        }
        if (scope.second != null && number > scope.second) {
            return false;
        }
        return true;
    }

    public static void validateWinningNumbers(List<String> elements) {
        validateWinningSize(elements.size());
        validateWinningElement(elements);
    }

    private static void validateWinningSize(Integer size) {
        if (size != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력한 수의 개수가 6개가 아닙니다.");
        }
    }

    private static void validateWinningElement(List<String> elements) {
        for (String element : elements) {
            validateNumber(element);
            validateNumberInLottoRange(Integer.parseInt(element));
        }
    }

    public static void validateBonusNumber(String inputContent, Status status) {
        validateNumber(inputContent);
        validateNumberInLottoRange(Integer.parseInt(inputContent));
        validateDuplicateToWinningGroup(inputContent, status);
    }

    private static void validateDuplicateToWinningGroup(String inputContent, Status status) {
        if (!status.compareToWinningNumber(Integer.parseInt(inputContent))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복하는 값이 있습니다.");
        }
    }

}
