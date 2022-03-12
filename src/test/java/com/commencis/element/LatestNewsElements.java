package com.commencis.element;

import org.openqa.selenium.By;

public class LatestNewsElements {

    public static final By AUTHORS = By.cssSelector("span[class='river-byline__authors']");
    public static final By IMAGES = By.cssSelector("footer > figure[class='post-block__media']");
    public static final By ARTICLES = By.cssSelector("article[class='post-block post-block--image post-block--unread'] > header > h2");
    public static final By ARTICLETITLE = By.cssSelector("h1[class ='article__title']");
    public static final By NEWSCONTENTS = By.cssSelector("div[class='article-content'] > p > a");
}
