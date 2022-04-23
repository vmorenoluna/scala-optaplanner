package schooltimetabling.model

import org.optaplanner.core.api.domain.solution.{PlanningEntityCollectionProperty, PlanningScore, PlanningSolution, ProblemFactCollectionProperty}
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore

import scala.beans.BeanProperty

@PlanningSolution
case class TimeTable(
    @ValueRangeProvider(id = "timeslotRange")
    @ProblemFactCollectionProperty
    @BeanProperty
    timeslotList: List[Timeslot],
    @ValueRangeProvider(id = "roomRange")
    @ProblemFactCollectionProperty
    @BeanProperty
    roomList: List[Room],
    @PlanningEntityCollectionProperty
    @BeanProperty
    var lessonList: List[Lesson],
    @PlanningScore
    @BeanProperty
    var score: HardSoftScore = null
) {

//  def this() {
//    this()
//  }

}
