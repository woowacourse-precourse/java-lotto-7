package lotto.dto.result;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

public record TicketCount(int count) {

    public TicketCount {
        validateTicketCount(count);
    }

    private void validateTicketCount(int count) {
        if (count <= 0) {
            throw CustomIllegalArgumentException.from(NEGATIVE_OR_ZERO_TICKET_COUNT);
        }
    }
}
