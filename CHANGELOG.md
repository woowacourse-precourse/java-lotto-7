# Changelog

## [Unreleased]

### Docs
- **readme**: 테스트 커버리지 및 소감 추가 (771d2f1)
- **readme**: 도메인 체크리스트 수정 (a997285)
- **readme**: 목표, 도메인 명세서, 기타 기능 명세 구성 (16177e6)
- **img**: 코드 커버리지 이미지 추가 (54ac3c3)

### Refactor
- **view**: inputview 내에 retryLogic 분리 (02020fd)
- **validate**: 직관성이 떨어지는 부분 분리 (2401d4a)
- Custom Error 추가 구성 및 변경 (6f79036)

### Style
- Format 적용 (837a68c)
- **all**: 전역 포맷 수정 (41e3f2e)

### Test
- **Application**: 애플리케이션 기능 및 예외 테스트 추가 (4ab3b64)
- **LottoBuyer**: LottoBuyer 테스트 추가 (ba5c0fb)
- **LottoMachine**: LottoMachine 테스트 추가 (05b126e)
- **LottoNumberPicker**: LottoNumberPicker 테스트 추가 (f7e057f)
- **MockLottoMachine**: MockLottoMachine 클래스 추가 (a25c81c)
- **ProfitRate**: ProfitRate 클래스의 수익률 계산 테스트 추가 (a729c9c)
- **WinningAnalysisReportBuilder**: WinningAnalysisReportBuilder 테스트 추가 (1ec6cd7)
- **WinningAnalysisReport**: WinningAnalysisReport 테스트 추가 (9051713)
- **WinningNumberPicker**: WinningNumberPicker 테스트 추가 (3906fb9)
- **WinningNumbers**: WinningNumbers 유효성 검사 추가 (886fb4b)
- **WinningRule**: WinningRule 유효성 검사 및 속성 검사 추가 (3cf25d5)
- **WinningStatistics**: WinningStatistics 클래스에 대한 테스트 추가 (acd0d39)
- **LottoTickets**: LottoTicket리스트에 대한 일급 컬렉션 테스트 처리 (a9d2c61)
- **LottoTicket**: LottoTicket 도메인 테스트 처리 (ccd2922)
- **Money**: Money 도메인 테스트 처리 (9b99012)
- **Lotto**: 로또 테스트 처리 (152f388)

### Features
- **application**: 애플리케이션 진입점 추가 (623c937)
- **exception**: 최대 재시도 횟수 초과 예외 클래스 추가 (1e96324)
- **LottoService**: 로또 서비스 기능 구현 (ed3f4ea)
- **LottoController**: 로또 컨트롤러 구현 (afa73df)
- **Controller**: 기본 컨트롤러 클래스 구현 (6e1ea27)
- **LottoInput**: 사용자 입력 기능 추가 (ea86d27)
- **LottoOutput**: 로또 출력 기능 추가 (9f526f1)
- **ApplicationConfig**: 로또 애플리케이션 구성 클래스 추가 (6c4a233)
- **LottoNumberParser**: 로또 번호 파싱 기능 추가 (5dba6db)
- **LottoNumberPicker**: 로또 번호 생성 기능 추가 (9550ce1)
- **WinningNumberPicker**: 당첨 번호 생성 기능 추가 (459d5e7)
- **LottoBuyer**: 로또 티켓 구매 기능 추가 (c4f209f)
- **LottoMachine**: 로또 티켓 생성 기능을 추가한 로또 머신 구현 (18945dd)
- **WinningNumbers**: 일반 클래스로 변경하여 로또 당첨 번호 처리 기능 추가 (3152716)
- **WinningStatistics**: 추첨 통계를 처리하는 도메인 로직 추가 (571c58d)
- **WinningRule**: 추첨결과에 따른 규칙을 선언한 enum 객체 구성 (cf73693)
- **ProfitRate**: 수익률 도메인 구성 (04eaac6)
- **WinningAnalysisReport**: WinningAnalysisReport 도메인 구성 (ef2cb73)
- **LottoTickets**: LottoTicket리스트에 대한 일급 컬렉션 도메인 구성 (46c1e59)
- **exception**: Lotto 서비스에 대한 Exception을 구성 (edf0c5d)
- **LottoTicket**: LottoTicket 도메인 구성 (35d97f4)
- **Lotto**: 로또 도메인 구성 (8a683ba)

### Initial Setup
- **setup project** (99b1964)
