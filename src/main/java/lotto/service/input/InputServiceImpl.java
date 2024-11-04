package lotto.service.input;

import lotto.service.input.converter.InputConverterService;
import lotto.service.input.validator.InputValidatorService;

public class InputServiceImpl<T> implements InputService<T> {

    private final InputValidatorService inputValidator;
    private final InputConverterService<T> inputConverter;
    private String inputValue;

    public InputServiceImpl(InputValidatorService inputValidator,
                            InputConverterService<T> inputConverter) {
        this.inputValidator = inputValidator;
        this.inputConverter = inputConverter;
    }

    @Override
    public void validate(String input) {
        inputValidator.validate(input);
        this.inputValue = input;
    }

    @Override
    public T get() {
        return inputConverter.convert(inputValue);
    }
}