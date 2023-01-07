package nqueens.score

import nqueens.model.Queen
import org.optaplanner.core.api.score.buildin.simple.SimpleScore
import org.optaplanner.core.api.score.stream.Joiners.equal
import org.optaplanner.core.api.score.stream.{Constraint, ConstraintFactory, ConstraintProvider}

class NQueensConstraintProvider extends ConstraintProvider {

  @Override
  def defineConstraints(factory: ConstraintFactory): Array[Constraint] =
    Array[Constraint](
      horizontalConflict(factory),
      ascendingDiagonalConflict(factory),
      descendingDiagonalConflict(factory)
    )

  protected def horizontalConflict(factory: ConstraintFactory): Constraint =
    factory
      .forEachUniquePair(classOf[Queen], equal[Queen, Int](q => q.getRowIndex))
      .penalize("Horizontal conflict", SimpleScore.ONE);

  protected def ascendingDiagonalConflict(factory: ConstraintFactory): Constraint =
    factory
      .forEachUniquePair(classOf[Queen], equal[Queen, Int](q => q.getAscendingDiagonalIndex))
      .penalize("Ascending diagonal conflict", SimpleScore.ONE);

  protected def descendingDiagonalConflict(factory: ConstraintFactory): Constraint =
    factory
      .forEachUniquePair(classOf[Queen], equal[Queen, Int](q => q.getDescendingDiagonalIndex))
      .penalize("Descending diagonal conflict", SimpleScore.ONE);

}
