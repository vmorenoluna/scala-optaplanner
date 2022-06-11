package nqueens.optional.solver.move

import scala.jdk.CollectionConverters._
import java.util.{Objects, List => JList}
import nqueens.model.{NQueens, Queen, Row}
import org.optaplanner.core.api.score.director.ScoreDirector
import org.optaplanner.core.impl.heuristic.move.AbstractMove

case class RowChangeMove(queen: Queen, toRow: Row) extends AbstractMove[NQueens] {

  override def isMoveDoable(scoreDirector: ScoreDirector[NQueens]): Boolean =
    queen.getRow() != toRow

  override def createUndoMove(scoreDirector: ScoreDirector[NQueens]): RowChangeMove =
    new RowChangeMove(queen, queen.getRow())

  override def doMoveOnGenuineVariables(scoreDirector: ScoreDirector[NQueens]): Unit = {
    scoreDirector.beforeVariableChanged(queen, "row")
    queen.setRow(toRow)
    scoreDirector.afterVariableChanged(queen, "row")
  }

  override def rebase(destinationScoreDirector: ScoreDirector[NQueens]): RowChangeMove =
    RowChangeMove(
      destinationScoreDirector.lookUpWorkingObject(queen),
      destinationScoreDirector.lookUpWorkingObject(toRow)
    )

  override def getPlanningEntities(): JList[Queen] =
    List(queen).asJava

  override def getPlanningValues(): JList[Row] =
    List(toRow).asJava

  override def equals(o: Any): Boolean = {
    if (this == o) {
      true
    }
    else if (o == null || getClass != o.getClass) {
      false
    }
    else {
      val other: RowChangeMove = o.asInstanceOf[RowChangeMove]
      queen.equals(other.queen) && toRow.equals(other.toRow)
    }
  }

  override def hashCode(): Int =
    Objects.hash(queen, toRow)

  override def toString(): String =
    s"$queen { ${queen.getRow()} -> $toRow }"

}
