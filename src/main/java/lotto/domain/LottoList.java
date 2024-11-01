package lotto.domain;

import static lotto.utils.Constants.ENTER;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import lotto.dto.LottoListDto;
import lotto.utils.DtoMapper;

public class LottoList {

    private final List<Lotto> lottoCollection;

    public LottoList(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    public static LottoList generate(Money money) {
        List<Lotto> lottoCollection = new ArrayList<>();

        while (money.lottoTry()) {
            Lotto lotto = Lotto.generate();
            lottoCollection.add(lotto);
        }

        return new LottoList(lottoCollection);
    }

    public LottoListDto toDto() {
        return DtoMapper.toLottoListDto(this, this.toString());
    }

    public WinnerCountList countWinnerMatches(WinnerLotto winnerLotto) {
        WinnerCountList countDtoList = new WinnerCountList();

        for (Lotto lotto : lottoCollection) {
            WinnerCount countDto = winnerLotto.countWinnerMatch(lotto);
            countDtoList.add(countDto);
        }

        return countDtoList;
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
        LottoList lottoList = (LottoList) o;
        return Objects.equals(lottoCollection, lottoList.lottoCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoCollection);
    }
}
