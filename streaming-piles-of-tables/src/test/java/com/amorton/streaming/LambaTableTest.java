package com.amorton.streaming;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by amorton on 24/07/2016.
 */
public class LambaTableTest {

    WebDriver driver;

    @Test
    public void shouldFindMatchingTableRow() {
        driver = new ChromeDriver();
        driver.get("http://localhost:4567");

        WebElement row = tableRows().stream()
                .filter(e -> e.findElement(By.xpath("td[2]")).getText().trim().equals("Fifth"))
                .findFirst()
                .get();

        assertThat("Row text should be 'Fourth Fifth Sixth'", row.getText(), equalTo("Fourth Fifth Sixth"));
    }

    private List<WebElement> tableRows() {
        return driver.findElements(By.tagName("tr"));
    }

}
