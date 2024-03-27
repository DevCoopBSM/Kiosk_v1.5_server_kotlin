package bsm.kiosk.kiosk_v2.domain.user.presentation

import bsm.kiosk.kiosk_v2.domain.user.presentation.dto.request.LoginRequest
import bsm.kiosk.kiosk_v2.domain.user.presentation.dto.response.LoginResponse
import bsm.kiosk.kiosk_v2.domain.user.service.auth.AuthService
import bsm.kiosk.kiosk_v2.global.ApiPath
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Auth", description = "Auth API")
class AuthController(
  private val authService: AuthService,
) {
  @PostMapping(ApiPath.AUTH_PATH + "/signIn")
  @Operation(summary = "sign in", description = "로그인")
  fun signIn(@RequestBody loginRequest: LoginRequest): LoginResponse? {
    return authService.register(loginRequest)
  }
}
