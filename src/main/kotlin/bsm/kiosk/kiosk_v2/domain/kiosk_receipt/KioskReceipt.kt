package bsm.kiosk.kiosk_v2.domain.kiosk_receipt

import bsm.kiosk.kiosk_v2.domain.item.Item
import bsm.kiosk.kiosk_v2.domain.kiosk_receipt.types.SaleType
import bsm.kiosk.kiosk_v2.domain.user.User
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class KioskReceipt private constructor(
  // 팔린 금액
  var dcmSaleAmt: Int,
  // 팔렸으면 Y, 아니면 N
  @Enumerated(EnumType.STRING) var saleYn: SaleType,
  // User 아이디(영수증 번호)
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "studentNumber") var userId: User,
  var saleQty: Int,
  var date: LocalDate,
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "number")
  val id: Long = 0L

  @OneToMany(mappedBy = "receipt", cascade = [CascadeType.ALL], orphanRemoval = true)
  var items: MutableList<Item> = mutableListOf()
    private set
  fun addItems(item: Item) {
    item.receipt = this
    this.items.add(item)
  }
}
