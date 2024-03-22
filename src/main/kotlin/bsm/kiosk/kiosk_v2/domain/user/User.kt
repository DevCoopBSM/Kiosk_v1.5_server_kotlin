package bsm.kiosk.kiosk_v2.domain.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import org.antlr.v4.runtime.Token

@Entity
class User private constructor(
  @Id val studentNumber: Int,
  codeNumber: String,
  studentName: String,
  email: String,
  password: String,
  isAdmin: Short,
  isCoop: Short,
  type: String,
  pointStatus: String,
  accToken: String,
  refToken: String,
  pin: String
){
  var codeNumber: String = codeNumber
    protected set
  var studentName: String = studentName
    protected set
  var email: String = email
    protected set
  var password: String = password
    protected set
  var point: Int = 0
    protected set
  var isAdmin: Short = isAdmin
    protected set
  var isCoop: Short = isCoop
    protected set
  var type: String = type
    protected set
  var pointStatus: String  = pointStatus
    protected set
  var accToken: String = accToken
    protected set
  var refToken: String = refToken
    protected set
  var pin: String = pin
    protected set
}
