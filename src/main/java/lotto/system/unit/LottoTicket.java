package lotto.system.unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> ticket;

    public LottoTicket(List<LottoNumber> tickets) {
        this.ticket = tickets;
    }

    public static LottoTicket ofRawNumbers(List<Integer> rawTicket) {
        validateLottoNumber(rawTicket);
        return new LottoTicket(rawTicket.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static LottoTicket ofLottoNumbers(List<LottoNumber> tickets) {
        return new LottoTicket(tickets);
    }

    private static void validateLottoNumber(List<Integer> rawTicket) {
        for (int number : rawTicket) {
            LottoNumber.of(number);
        }
    }

    public List<LottoNumber> getTicket() {
        return Collections.unmodifiableList(ticket);
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
