package lotto.config.validation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.config.validation.exception.NotFoundClassFieldException;
import lotto.config.validation.exception.ValidationException;

/**
 * 어노테이션 기반으로 필드의 데이터 유효성 검사를 진행하는 클래스
 */
public abstract class FieldValidation {

    private final Class<? extends FieldValidation> cls;

    protected FieldValidation() {
        cls = this.getClass();
    }

    protected void valid() {
        List<Field> fields = extractFields(cls);

        for (final Field field : fields) {
            isValid(field);
        }
    }

    private List<Field> extractFields(Class<?> target) {
        List<Field> fields = List.of(target.getDeclaredFields());
        if (target.getSuperclass() != null) {
            Stream<Field> classFields = fields.stream();
            Stream<Field> superClassFields = extractFields(target.getSuperclass()).stream();

            fields = Stream.concat(classFields, superClassFields)
                    .toList();
        }

        return fields.stream()
                .peek(it -> it.setAccessible(true))
                .collect(Collectors.toList());
    }

    private void isValid(Field field) {
        List<Annotation> annotations = List.of(field.getAnnotations());

        for (Annotation annotation : annotations) {
            try {
                Validation.valid(annotation, field.get(this));
            } catch (ValidationException e) {
                throw e;
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new NotFoundClassFieldException();
            }
        }
    }
}
