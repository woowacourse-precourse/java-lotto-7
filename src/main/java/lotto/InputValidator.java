package lotto;

public class InputValidator {

    public void validateNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public void validateNumbersByComma(String numbers) {
        for(char ch : numbers.toCharArray()) {
            if(isNotNumbersCondition(ch)) {
                throw new IllegalArgumentException("[ERROR] 쉼표로 구분해서 숫자를 입력해주세요");
            }
        }
    }

    private boolean isNotNumbersCondition(char ch) {
        return !Character.isDigit(ch) && ch != ',';
    }
}
