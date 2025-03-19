from threading import Thread
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait


#create WebDriver instance
with webdriver.Firefox() as driver:

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    builder = ActionChains(driver)

    #go to web page
    driver.get("http://alchemy.hguy.co/orangehrm")

    #do the stuff on the page
    pageTitle = driver.title
    print("Title of the page is : " + pageTitle)

#--------------------------------------------------------------------------------------------------
    
    # enter credentials in the username and password fields
    driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]").send_keys("orange")
	
    driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]").send_keys("orangepassword123")
	
	#click submit button
    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()
    
    # Print the title of the new page
    pageTitle = driver.title
    print("New page title is: ", pageTitle)

    # Read login message
    print("Confirmation message is - " , driver.find_element(By.ID, "welcome").text)

	#Print the confirmation message
    message = driver.find_element(By.TAG_NAME, "h1")
    print("You are on : ", message.text)
    
#--------------------------------------------------------------------------------------------------

    #Find the “My Info” menu item and click it.
    #driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click()

    leave = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]")

    builder.move_to_element(leave).pause(5).click(leave).pause(5).perform()

    print("Clicked on My Info tab")

    message = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[1]/h1").text
    print("You are on " , message)

    #Find the “Edit” menu item and click it.
    driver.find_element(By.XPATH, "//input[@id='btnSave']").click()

    #Fill in the Name, Gender, Nationality, and the DOB fields. and Click Save.
    driver.find_element(By.ID, "personal_txtEmpFirstName").clear()
    driver.find_element(By.ID, "personal_txtEmpFirstName").send_keys("Archana")

    driver.find_element(By.ID, "personal_txtEmpLastName").clear()
    driver.find_element(By.ID, "personal_txtEmpLastName").send_keys("Gidavir")

    driver.find_element(By.ID, "personal_optGender_2").click()

    driver.find_element(By.ID, "personal_DOB").clear()
    driver.find_element(By.ID, "personal_DOB").send_keys("1990-04-28")

    driver.find_element(By.XPATH, "//input[@id='btnSave']").click()
    print("New Information saved successfully..!!")

    # Thread.sleep(20)
    wait.until(ExpectedConditions.visibility_of(driver.find_element(By.ID, "personal_txtEmpFirstName")))

    print("Updated First Name : " , driver.find_element(By.ID, "personal_txtEmpFirstName").get_attribute("value"))
    print("Updated Last Name : " , driver.find_element(By.ID, "personal_txtEmpLastName").get_attribute("value"))
    print("Updated Gender : " , driver.find_element(By.ID, "personal_optGender_2").is_selected())
    print("Updated DOB : " , driver.find_element(By.ID, "personal_DOB").get_attribute("value"))

#--------------------------------------------------------------------------------------------------

    #close the browser
    driver.quit()