package bsm.kiosk.kiosk_v2.domain.user.presentation.dto.request

data class LoginRequest(
  val codeNumber: String,
  val pin: String,
)
