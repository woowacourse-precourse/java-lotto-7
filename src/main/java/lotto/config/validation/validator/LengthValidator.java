package lotto.config.validation.validator;

import java.lang.annotation.Annotation;
import java.util.List;
import lotto.config.validation.annotation.Length;
import lotto.config.validation.annotation.ValidType;
import lotto.config.validation.exception.ValidationException;

@ValidType(Length.class)
public class LengthValidator implements Validator {

    public LengthValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        try {
            Length lengthAnnotation = (Length) annotation;

            int valueLength = getObjectLength(value);
            int minLength = lengthAnnotation.min();
            int maxLength = lengthAnnotation.max();

            if (valueLength < minLength || valueLength > maxLength) {
                throw new ValidationException("길이를 만족하지 않습니다.");
            }
        } catch (ClassCastException e) {
            throw new ValidationException("숫자가 아닙니다.");
        }
    }

    private int getObjectLength(Object value) {
        if (value instanceof String) {
            return value.toString().length();
        }

        if (value instanceof List<?>) {
            return ((List<?>) value).size();
        }

        throw new ClassCastException();
    }
}
