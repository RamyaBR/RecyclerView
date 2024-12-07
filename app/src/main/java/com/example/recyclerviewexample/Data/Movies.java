package com.example.recyclerviewexample.Data;

public class Movies {
   public String Title;
    public String Director;
  public   String Poster;

    @Override
    public String toString() {
        return "Movies{" +
                "Title=" + Title +
                ", Director='" + Director + '\'' +
                ", Poster='" + Poster + '\'' +
                '}';
    }
}
