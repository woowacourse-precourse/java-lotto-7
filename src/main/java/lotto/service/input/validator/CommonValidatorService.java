package lotto.service.input.validator;

public class CommonValidatorService implements InputValidatorService{

    @Override
    public void validate(String input) {
        inputIsNull(input);
        vacantInput(input);
        whitespaceExist(input);
    }

    private void inputIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] null 값이 입력되었습니다.");
        }
    }

    public void vacantInput(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공백 문자가 입력되었습니다.");
        }
    }

    public void whitespaceExist(String input) {
        if(input.chars().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("[ERROR] 공백 문자가 포함된 입력입니다.");
        }
    }
}