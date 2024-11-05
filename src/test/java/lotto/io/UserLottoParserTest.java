package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.UserLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoParserTest {

    @DisplayName("UserLotto dto 객체를 문자열로 파싱한다.")
    @Test
    void 객체_파싱_테스트() {
        //given
        UserLottoParser parser = new UserLottoParser();
        UserLotto userLotto = getUserLotto();

        //when
        String result = parser.parseUserLotto(userLotto);

        //then
        Assertions.assertThat(result).isEqualTo(
                """
                                                
                        3개를 구매했습니다.
                        [1, 2, 3, 4, 5, 6]
                        [7, 8, 9, 10, 11, 12]
                        [13, 14, 15, 16, 17, 18]
                                                
                        """
        );
    }

    private UserLotto getUserLotto() {
        int lottoCount = 3;
        List<Lotto> lottos = new ArrayList<>();

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));

        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);

        return new UserLotto(lottoCount, lottos);
    }

}