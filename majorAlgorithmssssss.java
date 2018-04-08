/**
 * SPEED GOGGLES : RUNNER CLASS
 */
class Runner {
	public static ArrayList<Runner> list = new ArrayList<Runner>();
    private static double earthRadius = 3959;
    //just an approximation
    public static double getMiles(Runner A, Runner B) {
    	double dlat = B.latitude - A.latitude;
    	return earthRadius * Math.sqrt(Math.pow(dlat, 2) + Math.pow(Math.cos(dlat * Math.pow(B.longitude - A.longitude, 2) / 2), 2));
    }
    private static double score(Runner A, Runner B) {
    	double 	d_pace = Math.abs(pace - R.pace),
    			d_mileage = Math.abs(),
    			d_age = Math.abs(age - R.age), 
    			d_proximity = getMiles(this, R);
    	int d_sex = (preferredSex !== R.sex);
    	return ((p.pace * d_pace) + (p.mileage * d_mileage) + (p.age * d_age) + (p.proximity * d_proximity)) * (p.sex * (1 + (d_sex)));
    }
    //master algorithm here
    public static Runner next(Runner R) {
    	int minIndex = 0;
    	double minScore = score(this, R);
		//HOW TO GET SIZE OF ARRAYLIST??
		double s = minScore;
    	for(int i = 1; i < Runner.list.size(); i ++) {
    		if(!matched.contains(Runner.list[i]) && Runner.list[i].id !== this.id) {
				s = score(this, Runner.list[i]);
				if(s < minScore) {
					minIndex = i;
					minScore = s;
				}
    		}
    	}
    	matched.add(Runner.list[minIndex]);
    	return Runner.list[minIndex];
    }    
    
    private Preferences p;
    private int id; // unique to this object
    private String firstname, lastname; 
    private boolean sex; // 0 == 'M', 1 == 'F'
    private boolean preferredSex = 0; // SHOULD BE GIVEN DEFAULT VALUE JUST IN CASE THERE IS NO PREFERENCE
    private double pace; // way to write: 7:45 mins/mile = 7 + (45 / 60) = 7.75
    private double latitude, longitude; // to judge location
    private double age;
    private double mileage;
    private String city, state, country; 
    private String profile; //picture 124x124
    ArrayList<Conversation> matched = new ArrayList<Conversation>(); // Friends + already matched before, friends coming from SQL, "friend" is a string assigned to each person saying pending vs. accepted vs. blocked
}

class Conversation {
	public Runner runner;
	public ArrayList<Message> conversation = new ArrayList<Message>();
	public Conversation(Runner R) {
		runner = R;
	}
}

class Message {
	public Runner runner;
	public String text;
	public String timestamp;
	public Message(Runner R, String text) {
		text = text;
		runner = R;
	}
}

class Preferences {
	// THESE NUMBERS SHOULD BE >= 0 AND HAVE NO UPPER BOUND, BUT ARE SCALE-INVARIANT, SO THESE 5-TUPLES EXIST IN RP^1
	// SEX > PROXIMITY > PACE = MILEAGE > AGE.
	public static double 	PACE = 0.5, 
							MILEAGE = 0.5,
							AGE = 0.35, 
							PROXIMITY = 0.8,
							SEX = 1;
	
	public double pace, mileage, age, proximity, sex;
	public Preferences() {
		pace = pace != null ? pace : PACE;
		mileage = mileage != null ? mileage : MILEAGE;
		age = age != null ? age : age;
		proximity = proximity != null ? proximity : PROXIMITY;
		sex = sex != null ? sex : SEX;
	}
}