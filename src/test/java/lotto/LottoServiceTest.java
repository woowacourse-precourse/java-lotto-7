package lotto;

import lotto.model.Lotto;
import lotto.model.LottoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LottoServiceTest {
    LottoService service = new LottoService();

    List<Integer> luckyNumber = Arrays.asList(4, 5, 8, 9, 11, 20);
    int bonus = 13;
    int[] prizeTickets = {1, 1, 1, 1, 1};

    private static Stream<Arguments> provideLottoTickets() {
        return Stream.of(
                Arguments.of(List.of(
                        new Lotto(List.of(4, 5, 8, 9, 11, 20)),
                        new Lotto(List.of(4, 5, 8, 9, 11, 13)),
                        new Lotto(List.of(4, 5, 8, 9, 11, 15)),
                        new Lotto(List.of(4, 5, 8, 9, 15, 16)),
                        new Lotto(List.of(4, 5, 8, 15, 16, 17))
                ))
        );
    }

    @Test
    public void calculateProfitRateTest() {
        assertEquals(service.calculateProfitRate(5000L, 8000), 62.5);
        assertEquals(service.calculateProfitRate(2_000_000_000L, 3000), 66_666_666.67);
    }

    @Test
    public void sumPrizeTest() {
        long result = service.sumPrize(prizeTickets);
        assertEquals(result, 2_031_555_000);
    }

    @ParameterizedTest
    @MethodSource("provideLottoTickets")
    public void calculateTicketRankTest(List<Lotto> LottoTickets) {
        int[] actualRank = service.calculateTicketRank(LottoTickets, luckyNumber, bonus);

        assertArrayEquals(prizeTickets, actualRank);

    }

    @Test
    public void accordBonusNumberTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = LottoService.class.getDeclaredMethod("accordBonusNumber", List.class, int.class);
        method.setAccessible(true);

        List<Integer> ticket = new ArrayList<>(Arrays.asList(4, 5, 8, 9, 11, 13));

        assertTrue((Boolean) method.invoke(service, ticket, bonus));

    }

    @Test
    public void accordNumberCountTest() throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Method method = LottoService.class.getDeclaredMethod("accordNumberCount", List.class, List.class);
        method.setAccessible(true);

        List<Integer> ticket = new ArrayList<>(Arrays.asList(4, 5, 8, 9, 11, 17));
        int result = (int) method.invoke(service, ticket, luckyNumber);
        assertEquals(result, 5);
    }

}