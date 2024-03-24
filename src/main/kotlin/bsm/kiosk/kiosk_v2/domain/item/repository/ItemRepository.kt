package bsm.kiosk.kiosk_v2.domain.item.repository

import bsm.kiosk.kiosk_v2.domain.item.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: JpaRepository<Item, Long> {

}
