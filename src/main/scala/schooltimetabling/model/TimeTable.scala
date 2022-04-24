package schooltimetabling.model

import org.optaplanner.core.api.domain.solution.{PlanningEntityCollectionProperty, PlanningScore, PlanningSolution, ProblemFactCollectionProperty}
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

import java.util.{List => JList}
import scala.annotation.meta.field
import scala.beans.BeanProperty

@PlanningSolution
case class TimeTable(
    @(ValueRangeProvider @field)(id = "timeslotRange")
    @(ProblemFactCollectionProperty @field)
    @BeanProperty
    timeslotList: JList[Timeslot],
    @(ValueRangeProvider @field)(id = "roomRange")
    @(ProblemFactCollectionProperty @field)
    @BeanProperty
    roomList: JList[Room],
    @(PlanningEntityCollectionProperty @field)
    @BeanProperty
    var lessonList: JList[Lesson],
    @(PlanningScore @field)
    @BeanProperty
    var score: HardSoftScore = null
) {

  def this()= {
    this(null, null, null, null)
  }

}
