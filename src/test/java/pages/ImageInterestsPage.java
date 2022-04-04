package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import utils.DataSettingsUtils;
import utils.UploadRobotUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageInterestsPage extends Form {
    private final ICheckBox unselectAllCheckbox = AqualityServices.getElementFactory().getCheckBox(By.xpath("//div[@class = 'avatar-and-interests__interests-list__item' and contains(.,'Unselect all')]//label[@class = 'checkbox__label']"), "Unselect all");
    private final IButton nextButton2 = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(.,'Next')]"), "Next button 2");
    private final IButton uploadImageButton = AqualityServices.getElementFactory().getButton(By.className("avatar-and-interests__upload-button"), "Upload image button");

    public ImageInterestsPage(By locator, String name) {
        super(locator, name);
    }

    public static void createInterests() {
        List<ILabel> lis = AqualityServices.getElementFactory().findElements(By.xpath("//div[@class='avatar-and-interests__interests-list__item']"), ElementType.LABEL);
        ArrayList<String> list = new ArrayList<>();
        for (ILabel li : lis) {
            list.add(li.getText());
        }
        while (list.size() > 18) {
            Random r = new Random();
            int l = r.nextInt(list.size());
            String randomElement = list.get(l);
            if (list.contains(randomElement)) {
                if (randomElement.equals("Select all"))
                    continue;
                if (randomElement.equals("Unselect all"))
                    continue;
                AqualityServices.getElementFactory().getCheckBox(By.xpath("//div[@class='avatar-and-interests__interests-list__item' and contains(., '" + randomElement + "')]//label[@class='checkbox__label']"), "Interest checkbox").click();
                list.remove(randomElement);
            }
        }
    }

    public void uploadImageAndInterestsFormActions() throws AWTException, InterruptedException {
        unselectAllCheckbox.click();
        createInterests();
        imageUpload();
        nextButton2.click();
    }

    public void imageUpload() throws AWTException, InterruptedException {
        uploadImageButton.click();
        UploadRobotUtils.uploadImage(DataSettingsUtils.getElement("path"));
    }

    public String getUploadImageButtonText() {
        return uploadImageButton.getText();
    }
}
