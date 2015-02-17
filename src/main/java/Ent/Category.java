package Ent;

public enum Category {
	MOTO, MOUNTAIN_BIKING, ROAD_CYCLING, RUNNING, SKIING,SNOWBOARDING,WATER_SPORTS ,CLIMBING,H_AND_C,FITNES,FITS,SKI,TEST_DARIUSZA;

	/*
	 * private static final String MOTO = "Moto"; private static final String
	 * MOUNTAIN_BIKING = "Mountain Biking"; private static final String
	 * ROAD_CYCLING = "Road Cycling"; private static final String RUNNING =
	 * "Running"; private static final String SKIING = "Skiing"; private static
	 * final String SNOWBOARDING= "Snowboarding"; private static final String
	 * WATER_SPORTS= "Water Sports"; private static final String CLIMBING=
	 * "Climbing"; private static final String H_AND_C= "Hiking and Camping";
	 * private static final String FITNES= "Fitness"; private static final
	 * String FITS= "Fun in the Sun"; private static final String SKI=
	 * "Ski / Snowboard"; private static final String TEST_DARIUSZA=
	 * "Test Dariusza";
	 */

	@Override
	public String toString() {
		switch (this) {
		case MOUNTAIN_BIKING:
			return "Mountain Biking";
		case ROAD_CYCLING:
			return "Road Cycling";
		case MOTO:
			return "Moto";
		case RUNNING:
			return "Running";
		case TEST_DARIUSZA:
			return "Test Dariusza";
		case SKIING:
			return "Skiing";
		case SNOWBOARDING:
			return "Snowboarding";
		case WATER_SPORTS:
			return "Water Sports";
		case CLIMBING:
			return "Climbing";
		case H_AND_C:
		return "Hiking and Camping";
		case FITNES:
			return "Fitness";
		case FITS:
			return "Fun in the Sun";
		case SKI:
			return "Ski / Snowboard";
		}
		return null;
	}

}
