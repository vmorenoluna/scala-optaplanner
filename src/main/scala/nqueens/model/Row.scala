package nqueens.model

import util.AnnotationAliases.PlanningId
import scala.beans.BeanProperty
import java.lang.{Long => JLong}

case class Row(
    @PlanningId
    @BeanProperty
    id: JLong,
    @BeanProperty
    index: Int
) {

  override def toString: String =
    s"Row-$index"

}
