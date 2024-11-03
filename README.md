# java-lotto-precourse
---
기능 구현 목록

inputView
- [ ] 구입 금액 입력


outputView
- [ ] 입력 메세지 출력
- [ ] 구매한 로또 번호 출력(Lotto)
- [ ] 당첨 통계 출력(Lottos)
- [ ] 총 수익률 출력

LottoController
- [ ] 구입 금액 검증
- [ ] 로또 번호 생성 후 Lotto 객체 생성


Lotto
- [x] validate 숫자 번호 1~45 검증
- [x] validate 숫자 중복 검증
- [ ] 일치하는 번호 수에 따른 결과 WinningType 반환


Lottos
- [ ] 당첨 번호, 보너스 번호 검증
- [ ] 총 수익률 계산 (둘째 자리 반올림)


WinningType
- [ ] 일치하는 번호 수에 따른 금액 Enum
