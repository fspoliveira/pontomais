package br.com.pontomais.time.shit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PontoMaisTimeShitApontatorTabajara {

	private static WebDriver driver;
	private static final String PONTO_MAIS_WEB = "https://app.pontomaisweb.com.br/#/meu_ponto/registro_de_ponto";
	private static final String CPF = "X";
	private static final String SENHA = "Y";

	public static void main(String[] args) throws InterruptedException {

		String currentDir = System.getProperty("user.dir");
		System.out.println("Current dir using System:" + currentDir);

		System.out.println("Setting webdriver for Google Chrome, find file chromedriver.exe in directory" + currentDir);
		System.setProperty("webdriver.chrome.driver", currentDir.concat("\\chromedriver.exe"));

		driver = new ChromeDriver();

		// Login
		System.out.println("Login in main page");
		driver.get(PONTO_MAIS_WEB);

		// Aguarda renderizar o campo senha
		WebDriverWait waitPassword = new WebDriverWait(driver, 30);
		waitPassword.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[title*='Sua senha*']"))));

		// Input dados
		driver.findElement(By.cssSelector("[title*='Seu e-mail ou CPF*']")).sendKeys(CPF);
		driver.findElement(By.cssSelector("[title*='Sua senha*']")).sendKeys(SENHA);
		driver.findElement(By.xpath("//*[contains(text(),'Entrar')]")).click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[contains(text(),'Registrar ponto')]")).click();
		
		Thread.sleep(10000);


		driver.quit();
	}
}
