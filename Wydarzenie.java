
//teesstt
public class Wydarzenie {
	private String dataStart,dataStop;;
	private String timeStart,timeStop;
	private String description;
	private String title;


	public Wydarzenie(String title,String dataStartRef,String dataStopRef,String timeStart,String timeStop,String description)
	{
		this.dataStart=dataStartRef;
		this.dataStop=dataStopRef;
		
		this.timeStart=timeStart;
		this.timeStop=timeStop;
		
		this.title=title;
		this.description=description;
		
	}

	public String getDataStart() {
		return  dataStart;
	}

	public void setDataStart(String dataStart) {
		this.dataStart = dataStart;
	}

	public String getDataStop() {
		return  dataStop;
	}

	public void setDataStop(String dataStop) {
		this.dataStop = dataStop;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeStop() {
		return timeStop;
	}

	public void setTimeStop(String timeStop) {
		this.timeStop = timeStop;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return dataStart + "  " + timeStart + "     " + dataStop
				+ "  " + timeStop + "   "+title;
	}
	

}
