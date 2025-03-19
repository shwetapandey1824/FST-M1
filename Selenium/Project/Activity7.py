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
    #Add employee qualifications

    #Find the “My Info” menu item and click it.
    #driver.find_element(By.XPATH, "//a[@id='menu_pim_viewMyDetails']").click()

    leave = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]")

    builder.move_to_element(leave).pause(5).click(leave).pause(10).perform()
    print("Clicked on My Info tab")

    message = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[1]/h1").text
    print("You are on " + message)

    #On the new page, find the Qualification option on the left side menu and click it.
    driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a").click()
    print("Clicked on Qualifications")

    #Add Work Experience and click Save.
    driver.find_element(By.XPATH, "//input[@id='addWorkExperience']").click()
    print("Clicked on addWorkExperience")

    message = driver.find_element(By.CSS_SELECTOR, "div[id='changeWorkExperience'] div[class='head']").text
    print("You are on " + message)

    driver.find_element(By.ID, "experience_employer").clear()
    driver.find_element(By.ID, "experience_employer").send_keys("AAA Test Company")

    driver.find_element(By.ID, "experience_jobtitle").clear()
    driver.find_element(By.ID, "experience_jobtitle").send_keys("Automation Tester")

    driver.find_element(By.ID, "experience_from_date").clear()
    driver.find_element(By.ID, "experience_from_date").send_keys("2021-07-01")

    driver.find_element(By.ID, "experience_comments").clear()
    driver.find_element(By.ID, "experience_comments").send_keys("Total 3 years of experience.")

    driver.find_element(By.XPATH, "//input[@id='btnWorkExpSave']").click()
    print("Work Experience Information saved successfully..!!")

#--------------------------------------------------------------------------------------------------

    #close the browser
    driver.quit()