package lotto.model.draw;
// 보너스 넘버를 관리하는 객체
public class BonusNumber {

    private static final String INVALID_EMPTY_MESSAGE = "[ERROR] 보너스 번호가 빈 값입니다.";
    private static final String INVALID_NUMERIC_MESSAGE = "[ERROR] 보너스 번호는 숫자만 입력 가능합니다.";
    private static final String INVALID_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INVALID_DUPLICATION_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복 되지 않는 숫자여야 합니다.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    private BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber from(String input) {
        String stripped = input.strip();
        validateEmpty(input);
        validateNumeric(stripped);
        int number = Integer.parseInt(stripped);
        return new BonusNumber(number);
    }
    // 만일 Lotto관련된 번호를 Number라는 객체로 포장 한다면 번호 관련된 검증 책임들을 해당 객체에서 모두 담당하기 때문에
    // input값에 대한 변환 및 검증 책임만 BonusNumber가 지면 되지 않을까 생각 중... 이와 관련된 리펙토링 진행해 보는 것도 좋을 것 같음..
    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC_MESSAGE);
        }
    }

    private void validate(int number) {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }
    // WinningLotto와 BonusNumber를 하나의 객체에서 한번 더 관리한다면... 아래 보너스 번호 중복 여부 확인에 대한 책임은 그쪽으로 위임할 수 있지 않을까?
    public void checkDuplicationNumber(WinningLotto winningLotto) {
        if (winningLotto.isContain(number)) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_MESSAGE);
        };
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
