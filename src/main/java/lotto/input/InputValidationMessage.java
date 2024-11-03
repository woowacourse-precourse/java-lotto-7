package lotto.input;

import org.assertj.core.internal.ErrorMessages;

import java.security.MessageDigest;

public enum InputValidationMessage {

    MESSAGE_NUMBER("[ERROR] : 유효하지 않은 입력입니다. 숫자를 입력하세요."),
    MESSAGE_MODULAR("[ERROR] : 유효하지 않은 입력입니다. 1000원단위로 입력하세요"),
    MESSAGE_NUMBER_RANGE("[ERROR] : 유효하지 않은 입력입니다. 숫자는 1~45 사이만 입력가능합니다"),
    MESSAGE_NUMBER_FORMMAT("[ERROR] : 유효하지 않은 입력입니다. 숫자만 입력 가능합니다"),
    MESSAGE_NUMBER_CANNOT_DUPLICATE("[ERROR] : 로또 번호는 중복될 수 없습니다."),

    MESSAGE_BONUS_NUMBER_CANNOT_DUPLICATE("[ERROR] 보너스 번호는 기존 번호와 중복될 수 없습니다.");


    private final String message;

    InputValidationMessage(String message){
        this.message = message;

    }

    public String getMessage(){
        return message;
    }

}
