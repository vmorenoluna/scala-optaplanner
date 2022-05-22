# scala-optaplanner
A playground to experiment with Scala and Optaplanner

## Notes

Planning entity hashCode() implementations must remain constant. Therefore entity hashCode() must not depend on any 
planning variables. Pay special attention when using data structures with auto-generated hashCode() as entities, such 
as Java records or Kotlin data classes.

If historic data needs to be considered too, then create problem fact to hold the total of the historic assignments 
up to, but not including, the planning window (so that it does not change when a planning entity changes) and let the 
score constraints take it into account.

https://www.optaplanner.org/docs/optaplanner/latest/planner-configuration/planner-configuration.html#planningEntityDifficulty

https://www.optaplanner.org/docs/optaplanner/latest/planner-configuration/planner-configuration.html#valueRangeFactory

https://www.optaplanner.org/docs/optaplanner/latest/planner-configuration/planner-configuration.html#combineValueRangeProviders

https://www.optaplanner.org/docs/optaplanner/latest/planner-configuration/planner-configuration.html#cachedProblemFact

https://www.optaplanner.org/docs/optaplanner/latest/planner-configuration/planner-configuration.html#cloningASolution

It is recommended to write a test case that does a short run of your planning problem with the FAST_ASSERT mode on. (solver config)
https://www.optaplanner.org/docs/optaplanner/latest/planner-configuration/planner-configuration.html#environmentModeProduction

https://www.optaplanner.org/docs/optaplanner/latest/planner-configuration/planner-configuration.html#solverManagerSolveAndListen

Avoid the use of float or double in score calculation. Use BigDecimal or scaled long instead.
Floating point numbers (float and double) cannot represent a decimal number correctly. For example: a double cannot hold the value 0.05 correctly. 
Instead, it holds the nearest representable value. Arithmetic (including addition and subtraction) with floating point numbers, especially for planning problems, 
leads to incorrect decisions.
BigDecimal arithmetic is considerably slower than int, long or double arithmetic. In experiments we have seen the score calculation take five times longer.
Therefore, in many cases, it can be worthwhile to multiply all numbers for a single score weight by a plural of ten, so the score weight fits in a scaled int or long. 
For example, if we multiply all weights by 1000, a fuelCost of 0.07 becomes a fuelCostMillis of 70 and no longer uses a decimal score weight.

The InitializingScoreTrend specifies how the Score will change as more and more variables are initialized (while the already initialized variables do not change). 
Some optimization algorithms (such Construction Heuristics and Exhaustive Search) run faster if they have such information.
https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#initializingScoreTrend

https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#invalidScoreDetection
https://www.optaplanner.org/docs/optaplanner/latest/constraint-streams/constraint-streams.html#constraintStreamsTesting

https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#scoreCalculationSpeed

https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#incrementalScoreCalculation

If some parts of a constraint can be calculated once, when the Solver starts, and never change during solving, then turn them into cached problem facts.
https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#avoidCallingRemoteServicesDuringScoreCalculation

https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#buildInHardConstraint
https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#otherScoreCalculationPerformanceTricks
https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#scoreTrap

https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#constraintConfiguration

https://www.optaplanner.org/docs/optaplanner/latest/score-calculation/score-calculation.html#explainingTheScore










