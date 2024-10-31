package validation;

public interface Validator<T> {

    void validate(T input);
}
