package lotto.dto;

import lotto.configuration.Prize;
import lotto.exception.DtoExceptionMessage;
import lotto.exception.ExceptionUtils;

public record PrizeCountEntry(Prize prize, int count) {

    public PrizeCountEntry {
        if (prize == null) {
            throw ExceptionUtils.IllegalArgument(DtoExceptionMessage.NULL_EXCEPTION);
        }
    }

}
