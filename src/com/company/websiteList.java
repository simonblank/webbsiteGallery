package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by simon blank on 2017-01-21.
 */
public class websiteList {
    List<String> websites = new ArrayList<>();
    List<String> websitestittles = new ArrayList<>();

    public websiteList() {
        loadWebsites();
        loadWebsiteTitles();
    }

    public int getWebsiteAmount(){
        return websites.size();
    }

    public String getNextWebsite(int x){
        return websites.get(x);
    }

    public String getNextWebsiteTittle(int x){
        return websitestittles.get(x);
    }


    public void loadWebsites(){
        websites.add("http://www.youtube.com");
        websites.add("http://www.facebook.com");
        websites.add("http://www.msn.com");
        websites.add("http://www.aftonbladet.se");
        websites.add("http://www.broqvistkonditori.se");

    }

    public void loadWebsiteTitles(){

        websitestittles.add("youtube");
        websitestittles.add("facebook");
        websitestittles.add("msn");
        websitestittles.add("aftonbladet");
        websitestittles.add("broqvistkonditori");
    }

    public void addToList( String webbsiteUrl , String webbsiteName){
        websites.add(webbsiteUrl);
        websitestittles.add(webbsiteName);
    }

    public void removeFromList(int whatWebsiteToRemove){
        websites.remove(whatWebsiteToRemove);
        websitestittles.remove(whatWebsiteToRemove);



    }



}
