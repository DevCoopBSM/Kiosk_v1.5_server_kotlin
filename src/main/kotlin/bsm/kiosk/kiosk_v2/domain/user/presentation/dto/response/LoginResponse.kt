package bsm.kiosk.kiosk_v2.domain.user.presentation.dto.response

data class LoginResponse(
  val token: String = "",
  val studentNumber: Int = 0,
  val codeNumber: String = "",
  val studentName: String = "",
  val point: Int = 0
)
