package solver;

import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@ConstraintConfiguration
public class MitoConstraintConfiguration {

    // HARD CONSTRAINTS //
    // at least 2 people must be assigned to a shift
    // (no need to specify max constraint, as handled by number of ShiftAssignments per shift instantiated in solution)
    @ConstraintWeight("Floor capacity conflict")
    private HardSoftScore mFloorMinCapacityConflict = HardSoftScore.ofHard(10);

    // the room capacity must not be exceeded
    @ConstraintWeight("Room capacity conflict")
    private HardSoftScore mRoomCapacityConflict = HardSoftScore.ofHard(10);

    // tasks should only be assigned once
    @ConstraintWeight("Do not repeat tasks")
    private HardSoftScore mTaskRepeatConflict = HardSoftScore.ofHard(100);

    // the person must be available for a scheduled task
    @ConstraintWeight("Person conflict")
    private HardSoftScore mPersonConflict = HardSoftScore.ofHard(10);

    // the equipment must be available for a scheduled task
    @ConstraintWeight("Equipment conflict")
    private HardSoftScore mEquipmentConflict = HardSoftScore.ofHard(10);


    // SOFT CONSTRAINTS //
    // due dates should be met
    @ConstraintWeight("Due date conflict")
    private HardSoftScore mDueDateconflict = HardSoftScore.ofSoft(25);

    // people should not have more than their limit of assigned shifts per week
    @ConstraintWeight("Shift limit conflict")
    private HardSoftScore mShiftLimitConflict = HardSoftScore.ofSoft(30);

    // shift assignments should be fairly split between PI groups
    // TODO look at 5.4.10 for implementing this - squared workload implementation
    @ConstraintWeight("PI group unfairness")
    private HardSoftScore mPiGroupFairness = HardSoftScore.ofSoft(10);

    // higher priority tasks should go first
    @ConstraintWeight("High priority work done")
    private HardSoftScore mPriorityWorkDone = HardSoftScore.ofSoft(20);

}
