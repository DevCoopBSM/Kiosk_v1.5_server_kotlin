package bsm.kiosk.kiosk_v2.domain.item

import bsm.kiosk.kiosk_v2.domain.inventory.Inventory
import bsm.kiosk.kiosk_v2.domain.kiosk_receipt.KioskReceipt
import jakarta.persistence.*

@Entity
class Item private constructor(
  var barcode: String,
  var itemName: String,
  @Column(name = "itemPrice") var price: Int,
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "number") var receipt: KioskReceipt,
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "inventory_id") var inventory: Inventory
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "itemId")
  var id: Long = 0L
}
