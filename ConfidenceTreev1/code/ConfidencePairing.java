package com.expotek.confidencetreev1;

public class ConfidencePairing {

	private int count;
	private int confidence;

	public ConfidencePairing(){}

	protected void countUp(){
		count++;
	}

	protected void countDown(){
		count--;
	}

	protected int confidenceUp(){
		confidence++;
		return confidence;
	}

	protected int confidenceDown(){
		confidence--;
		return confidence;
	}

	protected void setConfidence(int confidence){
		this.confidence=confidence;
	}

	public int getConfidence(){
		return this.confidence;
	}
}
