package bsm.kiosk.kiosk_v2.domain.item

import bsm.kiosk.kiosk_v2.domain.kiosk_receipt.KioskReceipt
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Item private constructor(
  barcode: String,
  itemName: String,
  price: Int,
  receipts: MutableList<KioskReceipt>
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "itemId")
  val id: Long = 0L
  var barcode: String = barcode
    private set
  var itemName: String = itemName

  @Column(name = "itemPrice")
  var price: Int = price
    private set
  @OneToMany(
    mappedBy = "id",
    cascade = [CascadeType.ALL],
    orphanRemoval = true
  )
  var receipts: MutableList<KioskReceipt> = receipts
    private set
  fun addKioskReceipt(kioskReceipt: KioskReceipt) {
    kioskReceipt.itemName = this
    this.receipts.add(kioskReceipt)
  }
}
