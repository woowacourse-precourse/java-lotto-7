package lotto.domain.factory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.entity.WinningDetail;

class WinningDetailFactoryTest {

    @Test
    @DisplayName("WinningDetail 생성 시 새로운 객체가 정상적으로 생성되어야 한다")
    void create_ShouldCreateNewWinningDetail() {
        WinningDetail winningDetail = WinningDetailFactory.create();

        assertNotNull(winningDetail,
            "WinningDetailFactory가 생성한 객체는 null이 아니어야 합니다");
    }
}