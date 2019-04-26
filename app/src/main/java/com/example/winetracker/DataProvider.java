package com.example.winetracker;

import com.example.winetracker.Wine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static List<Wine> wines = new ArrayList<Wine>();
    public static Map<String, Wine> wineMap = new HashMap<>();

    public static void addWine(Wine wine)
    {
        wines.add(wine);
        wineMap.put(wine.getId(), wine);
    }
    public static List<String> getItemNames()
    {
        List<String> list = new ArrayList<>();
        for (Wine wine : wines)
        {
            list.add(wine.getName());
        }
        return list;
    }

    public static List<Wine> getFilteredList(String search)
    {
        List<Wine> wines = new ArrayList<>();

        for (Wine wine : wines)
        {
            if (wine.getId().contains(search))
                wines.add(wine);
        }
        return wines;
    }
    static
    {
        addWine(new Wine("WitchingHour",
                "Red Blend Witching Hour",
                "Delicious. Witching Hour produces Red Blends with deep robust flavors that consume the senses. Layered with full-bodied notes like dark cherries, espresso and vanilla, these reds are extravagantly bold.",
                9.99));

        addWine(new Wine("BoneDry",
                "Bone Dry Red – Cabernet Sauvignon",
                "Oak is the most prevalent characteristic on the nose, but it comes to life in an eerie way, it has a somewhat floral aroma that smells like hops—as in the hops you’d find in a hoppy ale.  Odd, but not offensive.  There’s a bit of dark cherry in the nose as well, but it takes a back seat to the oak.",
                14.99));

        addWine(new Wine("Phantom",
                "Bogle Phantom Red",
                "Enticing and enveloping, this mysterious apparition of ripe berry and relentless spice, returns to tantalize wine lovers. Emerging from the shadows with concentration and intensity, this wine will haunt you with every sip. Black pepper, juniper and cranberry spark your senses, while a rustic jamminess soothes your soul with its familiarity. Full bodied flavors of black plums and berries bewitch the palate.",
                18.99));

        addWine(new Wine("Poison",
                "Armida Poizin Dry Creek Valley Zinfandel 2016",
                "A lush, delicious, and \"serious\" wine but in a fun package! The nose is fruit driven with fresh plum, bing cherry, spicy peppercorn and zinberry. The mouthfeel is soft with a hint of milk chocolate, sweet oak, and a long vanilla finish. The deep color and firm structure are enhanced by the addition of the Petite Sirah and the firm tannins softened by moderate oak. Enjoy this POIZIN with caution; it is The Wine to Die for!",
                19.99));

        addWine(new Wine("Vampire",
                "Vampire Vineyards Pinot Noir 2008",
                "2018 HOWL At The MOON Party 13% ALC, Blood red Light and Perfumed Pinot Noir, Great addition to the Party’s theme! Strawberry Jam Pomegranate Black Cherry Medium body Vanilla Spicy Smokey Soft Velvet finish",
                12.99));
    }
}
