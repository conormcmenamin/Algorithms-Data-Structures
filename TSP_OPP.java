package Labs;

import java.util.Random;

public class TSP {

	public static double waitTimes[][] = new double[100][100];						//create an N X N matrix of waiting times to use as weight for graph
	
	public static double dp[][] = new double[9][100];
	
	public static void main(String args[]) {

		Random rd = new Random();
		Destination destinations[] = {new Destination(0,53.38195, -6.59192),		//Takeaway destination
				new Destination(60-12 ,53.3473,-6.55057),
				new Destination(60-12 ,53.37077,-6.48279),
				new Destination(60-12 ,53.35152,-6.54989),
				new Destination(60-12 ,53.37278,-6.59611),
				new Destination(60-13 ,53.40126,-6.6683),
				new Destination(60-14 ,53.34484,-6.54766),
				new Destination(60-15 ,53.34133,-6.51856),
				new Destination(60-15 ,53.34492,-6.5557),
				new Destination(60-16 ,53.29206,-6.67685),
				new Destination(60-16 ,53.36483,-6.51278),
				new Destination(60-16 ,53.33067,-6.54686),
				new Destination(60-16 ,53.36287,-6.52468),
				new Destination(60-17 ,53.37416,-6.49494),
				new Destination(60-17 ,53.39549,-6.67647),
				new Destination(60-18 ,53.33239,-6.55163),
				new Destination(60-18 ,53.34678,-6.53415),
				new Destination(60-18 ,53.36869,-6.48314),
				new Destination(60-19 ,53.37521,-6.6103),
				new Destination(60-20 ,53.33751,-6.53173),
				new Destination(60-21 ,53.37184,-6.50065),
				new Destination(60-21 ,53.36143,-6.51849),
				new Destination(60-21 ,53.37473,-6.59338),
				new Destination(60-22,53.34514,-6.53615),
				new Destination(60-22,53.36115,-6.48907),
				new Destination(60-23,53.39351,-6.5542),
				new Destination(60-23,53.33886,-6.55468),
				new Destination(60-25,53.36115,-6.48907),
				new Destination(60-26,53.37497,-6.4991),
				new Destination(60-27,53.37565,-6.60716),
				new Destination(60-27,53.3354, -6.55111),
				new Destination(60-28,53.36143,-6.51849),
				new Destination(60-28,53.36115,-6.48907),
				new Destination(60-28,53.39459,-6.66995),
				new Destination(60-29,53.37122,-6.586),
				new Destination(60-30,53.36656,-6.49183),
				new Destination(60-30,53.36141,-6.51834),
				new Destination(60-30,53.37323,-6.58859),
				new Destination(60-31,53.36292,-6.50203),
				new Destination(60-31,53.38122,-6.59226),
				new Destination(60-31,53.35098,-6.54915),
				new Destination(60-31,53.34312,-6.54747),
				new Destination(60-31,53.34197,-6.55492),
				new Destination(60-31,53.37954,-6.58793),
				new Destination(60-32,53.33835,-6.53984),
				new Destination(60-32,53.36976,-6.59828),
				new Destination(60-32,53.37811,-6.57952),
				new Destination(60-33,53.39847,-6.66787),
				new Destination(60-34,53.38579,-6.58673),
				new Destination(60-34,53.37626,-6.59308),
				new Destination(60-34,53.37336,-6.48219),
				new Destination(60-34,53.33032,-6.55311),
				new Destination(60-35,53.37201,-6.48517),
				new Destination(60-35,53.37416,-6.49731),
				new Destination(60-36,53.36164,-6.50526),
				new Destination(60-36,53.37043,-6.48193),
				new Destination(60-36,53.35372,-6.54564),
				new Destination(60-37,53.2908,-6.67746),
				new Destination(60-37,53.39792,-6.6711),
				new Destination(60-37,53.39315,-6.66909),
				new Destination(60-39,53.34439,-6.53841),
				new Destination(60-41,53.33591,-6.53566),
				new Destination(60-41,53.3632,-6.51178),
				new Destination(60-42,53.36833,-6.50589),
				new Destination(60-42,53.35298,-6.54921),
				new Destination(60-43,53.38122,-6.59226),
				new Destination(60-43,53.33605,-6.53414),
				new Destination(60-43,53.33324,-6.53978),
				new Destination(60-43,53.38039,-6.59368),
				new Destination(60-45,53.36883,-6.51468),
				new Destination(60-45,53.35401,-6.54603),
				new Destination(60-45,53.34745,-6.53401),
				new Destination(60-46,53.39839,-6.66767),
				new Destination(60-47,53.3473,-6.55057),
				new Destination(60-48,53.29128,-6.67836),
				new Destination(60-48,53.36158,-6.50533),
				new Destination(60-48,53.3727,-6.58757),
				new Destination(60-48,53.35321,-6.55412),
				new Destination(60-49,53.31159,-6.60538),
				new Destination(60-50,53.36455,-6.51435),
				new Destination(60-50,53.39999,-6.66807),
				new Destination(60-50,53.37414,-6.60028),
				new Destination(60-50,53.37402,-6.49363),
				new Destination(60-51,53.38983,-6.5951),
				new Destination(60-51,53.34033,-6.54596),
				new Destination(60-51,53.28973,-6.67445),
				new Destination(60-52,53.36518,-6.48913),
				new Destination(60-52,53.36873,-6.49619),
				new Destination(60-52,53.33256,-6.55056),
				new Destination(60-53,53.37565,-6.60701),
				new Destination(60-53,53.38895,-6.60579),
				new Destination(60-54,53.34648,-6.54552),
				new Destination(60-55,53.35202,-6.55099),
				new Destination(60-55,53.37247,-6.60044),
				new Destination(60-56,53.37449,-6.60005),
				new Destination(60-56,53.36559,-6.51914),
				new Destination(60-57,53.39648,-6.66612),
				new Destination(60-57,53.33239,-6.55163),
				new Destination(60-57,53.39512,-6.67084),
				new Destination(60-58,53.33835,-6.53984),
				new Destination(60-58,53.37538,-6.60707)};
		
		
		Route myRoute = new Route(destinations);
		
		Destination array[] = new Destination[3];
		
		double d=0;
		for( int i = 0; i<=myRoute.length-2;++i) {
			
			Destination current = myRoute.get(i);
			myRoute.updateFactors(current,i+1);
			
				myRoute.sort(i+1,myRoute.length-1);
			
			
			Destination next = myRoute.get(i+1);
		
			d = current.distanceFrom(next.latitude, next.longitude)/80.0;
			myRoute.appendTime(d);
			myRoute.updateWaitTime(d,i+1);
			
		}
		
			
			myRoute.displayRoute();
		
		
		
	}
	
	
	
}

