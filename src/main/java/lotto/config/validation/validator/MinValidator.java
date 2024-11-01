package lotto.config.validation.validator;

import java.lang.annotation.Annotation;
import lotto.config.validation.annotation.Min;
import lotto.config.validation.annotation.ValidType;
import lotto.config.validation.exception.ValidationException;

@ValidType(Min.class)
public class MinValidator implements Validator {

    public MinValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        try {
            Min minAnnotation = (Min) annotation;
            int minValue = minAnnotation.value();

            if ((int) value < minValue) {
                throw new ValidationException("최솟값을 만족하지 않습니다.");
            }
        } catch (ClassCastException e) {
            throw new ValidationException("숫자가 아닙니다.");
        }
    }
}
