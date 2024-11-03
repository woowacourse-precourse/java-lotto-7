package lotto.shop.bandingmachine.drawsystem;

import java.util.List;
import lotto.MessageCenter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AutoDrawerTest {

    DrawnNumbers drawnNumbers = DrawnNumbers.create();
    AutoDrawer autoDrawer = new AutoDrawer(drawnNumbers);

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,100})
    @DisplayName("drawnNumberPacks에 저장된 로또번호묶음의 개수는 구매장수와 같다.")
    void drawnNumberPacks에_저장된_로또번호묶음의_개수는_totalCount와_같다(int totalCount) {
        assertThat(autoDrawer.runDraws(totalCount).size()).isEqualTo(totalCount);
    }
}
