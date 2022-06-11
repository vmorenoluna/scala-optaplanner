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
    val columns = createColumnList(n)
    val nQueens: NQueens = NQueens(
      n,
      columns,
      createRowList(n),
      createQueenList(n, columns)
    )
    val possibleSolutionSize: BigInt = BigInt(nQueens.getN()).pow(nQueens.getN())
    println(s"NQueens $n has ${nQueens.getN} queens with a search space of ${getFlooredPossibleSolutionSize(possibleSolutionSize)}.")
    nQueens
  }

  private def createColumnList(n: Int): JList[Column] = {
    for {
      i <- 0 to n
    } yield Column(i, i)
  }.asJava

  private def createRowList(n: Int): JList[Row] = {
    for {
      i <- 0 to n
    } yield Row(i, i)
  }.asJava

  private def createQueenList(n: Int, columns: JList[Column]): JList[Queen] = {
    for {
      id <- 0 to n
      column <- columns.asScala
    } yield Queen(id, column)
  }.asJava

}
