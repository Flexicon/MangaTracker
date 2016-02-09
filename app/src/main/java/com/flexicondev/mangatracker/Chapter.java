package com.flexicondev.mangatracker;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    public String href;
    public String name;
    public List<Page> pages = new ArrayList<Page>();
    public String lastUpdate;

    public class Page {
        public int pageId;
        public String url;
    }
}
