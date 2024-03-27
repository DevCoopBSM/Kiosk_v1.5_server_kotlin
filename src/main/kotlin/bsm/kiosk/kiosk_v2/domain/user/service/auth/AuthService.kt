package bsm.kiosk.kiosk_v2.domain.user.service.auth

import bsm.kiosk.kiosk_v2.domain.user.User
import bsm.kiosk.kiosk_v2.domain.user.presentation.dto.request.LoginRequest
import bsm.kiosk.kiosk_v2.domain.user.presentation.dto.response.LoginResponse
import bsm.kiosk.kiosk_v2.domain.user.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AuthService(
  private val userRepository: UserRepository,
  private val bCryptPasswordEncoder: BCryptPasswordEncoder,
) {
  fun register(dto: LoginRequest): LoginResponse? {
    val codeNumber: String = dto.codeNumber
    val pin: String = dto.pin

    if(codeNumber.isBlank() || pin.isBlank()) {
      throw RuntimeException("입력 값이 없습니다.")
    }

    val user: User = userRepository.findByCodeNumber(codeNumber)

    if(user == null) {
      throw RuntimeException("코드번호가 존재하지 않습니다.")
    }

    val encodedPin: String = bCryptPasswordEncoder.encode(pin)

    if(!bCryptPasswordEncoder.matches(encodedPin, user.password)) {
      throw RuntimeException("비밀번호가 일치하지 않습니다.")
    }

    return LoginResponse(
      token = user.accToken,
      studentNumber = user.studentNumber,
      codeNumber = user.codeNumber,
      studentName = user.studentName,
      point = user.point,
    )
  }
}
