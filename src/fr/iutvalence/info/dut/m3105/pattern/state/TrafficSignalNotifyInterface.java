package fr.iutvalence.info.dut.m3105.pattern.state;

public interface TrafficSignalNotifyInterface {
	
	void notifySignalState(TrafficSignalStateName state);
	
	void notifyButtonPressed();
	
	void notifySecondEllapsed(int durationInSeconds);
	
}
