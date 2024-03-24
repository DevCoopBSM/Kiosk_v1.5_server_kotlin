package bsm.kiosk.kiosk_v2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class KioskV2Application

fun main(args: Array<String>) {
  runApplication<KioskV2Application>(*args)
}
