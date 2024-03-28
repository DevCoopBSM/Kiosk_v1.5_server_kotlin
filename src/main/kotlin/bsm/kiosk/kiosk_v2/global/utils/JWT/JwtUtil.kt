package bsm.kiosk.kiosk_v2.global.utils.JWT

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtil {
  fun createJwt(codeNumber: String, secretKey: String, exprTime: Long): String {
    val claims: Claims = Jwts.claims()
    claims["codeNumber"] = codeNumber

    val now: Date = Date(System.currentTimeMillis())
    val exp: Date = Date(now.time + exprTime)

    val token: String = Jwts.builder()
      .setClaims(claims)
      .signWith(SignatureAlgorithm.HS256, secretKey)
      .setIssuedAt(now)
      .setExpiration(exp)
      .compact()

    return token
  }
}
