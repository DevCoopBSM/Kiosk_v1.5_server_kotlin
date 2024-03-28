package bsm.kiosk.kiosk_v2.domain.user.service.auth

import bsm.kiosk.kiosk_v2.domain.user.User
import bsm.kiosk.kiosk_v2.domain.user.presentation.dto.request.LoginRequest
import bsm.kiosk.kiosk_v2.domain.user.presentation.dto.response.LoginResponse
import bsm.kiosk.kiosk_v2.domain.user.repository.UserRepository
import bsm.kiosk.kiosk_v2.global.utils.JWT.JwtUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.exp

@Service
@Transactional
class AuthService(
  private val userRepository: UserRepository,
  private val bCryptPasswordEncoder: BCryptPasswordEncoder,
  private val jwtUtil: JwtUtil,
) {
  @Value("\${jwt.secret}")
  private final lateinit var secretKey: String
  val exprTime: Long = 1000 * 60 * 10L

  fun register(dto: LoginRequest): LoginResponse? {
    val codeNumber: String = dto.codeNumber
    val pin: String = dto.pin

    if(codeNumber.isBlank() || pin.isBlank()) {
      throw RuntimeException("입력 값이 없습니다.")
    }

    val user: User = userRepository.findByCodeNumber(codeNumber)

    if(user == null) {
      throw RuntimeException("존재하지 않는 사용자입니다.")
    }

    if(!bCryptPasswordEncoder.matches(pin, user.password)) {
      throw RuntimeException("비밀번호가 일치하지 않습니다.")
    }

    val token: String = jwtUtil.createJwt(codeNumber, secretKey, exprTime)

    return LoginResponse(
      token = token,
      studentNumber = user.studentNumber,
      codeNumber = user.codeNumber,
      studentName = user.studentName,
      point = user.point,
    )
  }
}
