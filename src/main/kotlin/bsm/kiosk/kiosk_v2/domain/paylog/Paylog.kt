package bsm.kiosk.kiosk_v2.domain.paylog

import bsm.kiosk.kiosk_v2.domain.user.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Paylog private constructor(
  codeNumber: String,
  date: LocalDateTime,
  type: Short,
  innerPoint: Int,
  chargerId: String,
  verifyKey: String,
  studentName: User
){
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pay_num", nullable = false)
  val payNum: Long = 0L
  var codeNumber: String = codeNumber
    private set
  var date: LocalDateTime = date
    private set
  var type: Short = type
    private set
  var innerPoint: Int = innerPoint
    private set
  var chargerId: String = chargerId
    private set
  var verifyKey: String = verifyKey
    private set
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "studentNumber")
  var studentName: User = studentName
}
