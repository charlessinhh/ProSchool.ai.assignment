package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {
    public static void captureScreenshot(WebDriver driver) {
        // Generate screenshot file name with timestamp
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = dtf.format(now);
        String screenshotName = "screenshot_" + timestamp + ".png";

        // Take screenshot as file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot
        Path dest = Paths.get("screenshots", screenshotName);

        try {
            // Save the screenshot to the specified path
            Files.createDirectories(dest.getParent());
            Files.copy(screenshot.toPath(), dest);
            System.out.println("Screenshot saved: " + dest.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}

