from threading import Thread
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
from selenium.webdriver import Keys
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support.select import Select as select

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

    #Navigate to the Dashboard page and click on the Apply Leave option
    
    leave = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img")
    builder.move_to_element(leave).pause(5).click(leave).pause(5).perform()

    message = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[1]/div[1]/h1").text
    print("You are on " + message)

    #Select leave type and duration of the leave. Click Apply.
    driver.find_element(By.XPATH, "//select[@id='applyleave_txtLeaveType']/option[@value='1']").click()
    time.sleep(1)

    driver.find_element(By.XPATH, "//input[@id='applyleave_txtFromDate']").clear()
    driver.find_element(By.XPATH, "//input[@id='applyleave_txtFromDate']").send_keys("2025-02-04")
    
    driver.find_element(By.XPATH, "//input[@id='applyleave_txtToDate']").clear()
    driver.find_element(By.XPATH, "//input[@id='applyleave_txtToDate']").send_keys("2025-02-04")
    builder.pause(2).send_keys(Keys.ENTER).perform()

    time.sleep(1)

    leaveText = driver.find_element(By.XPATH, "//textarea[@id='applyleave_txtComment']")
    leaveText.clear()
    leaveText.send_keys("archana test leaves Feb for 1 day")
   
    time.sleep(1)

    driver.find_element(By.XPATH, "//input[@id='applyBtn']").click()
    
    time.sleep(5)

    print("Leave applied...!!!")
    
    #Navigate to the My Leave page to check the status of the leave application.
    #Find the “My Leave” menu item and click it.
    
    #driver.find_element(By.XPATH, "//a[@id='menu_leave_viewLeaveModule']").click()
    #print("Clicked on Leave tab")

    driver.find_element(By.XPATH, "//a[@id='menu_leave_viewMyLeaveList']").click()
    print("Clicked on My Leave tab")

    #get detail form result table
    #Find the number of columns from header in the table and print them.
    
    cols = driver.find_elements(By.XPATH, "//table[@id='resultTable']/thead/tr/th")
    print("total number of columns in header: " , len(cols))

    #Find the number of rows in the table and print them. 
    row = driver.find_elements(By.XPATH, "//table[@id='resultTable']/tbody/tr")
    print("total number of rows : " , len(row))

    foundFlag = False
    for i in range(1, len(row)+1) : 

        #Find and print all the cell values in the first row of the table.
        path = "//table[@id='resultTable']/tbody/tr[" + str(i) + "]"
        rowData = driver.find_elements(By.XPATH,  path)
        
        print(i, " row cell values: ")
        for cell in rowData:
            print(cell.text)

            #check the comment
            if cell.text.find("archana test leaves Feb for 1") != -1 :
                print("Records Found..!!")
                foundFlag = True

                path = "//table[@id='resultTable']/tbody/tr[" + str(i) + "]/td[6]"
                status = driver.find_element(By.XPATH, path)

                print("Current leave status is : " , status.text)
                
        if foundFlag:
            break

        i+=1

    if foundFlag :
        print("Records Found..!!")
    else :
        print("Records not Found..!!")

#--------------------------------------------------------------------------------------------------

    #close the browser
    driver.quit()