from threading import Thread
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait


#create WebDriver instance
with webdriver.Firefox() as driver:

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

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
    # Verify that the “Directory” menu item is visible and clickable
    print("“Directory” menu item is visible : " , driver.find_element(By.XPATH, "//a[@id='menu_directory_viewDirectory']").is_displayed())
    print("“Directory” menu item is clickable : " , driver.find_element(By.XPATH, "//a[@id='menu_directory_viewDirectory']").is_enabled())

    driver.find_element(By.XPATH, "//a[@id='menu_directory_viewDirectory']").click()
    print("Clicked on Directory tab")
    message = driver.find_element(By.XPATH, "//div[@class='head']").text
    print("You are on " , message)
#--------------------------------------------------------------------------------------------------

    #close the browser
    driver.quit()