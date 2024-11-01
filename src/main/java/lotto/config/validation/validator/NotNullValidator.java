package lotto.config.validation.validator;

import java.lang.annotation.Annotation;
import lotto.config.validation.annotation.NotNull;
import lotto.config.validation.annotation.ValidType;
import lotto.config.validation.exception.ValidationException;

@ValidType(NotNull.class)
public class NotNullValidator implements Validator {

    public NotNullValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("NULL이 될 수 없습니다.");
        }
    }
}
