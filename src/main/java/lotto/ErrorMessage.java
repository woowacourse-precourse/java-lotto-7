package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ErrorMessage {      // 예외별 메시지 관리
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위의 양수 입니다.") {
        // 구입 금액은 양수인 1000원 단위
        @Override
        public void validateAmount(int amount) {
            if (amount <= 0 || amount % 1000 != 0) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    },

    INVALID_WINNING_NUMBER("[ERROR] 당첨 번호는 6개 입니다.") {
        // 사용자가 입력한 당첨 번호의 숫자는 6개
        @Override
        public void validate(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    },

    INVALID_NUMBER_RANGE("[ERROR] 번호는 1 ~ 45까지의 양수만 가능합니다.") {
        // 1 ~ 45의 숫자 확인
        @Override
        public void validate(int number) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    },

    DUPLICATE_WINNING_NUMBER("[ERROR] 당첨 번호는 중복될수 없습니다.") {
        // 사용자가 입력한 당첨 번호는 중복x
        @Override
        public void validate(List<Integer> numbers) {
            Set<Integer> compareWinningNumber = new HashSet<>(numbers);
            if (compareWinningNumber.size() != numbers.size()) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    },

    INVALID_INPUT_NUMBER("[ERROR] 올바른 숫자를 입력해주세요") {
        // 사용자가 입력한 유효 숫자 확인 여부
        @Override
        public void validate(String numbers) {
            try {
                Integer.parseInt(numbers);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    },

    DUPLICATE_BONUS_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.") {
        // 보너스 번호와 당첨 번호의 중복 여부
        @Override
        public void validate(List<Integer> winningNumbers, int bonusNumber) {
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    };

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void validateAmount(int amount) {}
    public void validate(List<Integer> numbers) {}
    public void validate(int number) {}
    public void validate(String numbers) {}
    public void validate(List<Integer> winningNumbers, int bonusNumber) {}

    public String getMessage() {
        return message;
    }
}
