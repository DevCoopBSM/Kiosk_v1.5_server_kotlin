package bsm.kiosk.kiosk_v2.domain.user.repository


import bsm.kiosk.kiosk_v2.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String> {

  fun findByCodeNumber(codeNumber: String): User

}
