package lotto.domain;

public class FirstTicket {
    private static final String REQUEST_NOT_BONUS_NUMBER = "당첨 번호와 보너스 번호가 중첩되지 않게 해주세요.";

    private final Ticket firstTicket;
    private final LottoNumber bonusNumber;

    public FirstTicket(Ticket firstTicket, LottoNumber bonusNumber) {
        checkContainNumber(firstTicket, bonusNumber);
        this.firstTicket = firstTicket;
        this.bonusNumber = bonusNumber;
    }

    private void checkContainNumber(Ticket firstTicket, LottoNumber bonusNumber) {
        if (firstTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(REQUEST_NOT_BONUS_NUMBER);
        }
    }

    public Rank getTicketRank(Ticket ticket) {
        int count = firstTicket.getSameNumberCount(ticket);
        boolean isBonus = false;

        if (Rank.isThirdCount(count)) {
            isBonus = ticket.contains(bonusNumber);
        }
        return Rank.value(count, isBonus);
    }
}

