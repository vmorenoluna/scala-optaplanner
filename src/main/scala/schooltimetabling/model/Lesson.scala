package schooltimetabling.model

import org.optaplanner.core.api.domain.entity.PlanningEntity
import org.optaplanner.core.api.domain.lookup.PlanningId
import org.optaplanner.core.api.domain.variable.PlanningVariable

import scala.beans.BeanProperty

@PlanningEntity
case class Lesson(
    @PlanningId
    @BeanProperty
    id: Long,
    @BeanProperty
    subject: String,
    @BeanProperty
    teacher: String,
    @BeanProperty
    studentGroup: String,
    @PlanningVariable
    @BeanProperty
    var timeslot: Timeslot,
    @PlanningVariable
    @BeanProperty
    var room: Room
) {

  override def toString: String =
    s"$subject (id)"

}
