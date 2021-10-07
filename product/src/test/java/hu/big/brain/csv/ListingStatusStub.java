package hu.big.brain.csv;

import hu.big.brain.model.ListingStatus;

import java.util.ArrayList;
import java.util.List;

public class ListingStatusStub {
	
	public static List<ListingStatus> getListingStatusStubs() {
		List<ListingStatus> list = new ArrayList<>();
		list.add(ListingStatus.builder().id(1).name("ACTIVE").build());
		list.add(ListingStatus.builder().id(2).name("SCHEDULED").build());
		list.add(ListingStatus.builder().id(3).name("CANCELLED").build());
		return list;
	}
}
