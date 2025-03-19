from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains as builder
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait


#create WebDriver instance
with webdriver.Firefox() as driver:

    firstName = "Test123a"
    lastName = "Test123a"
    
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
    # Add Employee To PIM tab
    # Find the PIM option in the menu and click it.
    pimMenu = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewPimModule\"]")
    print("name of header - " , pimMenu.text)

    pimMenu.click()

    # Add button to add employee
    #addButton = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_addEmployee\"]")
    addButton = driver.find_element(By.XPATH, "//input[@id=\"btnAdd\"]")
    
    # add explicit wait until Add button clickable
    wait.until(ExpectedConditions.element_to_be_clickable(addButton))

    # Verify that the add employee page has opened
    message = driver.find_element(By.XPATH, "//div[@id='employee-information']").text
    print("You are on " , message)

    #click the Add button
    addButton.click()
	
    # Verify that the add employee page has opened
    message = driver.find_element(By.XPATH, "//h1[normalize-space()='Add Employee']").text
    print("You are on " , message)

    driver.find_element(By.XPATH, "//*[@id=\"firstName\"]").send_keys(firstName)
    driver.find_element(By.XPATH, "//*[@id=\"lastName\"]").send_keys(lastName)
    	
    driver.find_element(By.XPATH, "//*[@id=\"btnSave\"]").click()
    
    print("New user created with First Name - " , firstName , " Last Name - ", lastName)
    
#--------------------------------------------------------------------------------------------------
	
    # search Employee To PIM
    # Find the PIM option in the menu and click it.
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewPimModule\"]").click()
	
    # click on Employee list
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewEmployeeList\"]").click()
				
	# Verify that the add employee page has opened
    message = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[1]/a").text
    print("You are on " , message)
        
    input = firstName + " " + lastName
    print("Searching for employee : " , input)
		
    employee = driver.find_element(By.XPATH, "//*[@id=\"empsearch_employee_name_empName\"]")
    employee.send_keys(input)
    employee.click()
    
    searchData = driver.find_elements(By.XPATH, "//div[@class=\"ac_results\"]/ul/li")
    
    print("Dropdown list size : " , len(searchData))

    print("Select name from dropdown : ")    
	
    #iterate the dropdown list
    for searchDataCell in searchData :
        
        print(searchDataCell.text)
            
        if  searchDataCell.text == input :
            print("Match found, selecting the option : " , searchDataCell.text)
            searchDataCell.click()
            print("Clicked!")
            break
            
        else :
            print("Match not found, selecting next option ")
	    

    # click on search button  
    driver.find_element(By.XPATH, "//*[@id=\"searchBtn\"]").click()
    
#--------------------------------------------------------------------------------------------------

    # get detail form result table
    # Find the number of columns from header in the table and print them.
    cols = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr/th")
    print("total number of columns in header: " , len(cols))
        
    # Find the number of rows in the table and print them. 
    row = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr")
    print("total number of rows in header: " , len(row))

    for rowData in row :
	     	
	    # Find and print all the cell values in the first row of the table.
        print(" row cell values: ", rowData.text)
	    	
        if rowData.text == "No Records Found" :
            print("No Records Found..!!")
            break
    	
        else :
            cols = rowData.find_elements(By.TAG_NAME, "td") 
            print("User First Name : ", cols[1].text)
            print("User Last Name : ", cols[2].text)


#--------------------------------------------------------------------------------------------------

    #close the browser
    driver.quit()