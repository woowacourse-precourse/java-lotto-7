package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.exception.EntityNotFoundException;
import lotto.repository.impl.LottoListRepository;
import lotto.repository.mock.MockMoneyRepository;
import lotto.service.impl.LottoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    @ParameterizedTest
    @DisplayName("dto를 반환한다.")
    @ValueSource(strings = {"10000", "1000", "2000", "5000"})
    void test1(String input) {
        // given
        Money money = Money.create(input);
        MockMoneyRepository moneyRepository = new MockMoneyRepository(money);
        LottoListRepository lottoListRepository = new LottoListRepository();
        LottoService service = new LottoServiceImpl(moneyRepository, lottoListRepository);
        MoneyDto expect = money.toDto();

        // then
        MoneyDto result = service.createMoney(input);

        // when
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("null 을 넣으면 예외 반환")
    void test2() {
        MockMoneyRepository mockNullRepository = new MockMoneyRepository(null);
        LottoListRepository lottoListRepository = new LottoListRepository();

        LottoService service = new LottoServiceImpl(mockNullRepository, lottoListRepository);

        assertThatThrownBy(service::generateLottoList).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    @DisplayName("get 호출 시 정상값을 반환")
    void test3() {
        // given
        Money money = Money.create("10000");
        MockMoneyRepository moneyRepository = new MockMoneyRepository(money);
        LottoListRepository lottoListRepository = new LottoListRepository();
        LottoService service = new LottoServiceImpl(moneyRepository, lottoListRepository);

        // when
        LottoListDto result = service.generateLottoList();

        // then
        assertThat(result).isNotNull();
    }
}
