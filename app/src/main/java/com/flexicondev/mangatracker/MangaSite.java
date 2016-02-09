package com.flexicondev.mangatracker;

import java.util.ArrayList;
import java.util.List;

public class MangaSite {
    public String siteId;
    public List<String> mangaProperties = new ArrayList<String>();
    public List<Genre> genres = new ArrayList<Genre>();

    public class Genre {
        public String genreId;
    }
}