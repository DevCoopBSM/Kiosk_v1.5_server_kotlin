package bsm.kiosk.kiosk_v2.domain.user

import bsm.kiosk.kiosk_v2.domain.kiosk_receipt.KioskReceipt
import bsm.kiosk.kiosk_v2.domain.paylog.Paylog
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.Email

@Entity
@Table(name = "users")
class User private constructor(
  @Id val studentNumber: Int,
  codeNumber: String,
  studentName: String,
  @Email(message = "이메일 형식을 확인해주세요") email: String,
  password: String,
  isAdmin: Short,
  isCoop: Short,
  type: String,
  pointStatus: String,
  accToken: String,
  refToken: String,
  pin: String,
){
  var codeNumber: String = codeNumber
    private set
  var studentName: String = studentName
    private set
  var email: String = email
    private set
  var password: String = password
    private set
  var point: Int = 0
    private set
  var isAdmin: Short = isAdmin
    private set
  var isCoop: Short = isCoop
    private set
  var type: String = type
    private set
  var pointStatus: String  = pointStatus
    private set
  var accToken: String = accToken
    private set
  var refToken: String = refToken
    private set
  var pin: String = pin
    private set

  @OneToMany(
    mappedBy = "studentName",
    cascade = [CascadeType.ALL],
    orphanRemoval = true
  )
  var payLog: MutableList<Paylog> = mutableListOf()
    private set
  fun addPaylog(paylog: Paylog) {
    paylog.studentName = this
    this.payLog.add(paylog)
  }


  @OneToMany(
    mappedBy = "id",
    cascade = [CascadeType.ALL],
    orphanRemoval = true
  )
  var kioskReceipt: MutableList<KioskReceipt> = mutableListOf()
    private set
  fun addKioskReceipt(kioskReceipt: KioskReceipt) {
    kioskReceipt.userId = this
    this.kioskReceipt.add(kioskReceipt)
  }
}
