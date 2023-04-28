package org.tandem.test.model;

public class Result {
    private final ResultStatus status;
    private final int acquiredPoints;

    public Result(ResultStatus status, int acquiredPoints) {
        this.status = status;
        this.acquiredPoints = acquiredPoints;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public int getAcquiredPoints() {
        return acquiredPoints;
    }
}
