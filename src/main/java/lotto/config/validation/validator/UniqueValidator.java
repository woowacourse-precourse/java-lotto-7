package lotto.config.validation.validator;


import java.lang.annotation.Annotation;
import java.util.List;
import lotto.config.validation.annotation.Unique;
import lotto.config.validation.annotation.ValidType;
import lotto.config.validation.exception.ValidationException;

@ValidType(Unique.class)
public class UniqueValidator implements Validator {

    public UniqueValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        try {
            Unique uniqueAnnotation = (Unique) annotation;

            List<?> objects = (List<?>) value;
            List<?> distinct = objects.stream()
                    .distinct()
                    .toList();

            if (distinct.size() != objects.size()) {
                throw new ValidationException(uniqueAnnotation.message());
            }
        } catch (ClassCastException e) {
            throw new ValidationException("숫자가 아닙니다.");
        }
    }
}
