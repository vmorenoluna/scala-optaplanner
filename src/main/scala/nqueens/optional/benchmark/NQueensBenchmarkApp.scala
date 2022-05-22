package nqueens.optional.benchmark

import common.app.CommonBenchmarkApp
import common.app.CommonBenchmarkApp.ArgOption

class NQueensBenchmarkApp extends CommonBenchmarkApp (
  new ArgOption("default", "nqueens/optional/benchmark/nqueensBenchmarkConfig.xml"),
  new ArgOption("stepLimit", "nqueens/optional/benchmark/nqueensStepLimitBenchmarkConfig.xml"),
  new ArgOption("scoreDirector", "nqueens/optional/benchmark/nqueensScoreDirectorBenchmarkConfig.xml")
) with App {

  buildAndBenchmark(args)

}
