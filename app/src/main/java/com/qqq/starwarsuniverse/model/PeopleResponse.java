package com.qqq.starwarsuniverse.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qqq on 09.06.2016.
 */
public class PeopleResponse {
    @SerializedName("count")
    private int mCount;

    @SerializedName("next")
    private String mNext;

    @SerializedName("previous")
    private String mPrevious;

    @SerializedName("results")
    private List<People> mResults;

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

    public String getNext() {
        return mNext;
    }

    public void setNext(String next) {
        mNext = next;
    }

    public String getPrevious() {
        return mPrevious;
    }

    public void setPrevious(String previous) {
        mPrevious = previous;
    }

    public List<People> getResults() {
        return mResults;
    }

    public void setResults(List<People> results) {
        mResults = results;
    }
}
