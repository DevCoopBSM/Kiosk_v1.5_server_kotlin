package bsm.kiosk.kiosk_v2.domain.user.service.auth

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
    return null;
  }
}
