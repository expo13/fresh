

public class ConfidencePairing {

	private int count;
	private int confidence;

	public ConfidencePairing(){}

	public void countUp(){
		count++;
	}

	public void countDown(){P
		count--;
	}

	public int confidenceUp(){
		confidence++;
	}

	public int confidenceDown(){
		confidence--;
	}

	public void setConfidence(int confidence){
		this.confidence=confidence;
	}

	public int getConfidence(){
		return this.confidence;
	}
}
