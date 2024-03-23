package bsm.kiosk.kiosk_v2.domain.item.repository

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: JpaRepository<Item, Long> {

}
