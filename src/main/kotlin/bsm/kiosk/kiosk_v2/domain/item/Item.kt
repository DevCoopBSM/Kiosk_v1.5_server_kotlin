package bsm.kiosk.kiosk_v2.domain.item

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class Item private constructor(
  barcode: String,
  itemName: String,
  price: Int
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "itemId")
  val id: Long = 0L
  var barcode: String = barcode
    private set
  var itemName: String = itemName
    private set
  @Column(name = "itemPrice")
  var price: Int = price
    private set
}
