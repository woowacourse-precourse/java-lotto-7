package lotto.config.validation.validator;

import java.lang.annotation.Annotation;
import lotto.config.validation.exception.ValidationException;

/**
 * 유효성 검사를 구현하는 클래스
 */
public interface Validator {

    <T> void valid(Annotation annotation, T value) throws ValidationException;
}
