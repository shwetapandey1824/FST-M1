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
    #Retrieve Emergency Contacts
		
	#Find the “My Info” menu item and click it.
    leave = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]")
		
    builder.move_to_element(leave).pause(10).click(leave).pause(10).perform()
    print("Clicked on My Info tab")
		
    message = driver.find_element(By.XPATH, "//h1[normalize-space()='Personal Details']").text
    print("You are on " , message)
		
    #On the new page, Click on the “Emergency Contacts” on the left side menu
    driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a").click()
    print("Clicked on Emergency Contacts")

    #Retrieve information about all the contacts listed in the table.
    #Print all the information to the console

    #Find the number of columns from header in the table and print them.
    cols = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr/th")
    print("total number of columns in header: " , len(cols))

    #Find the number of rows in the table and print them. 
    row = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr")
    print("total number of rows : " , len(row))

    for i in range(1, len(row)+1) :

        #Find and print all the cell values in the first row of the table.
        path =  "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[" + str(i) + "]"
        rowData = driver.find_elements(By.XPATH, path)

        print(i , " row cell values: ")
        for cell in rowData:
            print(cell.text)

#--------------------------------------------------------------------------------------------------

    #close the browser
    driver.quit()
