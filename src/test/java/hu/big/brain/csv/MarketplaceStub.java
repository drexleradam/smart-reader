package hu.big.brain.csv;

import hu.big.brain.model.Marketplace;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceStub {

    public static List<Marketplace> getMarketplaceStubs() {
        List<Marketplace> list = new ArrayList<>();
        list.add(Marketplace.builder().id(1).name("EBAY").build());
        list.add(Marketplace.builder().id(2).name("AMAZON").build());
        return list;
    }
}
