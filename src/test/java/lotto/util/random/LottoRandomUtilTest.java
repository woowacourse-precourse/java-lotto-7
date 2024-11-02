package lotto.util.random;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRandomUtilTest {

    @Test
    @DisplayName("LottoRandomUtil 싱글톤 인스턴스를 생성하는지 확인")
    void getLottoRandomUtil() {
        // given & when
        LottoRandomUtil firstLottoRandomUtil = LottoRandomUtil.getLottoRandomUtil();
        LottoRandomUtil secondLottoRandomUtil = LottoRandomUtil.getLottoRandomUtil();

        // then
        assertThat(firstLottoRandomUtil).isSameAs(secondLottoRandomUtil);
    }

    @Test
    @DisplayName("issueLottoTicket 호출 시 지정된 범위 내의 고유 숫자를 생성하는지 확인")
    void issueLottoTicket() {
        // given
        LottoRandomUtil lottoRandomUtil = LottoRandomUtil.getLottoRandomUtil();
        int minNumber = 1;
        int maxNumber = 45;
        int lottoNumber = 6;

        // when
        List<Integer> lottoTicket = lottoRandomUtil.issueLottoTicket(minNumber, maxNumber, lottoNumber);

        // then
        assertThat(lottoTicket).hasSize(6);
        assertThat(lottoTicket).allMatch(number -> number >= minNumber && number <= maxNumber);

        Set<Integer> uniqueNumbers = new HashSet<>(lottoTicket);
        assertThat(uniqueNumbers).hasSize(6);
    }
}
