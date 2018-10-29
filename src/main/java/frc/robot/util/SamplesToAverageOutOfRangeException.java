package frc.robot.util;

public class SamplesToAverageOutOfRangeException extends RuntimeException {
    private int samplesToAverage;

    public SamplesToAverageOutOfRangeException(int samplesToAverage) {
        this.samplesToAverage = samplesToAverage;
    }

    public int getSamplesToAverage() {
        return samplesToAverage;
    }
}