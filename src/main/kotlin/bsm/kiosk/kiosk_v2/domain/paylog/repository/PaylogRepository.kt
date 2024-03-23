package bsm.kiosk.kiosk_v2.domain.paylog.repository

import bsm.kiosk.kiosk_v2.domain.paylog.Paylog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaylogRepository: JpaRepository<Paylog, Long> {

}
