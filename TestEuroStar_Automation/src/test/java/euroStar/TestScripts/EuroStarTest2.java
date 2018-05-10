package euroStar.TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import euroStar.MasterFile.Base;
import euroStar.pageobject.EuroStarLoginPage;

public class EuroStarTest2 extends Base {

	@Test(dataProvider = "data")
	public void webTitle(Map<Object, Object> map) throws Exception {

		System.out.println("-------------Test case started ----------------");
		System.out.println(map.get("Eamil_ID"));
		System.out.println(map.get("Password"));
		System.out.println("-------------Test case Ended ----------------");

		EuroStarLoginPage euroLoginPage = PageFactory.initElements(driver, EuroStarLoginPage.class);

		euroLoginPage.loginToEuroStarAccount(map.get("Eamil_ID").toString(), map.get("Password").toString());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String expectedTitle = "LinkedIn";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectedTitle, "Title mismatched!!");

	}

	//TODO
	@DataProvider(name = "data")
	public Object[][] dataSupplier() throws IOException {
		File file = new File("C://TestData//TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		// wb.close();
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][1];
		for (int i = 0; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
			}
			obj[i][0] = datamap;
		}
		return obj;
	}

}
