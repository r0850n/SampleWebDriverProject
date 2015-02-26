package Ent;

public enum Radius {

	MILES_5, MILES_10, MILES_25, MILES_50, MILES_100;

	@Override
	public String toString() {
		switch (this) {
		case MILES_5:
			return "5 miles";
		case MILES_10:
			return "10 miles";
		case MILES_25:
			return "25 miles";
		case MILES_50:
			return "50 miles";
		case MILES_100:
			return "100 miles";
		}
		return null;
	}

}
