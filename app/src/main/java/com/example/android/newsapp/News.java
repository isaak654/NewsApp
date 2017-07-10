package com.example.android.newsapp;

/**
 * A {@link News} object contains information related to a single article.
 */

public class News {

    //Title of the article
    private String mTitle;

    /**
     * Category of the article
     */
    private String mCategory;

    /**
     * URL of the article
     */
    private String mUrl;

    /**
     * Date of the article
     */
    private String mDate;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title  is the title of the article
     * @param category  is the category of the article
     * @param url    is the URL of the article
     */
    public News(String title, String category, String url, String date) {
        mTitle = title;
        mCategory = category;
        mUrl = url;
        mDate = date;
    }

    /**
     * Returns the title of the article
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the category of the article
     */
    public String getCategory() {
        return mCategory;
    }

    /**
     * Returns the URL of the article
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the date of the article
     */
    public String getDate() {
        return mDate;
    }
}