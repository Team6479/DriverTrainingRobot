package frc.robot.util;

import edu.wpi.first.wpilibj.Encoder;

public class EncoderProfile {
    private double distancePerPulse;
    private double maxPeriod;
    private double minRate;
    private int samplesToAverage;

    public EncoderProfile() {
        this(Double.NaN, Double.NaN, Double.NaN, -1);
    }

    public EncoderProfile(double distancePerPulse) {
        this(distancePerPulse, Double.NaN, Double.NaN, -1);
    }
    
    public EncoderProfile(double distancePerPulse, double maxPeriod) {
        this(distancePerPulse, Double.NaN, Double.NaN, -1);
    }

    public EncoderProfile(double distancePerPulse, double maxPeriod, double minRate, int samplesToAverage) {
        this.distancePerPulse = distancePerPulse;
        this.maxPeriod = maxPeriod;
        this.minRate = minRate;
        this.samplesToAverage = samplesToAverage;
    }
    
    /**
     * 
     * @param encoder
     */
    /*public static EncoderProfile createEncoderProfile(Encoder encoder) {
        return new EncoderProfile(encoder.getDistancePerPulse(), maxPeriod, minRate, encoder.getSamplesToAverage());
    }*/

    /**
     * 
     * @param encoder
     */
    public void applyEncoderProfile(Encoder encoder) {
        if(!Double.isNaN(distancePerPulse)) {
            encoder.setDistancePerPulse(distancePerPulse);
        }

        if(!Double.isNaN(maxPeriod)) {
            encoder.setMaxPeriod(maxPeriod);
        }

        if(!Double.isNaN(minRate)) {
            encoder.setMinRate(minRate);
        }
        
        if(samplesToAverage >= 1 && samplesToAverage <= 127) {
            encoder.setSamplesToAverage(samplesToAverage);
        }
        else {
            throw new SamplesToAverageOutOfRangeException(samplesToAverage);
        }
    }

    public void setDistancePerPulse(double distancePerPulse) {
        this.distancePerPulse = distancePerPulse;
    }

    public double getDistancePerPulse() {
        return distancePerPulse;
    }

    public void setMaxPeriod(double maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    public double getMaxPeriod() {
        return maxPeriod;
    }

    public void setMinRate(double minRate) {
        this.minRate = minRate;
    }

    public double getMinRate() {
        return minRate;
    }

    public void setSamplesToAverage(int samplesToAverage) {
        this.samplesToAverage = samplesToAverage;
    }

    public int getSamplesToAverage() {
        return samplesToAverage;
    }
}