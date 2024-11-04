package lotto.dto.result;

import static lotto.exception.ErrorMessage.*;

public record TicketCount(int count) {

    public TicketCount {
        validateTicketCount(count);
    }

    private void validateTicketCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(NEGATIVE_OR_ZERO_TICKET_COUNT.getMessage());
        }
    }
}
