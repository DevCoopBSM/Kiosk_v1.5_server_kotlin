package bsm.kiosk.kiosk_v2.domain.kiosk_receipt.repository

import bsm.kiosk.kiosk_v2.domain.kiosk_receipt.KioskReceipt
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KioskReceiptRepository: JpaRepository<KioskReceipt, Long> {

}
