package bsm.kiosk.kiosk_v2.domain.kiosk_receipt

import bsm.kiosk.kiosk_v2.domain.item.Item
import bsm.kiosk.kiosk_v2.domain.user.User
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class KioskReceipt private constructor(
  dcmSaleAmt: Int,
  itemId: List<Item>,
  saleYn: String,
  userId: User,
  itemName: Item,
  saleQty: Int,
  date: LocalDate
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "number")
  val id: Long = 0L
  var dcmSaleAmt: Int = dcmSaleAmt // 팔린 금액
    private set
  @OneToMany(
    mappedBy = "id",
    cascade = [CascadeType.ALL],
    orphanRemoval = true
  )
  var itemId: List<Item> = itemId // Item 아이디
    private set
  var saleYn: String = saleYn // 팔렸으면 Y, 아니면 N
    private set
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "studentNumber")
  var userId: User = userId // User 아이디(영수증 번호)
    private set
  @ManyToOne
  @JoinColumn(name = "itemId")
  var itemName: Item = itemName
    private set
  var saleQty: Int = saleQty
    private set
  var date: LocalDate = date
    private set
}