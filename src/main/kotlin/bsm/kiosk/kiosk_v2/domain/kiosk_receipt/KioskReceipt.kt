package bsm.kiosk.kiosk_v2.domain.kiosk_receipt

import bsm.kiosk.kiosk_v2.domain.item.Item
import bsm.kiosk.kiosk_v2.domain.user.User
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class KioskReceipt private constructor(
  dcmSaleAmt: Int,
  saleYn: String,
  userId: User,
  saleQty: Int,
  date: LocalDate,
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "number")
  val id: Long = 0L

  var dcmSaleAmt: Int = dcmSaleAmt // 팔린 금액
    private set

  var saleYn: String = saleYn // 팔렸으면 Y, 아니면 N
    private set

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "studentNumber")
  var userId: User = userId // User 아이디(영수증 번호)

  var saleQty: Int = saleQty
    private set

  var date: LocalDate = date
    private set

  @OneToMany(mappedBy = "receipt", cascade = [CascadeType.ALL], orphanRemoval = true)
  var items: MutableList<Item> = mutableListOf()
    private set

  fun addItems(item: Item) {
    item.receipt = this
    this.items.add(item)
  }
}
