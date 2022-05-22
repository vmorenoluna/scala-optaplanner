package nqueens.persistence

import nqueens.model.{Column, NQueens, Queen, Row}
import scala.jdk.CollectionConverters._
import java.util.{List => JList}

class NQueensGenerator extends App {

  private def getFlooredPossibleSolutionSize(possibleSolutionSize: BigInt): String = {
    if (possibleSolutionSize < BigInt(1000)) {
      return possibleSolutionSize.toString()
    }
    val possibleSolutionSizeBigDecimal: BigDecimal = BigDecimal(possibleSolutionSize)
    val decimalDigits: Int = if (possibleSolutionSizeBigDecimal.scale < 0)
      possibleSolutionSizeBigDecimal.precision - possibleSolutionSizeBigDecimal.scale
    else
      possibleSolutionSizeBigDecimal.precision
    "10^" + decimalDigits
  }

  def createNQueens(n: Int): NQueens = {
    val nQueens: NQueens = NQueens(
      n,
      createColumnList(nQueens),
      createRowList(nQueens),
      createQueenList(nQueens)
    )
    val possibleSolutionSize: BigInt = BigInt(nQueens.getN()).pow(nQueens.getN())
    println(s"NQueens $n has ${nQueens.getN} queens with a search space of ${getFlooredPossibleSolutionSize(possibleSolutionSize)}.")
    nQueens
  }

  private def createColumnList(nQueens: NQueens): JList[Column] = {
    for {
      i <- 0 to nQueens.n
    } yield Column(i, i)
  }.asJava

  private def createRowList(nQueens: NQueens): JList[Row] = {
    for {
      i <- 0 to nQueens.n
    } yield Row(i, i)
  }.asJava

  private def createQueenList(nQueens: NQueens): JList[Queen] = {
    for {
      id <- 0 to nQueens.n
      column <- nQueens.columnList.asScala
    } yield Queen(id, column)
  }.asJava

}
