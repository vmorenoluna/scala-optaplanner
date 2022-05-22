package nqueens.optional

import nqueens.model.{NQueens, Queen}
import org.optaplanner.core.api.domain.solution.cloner.SolutionCloner
import scala.jdk.CollectionConverters._

class NQueensSolutionCloner extends SolutionCloner[NQueens] {

  override def cloneSolution(original: NQueens): NQueens = {
    val queenList = original.getQueenList().asScala
    val clonedQueenList = {
      for {
        queen <- queenList
      } yield Queen(
        queen.id,
        queen.column,
        queen.row
      )
    }.asJava

    NQueens(
      original.n,
      original.columnList,
      original.rowList,
      clonedQueenList,
      original.score
    )
  }

}
