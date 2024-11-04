package lotto.service.input.validator;

public class CommonValidator implements InputValidatorService{

    @Override
    public void validate(String input) {
        vacantInput(input);
        whitespaceExist(input);
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