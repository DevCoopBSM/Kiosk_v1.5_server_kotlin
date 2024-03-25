package bsm.kiosk.kiosk_v2.domain.inventory

import bsm.kiosk.kiosk_v2.domain.item.Item
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Inventory private constructor(
  quantity: Int,
  lastUpdated: LocalDateTime
) {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "inventory_id")
  val id: Long = 0L

  var quantity: Int = quantity
    private set
  var lastUpdated: LocalDateTime = lastUpdated
    private set

  @OneToMany(
    mappedBy = "id",
    cascade = [CascadeType.ALL],
    orphanRemoval = true
  )
  var items: MutableList<Item> = mutableListOf()
    private set

  fun addItems(item: Item) {
    item.inventory = this
    this.items.add(item)
  }
}
