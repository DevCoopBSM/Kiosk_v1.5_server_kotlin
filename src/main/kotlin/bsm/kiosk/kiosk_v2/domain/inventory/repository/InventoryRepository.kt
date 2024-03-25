package bsm.kiosk.kiosk_v2.domain.inventory.repository

import bsm.kiosk.kiosk_v2.domain.inventory.Inventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository: JpaRepository<Inventory, Long> {

}
