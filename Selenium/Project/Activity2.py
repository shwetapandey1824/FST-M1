from selenium import webdriver
from selenium.webdriver.common.by import By

#create WebDriver instance
with webdriver.Firefox() as driver:

    #go to web page
    driver.get("http://alchemy.hguy.co/orangehrm")

    #do the stuff on the page
    pageTitle = driver.title
    print("Title of the page is : " + pageTitle)

    image = driver.find_element(By.TAG_NAME, "img").get_attribute("src")
    print("Image URL is - " + image)
	
    
    #close the browser
    driver.quit()