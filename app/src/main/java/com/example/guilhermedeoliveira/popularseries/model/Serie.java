package com.example.guilhermedeoliveira.popularseries.model;

/**
 * Created by guilhermeoliveira on 11/10/16.
 */

public class Serie {


    /**
     * title : Game of Thrones
     * year : 2011
     * ids : {"trakt":1390,"slug":"game-of-thrones","tvdb":121361,"imdb":"tt0944947","tmdb":1399,"tvrage":24493}
     */

    private String title;
    private int year;
    /**
     * trakt : 1390
     * slug : game-of-thrones
     * tvdb : 121361
     * imdb : tt0944947
     * tmdb : 1399
     * tvrage : 24493
     */

    private IdsBean ids;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public IdsBean getIds() {
        return ids;
    }

    public void setIds(IdsBean ids) {
        this.ids = ids;
    }

    public static class IdsBean {
        private int trakt;
        private int tvdb;
        private int tmdb;
        private int tvrage;

        public int getTrakt() {
            return trakt;
        }

        public void setTrakt(int trakt) {
            this.trakt = trakt;
        }

        public int getTvdb() {
            return tvdb;
        }

        public void setTvdb(int tvdb) {
            this.tvdb = tvdb;
        }

        public int getTmdb() {
            return tmdb;
        }

        public void setTmdb(int tmdb) {
            this.tmdb = tmdb;
        }

        public int getTvrage() {
            return tvrage;
        }

        public void setTvrage(int tvrage) {
            this.tvrage = tvrage;
        }
    }
}
