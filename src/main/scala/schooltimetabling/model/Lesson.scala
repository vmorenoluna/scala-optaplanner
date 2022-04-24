package schooltimetabling.model

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.lookup.PlanningId
import org.optaplanner.core.api.domain.variable.PlanningVariable
import java.lang.{Long => JLong}
import scala.annotation.meta.field
import scala.beans.BeanProperty

@PlanningEntity
case class Lesson(
    @(PlanningId @field)
    @BeanProperty
    id: JLong,
    @BeanProperty
    subject: String,
    @BeanProperty
    teacher: String,
    @BeanProperty
    studentGroup: String,
    @(PlanningVariable @field)(valueRangeProviderRefs = Array("timeslotRange"))
    @BeanProperty
    var timeslot: Timeslot = null,
    @(PlanningVariable @field)(valueRangeProviderRefs = Array("roomRange"))
    @BeanProperty
    var room: Room = null
) {

  def this()= {
    this(null, null, null, null, null, null)
  }

  override def toString: String =
    s"$subject (id)"

}
