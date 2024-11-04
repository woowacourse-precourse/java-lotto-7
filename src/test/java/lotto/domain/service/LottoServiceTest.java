package lotto.domain.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.util.parser.BonusNumberParser;
import lotto.domain.util.parser.DelimitedNumberParser;
import lotto.domain.util.parser.MoneyParser;
import lotto.domain.util.parser.StringParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoServiceTest {

    @Test
    void 보너스_번호가_당첨번호에_포함될경우_예외가_발생한다() {
        //given
        StringParser<List<Integer>> numberParser = DelimitedNumberParser.getInstance();
        StringParser<Integer> bonusParser = BonusNumberParser.getInstance();
        StringParser<Integer> moneyParser = MoneyParser.getInstance();
        LottoService.init(numberParser, bonusParser, moneyParser);
        LottoService service = LottoService.getInstance();

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String duplicateBonusNumber = "5";

        //when, then
        Assertions.assertThatThrownBy(() -> service.setBonusNumber(lotto.getNumbers(), duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}