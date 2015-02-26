package Ent;

public enum SortBy {
	
	HAPPENING_SOON, MOST_RECENT_ADDED, DISTANCE; 
	
	@Override
	public String toString() {
		switch (this) {
		case HAPPENING_SOON:
			return "Happening soon";
		case MOST_RECENT_ADDED:
			return "Most recently added";
		case DISTANCE:
			return "Distance";
		}
		return null;
	}

}
