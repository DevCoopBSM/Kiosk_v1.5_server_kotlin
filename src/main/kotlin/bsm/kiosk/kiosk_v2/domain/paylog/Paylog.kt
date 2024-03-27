package bsm.kiosk.kiosk_v2.domain.paylog

import bsm.kiosk.kiosk_v2.domain.user.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Paylog(
  var codeNumber: String,
  var date: LocalDateTime,
  var type: Short,
  var innerPoint: Int,
  chargerId: ChargeType,
  verifyKey: String,
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "studentNumber") var studentName: User
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pay_num", nullable = false)
  val payNum: Long = 0L

  @Enumerated(EnumType.STRING)
  var chargerId: ChargeType = chargerId
    private set
  var verifyKey: String = verifyKey
    private set
}
