package lotto.service.lotto;

import static lotto.config.LottoConstants.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("로또 번호 고유 생성 테스트")
    @Test
    void generateUniqueNumbersInRangeTest() {

        // when
        List<LottoNumber> lottoNumbers = LottoGenerator.generateUniqueNumbersInRange();

        // then1 : 로또 번호의 개수가 6개인지 확인
        assertEquals(LOTTO_NUMBER_COUNT, lottoNumbers.size(), "로또 번호 개수가 정확해야 합니다.");

        // then2 : 중복이 없는지 확인
        Set<LottoNumber> uniqueNumbers = new HashSet<>(lottoNumbers);
        assertEquals(LOTTO_NUMBER_COUNT, uniqueNumbers.size(), "로또 번호는 중복되지 않아야 합니다.");

        // then3 : 오름차순 정렬되어 있는지 확인
        List<LottoNumber> sortedLottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
        assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
    }
}