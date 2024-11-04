package lotto.domain.validator;

import lotto.exception.NullParameterException;

public class ParamsValidator {

    public static void validateParamsNotNull(Class<?> caller, Object... params) {
        for (Object obj : params) {
            if (obj == null) {
                throw new NullParameterException(caller);
            }
        }
    }
}
