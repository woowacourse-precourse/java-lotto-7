package lotto.input;

import lotto.config.Error;

public class DataInfo<T> {
        public final T value;
        public final lotto.config.Error status;

        public DataInfo(T value, Error status) {
            this.value = value;
            this.status = status;
        }
}
