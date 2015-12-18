package fr.iutvalence.info.dut.m3105.pattern.state;

import java.util.List;


public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalUserInterface
{
	private TrafficSignalState state;
	private List<TrafficSignalNotifyInterface> observers;
	
	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{
		System.out.println("Traffic signal state is "+state.getName());
		this.state = state;		
	}

	@Override
	public void pressButton()
	{
		this.state.buttonPressed();
	}
	
	public void run()
	{
		this.setTrafficSignalState(new TrafficSignalGreenState(this));
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				this.state.secondEllapsed();
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}

	public void registerObserver(TrafficSignalNotifyObserver trafficSignalNotifyObserver) {
		observers.add(trafficSignalNotifyObserver);
	}
	
	public void unregisterObserver(TrafficSignalNotifyObserver trafficSignalNotifyObserver) {
		observers.remove(trafficSignalNotifyObserver);
	}
	
	private void notifyStateChange(TrafficSignalStateName name) {
		for (TrafficSignalNotifyInterface observer : observers) {
			observer.notifySignalState(name);
		}
	}
	
}