class Destination{
	double longitude;
	double latitude;
	int id;
	static int counter = 0;
	
	double waitTime;
	double waitFactor;
	
	public Destination(double waitTime, double latitude, double longitude) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.waitTime =waitTime;;
		id=counter%101;
		counter++;
		
	}
	public void incWaitTimeBy(double d) {
		waitTime +=d;
	}
	
	public void setWaitFactor(Destination d) {
		if(waitTime==0) {
			waitFactor = Double.MIN_VALUE;
		}
		waitFactor = waitTime/(this.distanceFrom(d.latitude, d.longitude)/80.0);
	}
	
	
	public double distanceFrom(double latitude, double longitude) {
		double theDistance = (Math.sin(Math.toRadians(latitude)) *
	            Math.sin(Math.toRadians(this.latitude)) +
	            Math.cos(Math.toRadians(latitude)) *
	            Math.cos(Math.toRadians(this.latitude)) *
	            Math.cos(Math.toRadians(longitude - this.longitude)));

	    return new Double((Math.toDegrees(Math.acos(theDistance))) * 69.09*1.6093);
	}
	
}

class Route {
	Destination destinations[];
	int length;
	double totalTime;
	
	public Route(Destination destinations[]) {
		this.destinations=destinations;
		length = destinations.length;
	}
	
	public Route(int n) {
		this.destinations=new Destination[n];
		length=n;
	}
	
	
	public void sort(int left, int right) {
		if(right-left<=0) {
			return;
		}else {
			Destination pivot = destinations[right];
			int part = partitionIt(left,right,pivot);
			
			sort(left,part-1);
			sort(part+1, right);
			
		}
	}
	public void updateFactors(Destination d, int k) {
		for(int i = k; i<= destinations.length-1;++i) {
			destinations[i].setWaitFactor(d);
		}
	}
	public void updateWaitTime(double d, int g) {
		for(int i = g;i<=destinations.length-1;++i) {
			destinations[i].incWaitTimeBy(d);
		}
	}
	public void appendTime(double mins) {
		totalTime+=mins;
	}
	public Destination get(int i) {
		return destinations[i];
	}
	
	public int partitionIt(int left, int right, Destination pivot) {
		
		int leftPtr=left-1, rightPtr=right;
		
		while(true) {
			while( bigger(pivot,destinations[++leftPtr]) && leftPtr<right) {}
			while(rightPtr>0 && bigger(destinations[--rightPtr],pivot)) {}
			
			
			if(leftPtr>=rightPtr) {
				break;
			}else {
				swap(leftPtr,rightPtr);
			}
		}
		swap(leftPtr,right);
		return leftPtr;
	}
	
	public boolean bigger(Destination d1, Destination d2) {
		if( d1.waitFactor < d2.waitFactor) {
			return true;
		}else if(d1.waitFactor==d2.waitFactor) {
			return true;
		}else {
			return false;
		}
	}
	
	public void swap(int left, int right) {
		Destination temp = destinations[left];
		destinations[left] = destinations[right];
		destinations[right] = temp;
	}
	
	public double getTotalTime() {
		double sum=0;
		int count=0;
		for(Destination d: destinations) {
			if(d.waitTime>=30.0) {
				++count;
			}
			sum+=d.waitTime;
		}
		System.out.println(count);
		return sum;
	}
	
	public void displayRoute() {
		for(int i = 0; i<= destinations.length-1;i++) {
			System.out.print((destinations[i].id>0)?destinations[i].id+",":"" );
		}
		System.out.println("");
	}
	
}
