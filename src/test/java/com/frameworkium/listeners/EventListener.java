package com.frameworkium.listeners;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListener implements WebDriverEventListener {

    private static final Logger logger = LogManager.getLogger(EventListener.class);

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        logger.debug("changed value of element with " + getLocatorFromElement(element));
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.debug("clicked element with " + getLocatorFromElement(element));
    }

    @Override
    public void afterFindBy(By by, WebElement arg1, WebDriver arg2) {
        logger.debug("found element " + by);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        logger.debug("after back");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        logger.debug("after forward");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        logger.debug("navigated to " + url);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        logger.debug("ran script " + script);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        logger.debug("change value of element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.debug("click element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver arg2) {
        logger.debug("find element " + by);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        logger.debug("before back");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        logger.debug("before forward");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.debug("navigate to " + url);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        logger.debug("running script " + script);
    }

    @Override
    public void onException(Throwable thrw, WebDriver driver) {
        // Lots of caught exceptions being logged here
        logger.trace("Event listener onException().", thrw);
    }

    private String getLocatorFromElement(WebElement element) {
        String str = element.toString();
        Pattern p = Pattern.compile("->\\s(.*)(?=\\])");
        Matcher m = p.matcher(str);
        return m.find() && m.groupCount() > 0 ? m.group(1) : str;
    }
}
