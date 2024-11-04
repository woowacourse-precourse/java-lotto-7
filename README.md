# java-lotto-precourse
---
기능 구현 목록

inputView
- [x] 사용자 입력
- [x] 싱글톤 구현


outputView
- [x] 입력 프롬프트 출력 메세지 static final 변수로 선언
- [x] 구매한 로또 번호 출력(Lotto)
- [x] 당첨 통계 출력(Lottos)
- [x] 총 수익률 출력
- [x] 싱글톤 구현

LottoController
- [x] 구입 금액 단위 검증
- [x] 사용자 입력 구입 금액 숫자 검증
- [x] 로또 번호 생성 후 Lotto 객체 생성
- [x] 사용자 입력 당첨 번호 숫자 검증
- [x] 당첨 번호 및 보너스 번호 입력 기능


Lotto
- [x] validate 숫자 번호 1~45 검증
- [x] validate 숫자 환중복 검증
- [x] 일치하는 번호 수에 따른 결과 WinningType 반환


Lottos
- [x] 당첨 번호, 보너스 번호 중복 검증
- [x] 당첨 번호 개수 검증
- [x] 당첨 번호 범위 검증
- [x] 보너스 번호 범위 검증
- [x] Lotto 객체 별 당첨 결과 저장
- [x] 총 합 상금 계산


WinningType
- [x] 일치하는 번호 수에 따른 금액 Enum
