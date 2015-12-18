package fr.iutvalence.info.dut.m3105.pattern.state;

public class TrafficSignalNotifyObserver implements TrafficSignalNotifyInterface {
	
	@Override
	public void notifySignalState(TrafficSignalStateName state){
		System.out.println("Traffic signal state is "+state);
	}

	@Override
	public void notifyButtonPressed() {
		System.out.println("button pressed!");
	}

	@Override
	public void notifySecondEllapsed(int durationInSeconds) {
		System.out.println(durationInSeconds);
	}
	
	
	
}
