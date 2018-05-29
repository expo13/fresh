package com.expotek.confidencetreev1;

public class ConfidencePairing {

	private int count;
	private int confidence;

	public ConfidencePairing(){}

	public void countUp(){
		count++;
	}

	public void countDown(){
		count--;
	}

	public int confidenceUp(){
		confidence++;
		return confidence;
	}

	public int confidenceDown(){
		confidence--;
		return confidence;
	}

	public void setConfidence(int confidence){
		this.confidence=confidence;
	}

	public int getConfidence(){
		return this.confidence;
	}
}
