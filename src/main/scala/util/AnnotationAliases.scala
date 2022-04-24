package util

import scala.annotation.meta.field
import org.optaplanner.core.api.domain.solution
import org.optaplanner.core.api.domain.valuerange
import org.optaplanner.core.api.domain.entity
import org.optaplanner.core.api.domain.lookup
import org.optaplanner.core.api.domain.variable

object AnnotationAliases {
  type ValueRangeProvider = valuerange.ValueRangeProvider @field
  type ProblemFactCollectionProperty = solution.ProblemFactCollectionProperty @field
  type PlanningEntityCollectionProperty = solution.PlanningEntityCollectionProperty @field
  type PlanningScore = solution.PlanningScore @field
  type PlanningSolution = solution.PlanningSolution
  type PlanningVariable = variable.PlanningVariable @field
  type PlanningId = lookup.PlanningId @field
  type PlanningEntity = entity.PlanningEntity
}
