package lotto.config.numberPicker;

import lotto.domain.numberPicker.NumberPicker;
import lotto.domain.numberPicker.RandomNumberPicker;

public class DefaultNumberPickerConfig implements NumberPickerConfig {

    private final NumberPicker numberPicker;

    public DefaultNumberPickerConfig() {
        this.numberPicker = new RandomNumberPicker();
    }

    @Override
    public NumberPicker getNumberPicker() {
        return this.numberPicker;
    }
}
