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
  var codeNumber: String,
  var studentName: String,
  @Email(message = "이메일 형식을 확인해주세요") var email: String,
  var password: String,
  var point: Int,
  var isAdmin: Short?,
  var isCoop: Short?,
  var type: String?,
  var pointStatus: String?,
  var accToken: String?,
  var refToken: String?,
  var pin: String,
){
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
