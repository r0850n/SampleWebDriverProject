package Ent;

public enum Paces {
	
	SLOW_AND_STADY,SOCIAL,WORKOUT,ADVENTURING,RACE,NO_BS;
	
	@Override
	public String toString() {
		switch (this) {
		case SLOW_AND_STADY:
			return "Slow & Steady";
		case SOCIAL:
			return "Social";
		case WORKOUT:
			return "Workout";
		case ADVENTURING:
			return "Adventuring";
		case RACE:
			return "Race";
		case NO_BS:
			return "No BS!";
				
		}
		return "Slow & Steady";
	}

}
