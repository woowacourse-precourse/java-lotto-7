package lotto.config.validation.validator;


import java.lang.annotation.Annotation;
import lotto.config.validation.annotation.Divisible;
import lotto.config.validation.annotation.ValidType;
import lotto.config.validation.exception.ValidationException;

@ValidType(Divisible.class)
public class DivisibleValidator implements Validator {

    public DivisibleValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        try {
            Divisible divisibleAnnotation = (Divisible) annotation;

            int divisibleValue = divisibleAnnotation.value();

            if ((int) value % divisibleValue != 0) {
                throw new ValidationException(divisibleAnnotation.message());
            }
        } catch (ClassCastException e) {
            throw new ValidationException("숫자가 아닙니다.");
        }
    }
}
