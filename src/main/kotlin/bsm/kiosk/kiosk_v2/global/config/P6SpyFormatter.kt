package bsm.kiosk.kiosk_v2.global.config

import com.p6spy.engine.common.ConnectionInformation
import com.p6spy.engine.event.JdbcEventListener
import com.p6spy.engine.spy.P6SpyOptions
import com.p6spy.engine.spy.appender.MessageFormattingStrategy
import org.hibernate.engine.jdbc.internal.FormatStyle
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.sql.SQLException

@Component
class P6SpyFormatter : JdbcEventListener(), MessageFormattingStrategy {

  override fun onAfterGetConnection(connectionInformation: ConnectionInformation?, e: SQLException?) {
    P6SpyOptions.getActiveInstance().setLogMessageFormat(javaClass.name)
  }

  override fun formatMessage(
    connectionId: Int,
    now: String?,
    elapsed: Long,
    category: String?,
    prepared: String?,
    sql: String?,
    url: String?
  ): String {
    val sb = StringBuilder()
    sb.append("\n").append(category).append(" ").append(elapsed).append("ms").append("\n")
    if (StringUtils.hasText(sql)) {
      sb.append(highlight(format(sql!!)))
    }
    return sb.toString()
  }

  private fun format(sql: String): String {
    if (isDDL(sql)) {
      return FormatStyle.DDL.getFormatter().format(sql)
    }
    if (!isBasic(sql)) {
      return sql
    }

    if (sql.contains("*/")) {
      val endIndex = sql.indexOf("*/") + 2

      val jpqlPart = sql.substring(0, endIndex)
      val sqlPart = sql.substring(endIndex)
      val jpqlFormat = FormatStyle.BASIC.getFormatter().format(jpqlPart)
      val sqlFormat = FormatStyle.BASIC.getFormatter().format(sqlPart)

      val sb = StringBuilder()
      sb.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<JPQL")
        .append(jpqlFormat)
        .append("\n------------------------------------")
        .append(sqlFormat)
        .append("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SQL\n")

      return sb.toString()
    }
    return FormatStyle.BASIC.getFormatter().format(sql)
  }

  private fun highlight(sql: String): String {
    return FormatStyle.HIGHLIGHT.getFormatter().format(sql)
  }

  private fun isDDL(sql: String): Boolean {
    return sql.startsWith("create") || sql.startsWith("alter") || sql.startsWith("comment")
  }

  private fun isBasic(sql: String): Boolean {
    return sql.startsWith("select") || sql.startsWith("insert") || sql.startsWith("update") || sql.startsWith("delete")
      || sql.startsWith("/* select") || sql.startsWith("/* insert") || sql.startsWith("/* update") || sql.startsWith("/* delete")
  }
}
