package com.flexicondev.mangatracker;

import java.util.ArrayList;
import java.util.List;

public class Manga {
    public String mangaId;
    public String name;
    public String href;
    public List<String> author = new ArrayList<String>();
    public List<String> artist = new ArrayList<String>();
    public String status;
    public int yearOfRelease;
    public List<String> genres = new ArrayList<String>();
    public String info;
    public String cover;
    public String lastUpdate;
    public List<mChapter> chapters = new ArrayList<mChapter>();

    public class mChapter {
        public int chapterId;
        public String name;
    }
}