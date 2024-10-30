package lotto.domain.entity;

import java.util.List;

// 로또 객체를 가지는 일급 컬렉션
public record LottoTickets(List<Lotto> tickets) {
}
