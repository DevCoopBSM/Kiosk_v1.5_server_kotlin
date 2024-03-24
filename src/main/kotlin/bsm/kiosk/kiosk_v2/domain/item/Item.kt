package bsm.kiosk.kiosk_v2.domain.item

import bsm.kiosk.kiosk_v2.domain.inventory.Inventory
import bsm.kiosk.kiosk_v2.domain.kiosk_receipt.KioskReceipt
import jakarta.persistence.*

@Entity
class Item private constructor(
  barcode: String,
  itemName: String,
  price: Int,
  receipt: KioskReceipt,
  inventory: Inventory
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "itemId")
  var id: Long = 0L

  var barcode: String = barcode
    private set

  var itemName: String = itemName
    private set

  @Column(name = "itemPrice")
  var price: Int = price
    private set

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "number")
  var receipt: KioskReceipt = receipt

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inventory_id")
  var inventory: Inventory = inventory
}
