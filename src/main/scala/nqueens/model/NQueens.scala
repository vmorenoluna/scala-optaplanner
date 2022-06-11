package nqueens.model

import org.optaplanner.core.api.score.buildin.simple.SimpleScore
import util.AnnotationAliases._
import java.util.{List => JList}
import scala.beans.BeanProperty

@PlanningSolution
case class NQueens(
    @BeanProperty
    n: Int,
    @ProblemFactCollectionProperty
    @BeanProperty
    columnList: JList[Column],
    @ValueRangeProvider(id = "rowRange")
    @ProblemFactCollectionProperty
    @BeanProperty
    rowList: JList[Row],
    @PlanningEntityCollectionProperty
    @BeanProperty
    queenList: JList[Queen],
    @PlanningScore
    @BeanProperty
    score: SimpleScore = null
) {

  def this()= {
    this(0, null, null, null, null)
  }

}
