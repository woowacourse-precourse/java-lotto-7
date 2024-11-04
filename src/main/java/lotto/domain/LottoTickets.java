package lotto.domain;

import static lotto.utils.Constants.ENTER;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Consumer;
import lotto.dto.LottoTicketsDto;
import lotto.utils.DtoMapper;

public class LottoTickets {

    private final List<Lotto> lottoCollection;

    public LottoTickets(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    public static LottoTickets generate(Money money) {
        List<Lotto> lottoCollection = new ArrayList<>();

        while (money.lottoTry()) {
            Lotto lotto = Lotto.generate();
            lottoCollection.add(lotto);
        }

        return new LottoTickets(lottoCollection);
    }

    public LottoTicketsDto toDto() {
        return DtoMapper.toLottoTicketsDto(this.toString());
    }

    protected void forEach(Consumer<Lotto> lotto) {
        lottoCollection.forEach(lotto);
    }

    protected int size() {
        return lottoCollection.size();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(ENTER);

        for (Lotto lotto : lottoCollection) {
            String lottoNumbers = lotto.toString();
            joiner.add(lottoNumbers);
        }

        return joiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTickets lottoTickets = (LottoTickets) o;
        return Objects.equals(lottoCollection, lottoTickets.lottoCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoCollection);
    }
}
