package lotto.config.validation.validator;

import java.lang.annotation.Annotation;
import lotto.config.validation.annotation.Max;
import lotto.config.validation.annotation.ValidType;
import lotto.config.validation.exception.ValidationException;

@ValidType(Max.class)
public class MaxValidator implements Validator {

    public MaxValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        try {
            Max maxAnnotation = (Max) annotation;
            int maxValue = maxAnnotation.value();

            if ((int) value > maxValue) {
                throw new ValidationException("최댓값을 만족하지 않습니다.");
            }
        } catch (ClassCastException e) {
            throw new ValidationException("숫자가 아닙니다.");
        }
    }
}
